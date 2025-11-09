package org.example.my_first_project.repository;

import org.example.my_first_project.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {

    boolean existsByEmail(String email);
}
