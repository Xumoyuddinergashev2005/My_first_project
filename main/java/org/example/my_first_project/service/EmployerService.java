package org.example.my_first_project.service;


import lombok.RequiredArgsConstructor;
import org.example.my_first_project.dto.EmployerRegisterDto;
import org.example.my_first_project.entity.Employer;
import org.example.my_first_project.entity.Position;
import org.example.my_first_project.exception.AlreadyExistsException;
import org.example.my_first_project.repository.EmployerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployerService {
    private final EmployerRepository employerRepository;


    public void register(EmployerRegisterDto dto) {

        if(employerRepository.existsByEmail(dto.email())){
            throw new AlreadyExistsException("Email already exists this email: " + dto.email());
        }

        Employer employer = Employer.builder()
                .email(dto.email())
                .fullName(dto.fullname())
                .position(Position.ACTIVE)
                .build();
        employerRepository.save(employer);

    }



}
