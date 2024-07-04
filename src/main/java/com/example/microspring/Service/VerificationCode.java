package com.example.microspring.Service;

import com.example.microspring.Model.Code;
import com.example.microspring.Repository.CodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class VerificationCode {

    CodeRepository codeRepository;

    public int verifyCode(String email, String code) {
        Code codee = codeRepository.findByEmail(email);
        if (codee.getCode().equals(code)) {
            return 1;
        } else {
            return 0;
        }
    }
}
