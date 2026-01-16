package com.amit.security.exception;

import com.amit.security.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<String>> handleBadRequestException(BadRequestException ex) {
        printErrorLog(ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error("Bad Request Exception !!", HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiResponse<String>> handleBadCredentials(BadCredentialsException ex) {
        printErrorLog(ex);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error("Invalid username or password", HttpStatus.UNAUTHORIZED.value()));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse<String>> handleAuthenticationException(AuthenticationException ex) {
        printErrorLog(ex);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error("Authentication Required !!", HttpStatus.UNAUTHORIZED.value()));
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<ApiResponse<String>> handleLockedAccount(LockedException ex) {
        printErrorLog(ex);
        return ResponseEntity.status(HttpStatus.LOCKED).body(ApiResponse.error("Your account is locked", HttpStatus.LOCKED.value()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<String>> handleAccessDenied(AccessDeniedException ex) {
        printErrorLog(ex);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ApiResponse.error("You do not have permission to access this resource", HttpStatus.FORBIDDEN.value()));
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<ApiResponse<String>> handleGenericException(Exception ex) {
        printErrorLog(ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    private void printErrorLog(Exception ex) {
        System.out.println("Authentication failed: " + ex.getMessage());
        log.error("Error : {}", ex.getMessage());
    }
}