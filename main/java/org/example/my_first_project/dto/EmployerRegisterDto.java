package org.example.my_first_project.dto;


import lombok.Builder;
import org.example.my_first_project.entity.Position;

@Builder
public record EmployerRegisterDto(
        String fullname,
        String email

) {

}
