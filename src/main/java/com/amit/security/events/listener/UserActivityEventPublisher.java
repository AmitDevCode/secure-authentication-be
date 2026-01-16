//package com.amit.security.events.service;
//
//import com.amit.security.employee.model.UserActivityLog;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.stereotype.Component;
//
//import static java.time.LocalDateTime.now;
//
//@Component
//public class UserActivityEventPublisher {
//    private final ApplicationEventPublisher eventPublisher;
//
//    @Autowired
//    public UserActivityEventPublisher(ApplicationEventPublisher eventPublisher) {
//        this.eventPublisher = eventPublisher;
//    }
//
//    @PostConstruct
//    public void init() {
//        System.out.println("✅ UserActivityEventPublisher loaded");
//    }
//
//    /**
//     * Publishes a user activity event.
//     *
//     * @param username The username associated with the activity
//     * @param action   A short label for the action (LOGIN, LOGOUT, etc.)
//     * @param details  Optional detail (e.g. "Login successful", or changed fields)
//     */
//    public void publish(String username, String action, String details) {
//        System.out.println("🔥 Publish a event for user: " + username);
//        UserActivityLog event = UserActivityLog.builder().username(username).action(action).details(details).createdAt(now()).build();
//        eventPublisher.publishEvent(event);
//    }
//}
