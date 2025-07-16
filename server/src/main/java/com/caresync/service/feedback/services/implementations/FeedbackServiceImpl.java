package com.caresync.service.feedback.services.implementations;

import com.caresync.service.feedback.clients.AuthClient;
import com.caresync.service.feedback.dtos.request.FeedbackCreateRequest;
import com.caresync.service.feedback.dtos.response.FeedbackResponse;
import com.caresync.service.feedback.entities.Feedback;
import com.caresync.service.feedback.enums.FEEDBACK_TARGET_TYPE;
import com.caresync.service.feedback.repositories.FeedbackRepository;
import com.caresync.service.feedback.services.abstractions.FeedbackService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final AuthClient authClient; // optional - for isAdmin()

    @Override
    public FeedbackResponse addFeedback(FeedbackCreateRequest request) {
        // Optionally check if user exists via authClient
        Feedback feedback = Feedback.builder()
                .userId(request.userId())
                .targetType(request.targetType())
                .targetId(request.targetId())
                .rating(request.rating())
                .comment(request.comment())
                .createdAt(LocalDateTime.now())
                .build();

        feedbackRepository.save(feedback);
        return mapToResponse(feedback);
    }

    @Override
    public List<FeedbackResponse> getFeedbacksForDoctor(Long doctorId) {
        return feedbackRepository.findByTargetTypeAndTargetId(FEEDBACK_TARGET_TYPE.DOCTOR, doctorId)
                .stream().map(this::mapToResponse).toList();
    }

    @Override
    public List<FeedbackResponse> getFeedbacksForHospital(Long hospitalId) {
        return feedbackRepository.findByTargetTypeAndTargetId(FEEDBACK_TARGET_TYPE.HOSPITAL, hospitalId)
                .stream().map(this::mapToResponse).toList();
    }

    @Override
    public List<FeedbackResponse> getFeedbacksByUser(String userId) {
        return feedbackRepository.findByUserId(userId)
                .stream().map(this::mapToResponse).toList();
    }

    @Override
    public void deleteFeedback(Long feedbackId, String userId) {
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new EntityNotFoundException("Feedback not found"));

        if (!feedback.getUserId().equals(userId) && !authClient.isAdmin(userId)) {
            throw new UnsupportedOperationException("Only the author or admin can delete this feedback.");
        }

        feedbackRepository.deleteById(feedbackId);
    }

    private FeedbackResponse mapToResponse(Feedback feedback) {
        return FeedbackResponse.builder()
                .id(feedback.getId())
                .userId(feedback.getUserId())
                .targetType(feedback.getTargetType())
                .targetId(feedback.getTargetId())
                .rating(feedback.getRating())
                .comment(feedback.getComment())
                .createdAt(feedback.getCreatedAt())
                .build();
    }
}

