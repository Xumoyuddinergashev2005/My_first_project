package org.example.my_first_project.service;

import lombok.RequiredArgsConstructor;
import org.example.my_first_project.entity.Attendance;
import org.example.my_first_project.entity.Employer;
import org.example.my_first_project.exception.NotFoundException;
import org.example.my_first_project.repository.AttendanceRepository;
import org.example.my_first_project.repository.EmployerRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final EmployerRepository employerRepository;

    public Attendance checkIn(Long Id) {
        Employer employer = employerRepository.findById(Id)
                .orElseThrow(() -> new NotFoundException("Employee not found with id: " + Id));

        Attendance attendance = Attendance.builder()
                .employer(employer)
                .checkInTime(LocalDateTime.now())
                .build();

        return attendanceRepository.save(attendance);
    }


    public List<Attendance> getAllById(Long id) {
        List<Attendance> attendances = attendanceRepository.findByEmployer_Id(id);

        if (attendances.isEmpty()) {
            throw new NotFoundException("No attendance records found for employee with id: " + id);
        }

        return attendances;
    }

}

