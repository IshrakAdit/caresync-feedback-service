package com.caresync.service.feedback.repositories;

import com.caresync.service.feedback.entities.Feedback;
import com.caresync.service.feedback.enums.FEEDBACK_TARGET_TYPE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByTargetTypeAndTargetId(FEEDBACK_TARGET_TYPE type, Long targetId);
    List<Feedback> findByUserId(String userId);
}
