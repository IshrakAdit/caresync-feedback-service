package com.caresync.service.feedback.entities;

import com.caresync.service.feedback.enums.FEEDBACK_TARGET_TYPE;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "User ID for feedback cannot be blank")
    private String userId;

    @Enumerated(EnumType.STRING)
    private FEEDBACK_TARGET_TYPE targetType;

    private Long targetId;

    @Min(1)
    @Max(5)
    private int rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    private LocalDateTime createdAt;
}

