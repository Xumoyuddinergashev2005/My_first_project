package org.example.my_first_project.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.my_first_project.entity.Position;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto{
        Long id;
        String fullname;
        String email;
        Position position;


}
