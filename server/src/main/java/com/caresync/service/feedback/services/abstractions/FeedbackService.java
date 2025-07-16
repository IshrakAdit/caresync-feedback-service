package com.caresync.service.feedback.services.abstractions;

import com.caresync.service.feedback.dtos.request.FeedbackCreateRequest;
import com.caresync.service.feedback.dtos.response.FeedbackResponse;

import java.util.List;

public interface FeedbackService {

    FeedbackResponse addFeedback(FeedbackCreateRequest request);

    List<FeedbackResponse> getFeedbacksForDoctor(Long doctorId);

    List<FeedbackResponse> getFeedbacksForHospital(Long hospitalId);

    List<FeedbackResponse> getFeedbacksByUser(String userId);

    void deleteFeedback(Long feedbackId, String userId);
}

