//package com.amit.security.exception;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
////
////    private final UserActivityEventPublisher activityEventPublisher;
////
////    @Autowired
////    public CustomAuthenticationSuccessHandler(UserActivityEventPublisher activityEventPublisher) {
////        this.activityEventPublisher = activityEventPublisher;
////    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
//        System.out.println("CustomAuthenticationSuccessHandler onAuthenticationSuccess");
////        activityEventPublisher.publish(authentication.getName(), "LOGIN", "User logged in successfully");
//
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.getWriter().write("Login successful");
//    }
//}
