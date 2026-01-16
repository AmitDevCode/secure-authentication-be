package com.amit.security.employee.model;



import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user_activity_log")
public class UserActivityLog {
    @Id
    @UuidGenerator
    @Column(length = 36)
    @GeneratedValue(generator = "system-uuid")
    private String id;
    private String username;
    private String action;
    private String details;
    private LocalDateTime createdAt;
}
