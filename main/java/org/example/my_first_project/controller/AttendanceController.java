package org.example.my_first_project.controller;

import lombok.RequiredArgsConstructor;
import org.example.my_first_project.dto.CheckInDto;
import org.example.my_first_project.dto.MessageResponse;
import org.example.my_first_project.entity.Attendance;
import org.example.my_first_project.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping("/checkin")
    public ResponseEntity<?> checkIn(@RequestBody CheckInDto dto) {
        attendanceService.checkIn(dto);
        return ResponseEntity.ok().body(MessageResponse.success("Employer checked successfully"));

    }



    @GetMapping("/get{id}")
    public ResponseEntity<?> getAttendance(@PathVariable Long id) {
       List<Attendance> attendance = attendanceService.getAllById(id);
        return ResponseEntity.ok(attendance);
    }
}

