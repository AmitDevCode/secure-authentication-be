FROM bellsoft/liberica-openjdk-alpine:21 AS builder
RUN addgroup -g 1001 -S appuser && \
    adduser -u 1001 -S appuser -G appuser
WORKDIR /app
RUN chown -R appuser:appuser /app
USER appuser
COPY --chown=appuser:appuser gradlew ./
COPY --chown=appuser:appuser gradle gradle/
RUN chmod +x gradlew
COPY --chown=appuser:appuser build.gradle.kts settings.gradle.kts ./
RUN ./gradlew dependencies --no-daemon --refresh-dependencies
COPY --chown=appuser:appuser src ./src
RUN ./gradlew clean bootJar --no-daemon -x test --info

FROM bellsoft/liberica-openjre-alpine:24
RUN addgroup -g 1001 -S appuser && \
    adduser -u 1001 -S appuser -G appuser
WORKDIR /app

COPY --from=builder --chown=appuser:appuser /app/build/libs/*.jar app.jar
USER appuser

EXPOSE 8085

ENV JAVA_OPTS="-XX:+UseG1GC \
    -XX:MaxGCPauseMillis=200 \
    -Xmx512m \
    -Xms256m \
    -XX:+UseContainerSupport \
    -XX:MaxRAMPercentage=75.0 \
    -Djava.awt.headless=true \
    -Dfile.encoding=UTF-8 \
    -Dsun.jnu.encoding=UTF-8 \
    -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
