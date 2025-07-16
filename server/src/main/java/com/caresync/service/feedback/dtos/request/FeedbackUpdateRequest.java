package com.caresync.service.feedback.dtos.request;

import lombok.Builder;

@Builder
public record FeedbackUpdateRequest(
        Long id,
        String userId,
        Integer rating,
        String comment
) {}
