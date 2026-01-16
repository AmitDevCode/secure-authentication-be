//package com.amit.security.exception;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//import java.io.IOException;
//
////@Component
////public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
////
////    @Override
////    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
////        response.setContentType("application/json");
////        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
////        String body = new ObjectMapper().writeValueAsString(ApiResponse.error("Invalid credentials", HttpStatus.UNAUTHORIZED.value()));
////        response.getWriter().write(body);
////    }
////}
//
//
//
//
//
//@Component
//public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
//
////    private final UserActivityEventPublisher activityEventPublisher;
////
////    @Autowired
////    public CustomAuthenticationFailureHandler(UserActivityEventPublisher activityEventPublisher) {
////        this.activityEventPublisher = activityEventPublisher;
////    }
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
//        System.out.println("Authentication failed: " + exception.getMessage());
//        String username = request.getParameter("email");
//        System.out.println("UserName : " + username);
//        String message;
//
//        if (exception instanceof LockedException) {
//            message = "Your account is locked";
//        } else if (exception instanceof BadCredentialsException) {
//            message = "Invalid username or password";
//        } else {
//            message = "Authentication failed";
//        }
//
//        // Publish event
////        activityEventPublisher.publish(username, "LOGIN_FAILED", message);
//
////        ApiResponse<?> body = ApiResponse.error(message, HttpStatus.UNAUTHORIZED.value());
//
//        response.setContentType("application/json");
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        response.getWriter().write(new ObjectMapper().writeValueAsString(message));
//    }
//}
