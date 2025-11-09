package org.example.my_first_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Hodim kim ekanini saqlaymiz
    @ManyToOne
    @JoinColumn(name = "employer_id" , referencedColumnName = "id")
    @JsonIgnore
    private Employer employer;

    // Ishga kirgan vaqt
    private LocalDateTime checkInTime;
}
