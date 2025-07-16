CREATE TABLE feedbacks (
                           id BIGSERIAL PRIMARY KEY,
                           user_id VARCHAR(50) NOT NULL,
                           target_type VARCHAR(20) CHECK (target_type IN ('DOCTOR', 'HOSPITAL')) NOT NULL,
                           target_id BIGINT NOT NULL,
                           rating INT CHECK (rating BETWEEN 1 AND 5),
                           comment TEXT,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Feedbacks for doctors
INSERT INTO feedbacks (user_id, target_type, target_id, rating, comment) VALUES
                                                                             ('user-1', 'DOCTOR', 1, 5, 'Excellent service.'),
                                                                             ('user-2', 'DOCTOR', 1, 4, 'Very knowledgeable.'),

                                                                             ('user-1', 'DOCTOR', 2, 4, 'Good diagnosis.'),
                                                                             ('user-2', 'DOCTOR', 2, 3, 'Wait time was long.'),

                                                                             ('user-1', 'DOCTOR', 3, 5, 'Great experience.'),

                                                                             ('user-2', 'DOCTOR', 4, 4, 'Helpful and professional.'),

                                                                             ('user-1', 'DOCTOR', 5, 3, 'Okay overall.'),
                                                                             ('user-2', 'DOCTOR', 5, 5, 'Outstanding!'),

                                                                             ('user-1', 'DOCTOR', 6, 4, 'Nice communication.'),

                                                                             ('user-2', 'DOCTOR', 7, 5, 'Highly recommended.'),
                                                                             ('user-1', 'DOCTOR', 7, 4, 'Very polite.'),

                                                                             ('user-1', 'DOCTOR', 8, 2, 'Not satisfied.'),
                                                                             ('user-2', 'DOCTOR', 8, 3, 'Average.'),

                                                                             ('user-1', 'DOCTOR', 9, 4, 'Friendly doctor.'),
                                                                             ('user-2', 'DOCTOR', 9, 5, 'Helped a lot.'),

                                                                             ('user-1', 'DOCTOR', 10, 3, 'Could be better.');

-- Feedbacks for hospitals
INSERT INTO feedbacks (user_id, target_type, target_id, rating, comment) VALUES
                                                                             ('user-1', 'HOSPITAL', 1, 5, 'Clean and modern.'),
                                                                             ('user-2', 'HOSPITAL', 1, 4, 'Well equipped.'),

                                                                             ('user-1', 'HOSPITAL', 2, 3, 'Too crowded.'),
                                                                             ('user-2', 'HOSPITAL', 2, 2, 'Long waiting times.'),

                                                                             ('user-1', 'HOSPITAL', 3, 4, 'Good facilities.'),

                                                                             ('user-2', 'HOSPITAL', 4, 5, 'Excellent care.'),

                                                                             ('user-1', 'HOSPITAL', 5, 3, 'Satisfactory.'),
                                                                             ('user-2', 'HOSPITAL', 5, 4, 'Clean rooms.'),

                                                                             ('user-1', 'HOSPITAL', 6, 4, 'Friendly staff.'),

                                                                             ('user-2', 'HOSPITAL', 7, 5, 'Efficient management.'),
                                                                             ('user-1', 'HOSPITAL', 7, 4, 'Great service.'),

                                                                             ('user-1', 'HOSPITAL', 8, 2, 'Needs improvement.'),
                                                                             ('user-2', 'HOSPITAL', 8, 3, 'Average experience.'),

                                                                             ('user-1', 'HOSPITAL', 9, 4, 'Great lab facilities.'),

                                                                             ('user-2', 'HOSPITAL', 10, 3, 'Okay.'),
                                                                             ('user-1', 'HOSPITAL', 10, 4, 'Doctors were helpful.'),

                                                                             ('user-2', 'HOSPITAL', 11, 4, 'Great location.'),

                                                                             ('user-1', 'HOSPITAL', 12, 2, 'Not clean.'),
                                                                             ('user-2', 'HOSPITAL', 12, 3, 'Improved recently.'),

                                                                             ('user-1', 'HOSPITAL', 13, 4, 'Neat and tidy.'),

                                                                             ('user-2', 'HOSPITAL', 14, 5, 'Great overall.'),
                                                                             ('user-1', 'HOSPITAL', 14, 4, 'Will visit again.'),

                                                                             ('user-1', 'HOSPITAL', 15, 3, 'Nothing special.');

SELECT setval('feedbacks_id_seq', (SELECT MAX(id) FROM feedbacks));