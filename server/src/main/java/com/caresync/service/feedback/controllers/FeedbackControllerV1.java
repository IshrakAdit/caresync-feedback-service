package com.caresync.service.feedback.controllers;

import com.caresync.service.feedback.dtos.request.FeedbackCreateRequest;
import com.caresync.service.feedback.dtos.response.FeedbackResponse;
import com.caresync.service.feedback.services.abstractions.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback/v1")
@RequiredArgsConstructor
public class FeedbackControllerV1 {

    private final FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<FeedbackResponse> addFeedback(@RequestBody @Valid FeedbackCreateRequest request) {
        return ResponseEntity.ok(feedbackService.addFeedback(request));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<FeedbackResponse>> getDoctorFeedbacks(@PathVariable Long doctorId) {
        return ResponseEntity.ok(feedbackService.getFeedbacksForDoctor(doctorId));
    }

    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<FeedbackResponse>> getHospitalFeedbacks(@PathVariable Long hospitalId) {
        return ResponseEntity.ok(feedbackService.getFeedbacksForHospital(hospitalId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FeedbackResponse>> getUserFeedbacks(@PathVariable String userId) {
        return ResponseEntity.ok(feedbackService.getFeedbacksByUser(userId));
    }

    @DeleteMapping("/{feedbackId}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long feedbackId, @RequestParam String userId) {
        feedbackService.deleteFeedback(feedbackId, userId);
        return ResponseEntity.noContent().build();
    }
}

