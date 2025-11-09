package org.example.my_first_project.repository;

import org.example.my_first_project.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByEmployer_Id(Long id);
}
