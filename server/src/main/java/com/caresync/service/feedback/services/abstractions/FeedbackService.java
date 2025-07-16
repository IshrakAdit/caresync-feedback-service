package com.caresync.service.feedback.services.abstractions;

import com.caresync.service.feedback.dtos.request.FeedbackCreateRequest;
import com.caresync.service.feedback.dtos.request.FeedbackUpdateRequest;
import com.caresync.service.feedback.dtos.response.FeedbackResponse;

import java.util.List;

public interface FeedbackService {

    List<FeedbackResponse> getFeedbacksForDoctor(Long doctorId);
    List<FeedbackResponse> getFeedbacksForHospital(Long hospitalId);
    List<FeedbackResponse> getFeedbacksByUser(String userId);
    FeedbackResponse addFeedback(FeedbackCreateRequest request);
    FeedbackResponse updateFeedback(FeedbackUpdateRequest request);
    void deleteFeedback(Long feedbackId, String userId);

}

