package com.caresync.service.feedback.dtos.response;

import com.caresync.service.feedback.enums.FEEDBACK_TARGET_TYPE;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FeedbackResponse(
        Long id,
        String userId,
        FEEDBACK_TARGET_TYPE targetType,
        Long targetId,
        int rating,
        String comment,
        LocalDateTime createdAt
) {}
