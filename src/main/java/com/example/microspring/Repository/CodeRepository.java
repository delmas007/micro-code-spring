package com.example.microspring.Repository;

import com.example.microspring.Model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<Code, Integer>{


    Code findByEmail(String email);
}
