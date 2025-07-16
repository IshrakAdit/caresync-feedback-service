package com.caresync.service.feedback.dtos.request;

import com.caresync.service.feedback.enums.FEEDBACK_TARGET_TYPE;
import lombok.Builder;

@Builder
public record FeedbackCreateRequest(
        String userId,
        FEEDBACK_TARGET_TYPE targetType,
        Long targetId,
        int rating,
        String comment
) {}

