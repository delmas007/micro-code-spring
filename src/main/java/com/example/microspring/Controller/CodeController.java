package com.example.microspring.Controller;

import com.example.microspring.Service.CodeService;
import com.example.microspring.Service.VerificationCode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class CodeController {
    CodeService codeService;
    VerificationCode verificationCode;

    @PostMapping("/generate-code/")
    public void code(@RequestBody Map<String, String> authentification) {
        String emaile = authentification.get("email");
        codeService.generateCode(emaile);
    }

    @PostMapping("/verify-code/")
    public int verifyCode(@RequestBody Map<String, String> authentification) {
        String email = authentification.get("email");
        String code = authentification.get("code");
        System.out.println(email+" , "+code);
        return verificationCode.verifyCode(email, code);
    }
}
