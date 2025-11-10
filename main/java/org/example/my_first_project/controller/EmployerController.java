package org.example.my_first_project.controller;


import lombok.RequiredArgsConstructor;
import org.example.my_first_project.dto.EmployerDto;
import org.example.my_first_project.dto.EmployerRegisterDto;
import org.example.my_first_project.dto.MessageResponse;
import org.example.my_first_project.service.EmployerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employer")
@RequiredArgsConstructor
public class EmployerController {
    private final EmployerService employerService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody EmployerRegisterDto dto) {
        employerService.register(dto);
        return ResponseEntity.ok().body(MessageResponse.success("Employer registered successfully"));


    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEmployer(@PathVariable Long id) {
        EmployerDto dto = employerService.getById(id);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployer(@PathVariable Long id) {
        employerService.deleteById(id);
        return ResponseEntity.ok().body(MessageResponse.success("Employer deleted successfully"));
    }







}
