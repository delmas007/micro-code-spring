package com.example.microspring.Controller;

import com.example.microspring.Service.CodeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class CodeController {
    CodeService codeService;

    @PostMapping("/generate-code/")
    public void code(@RequestBody Map<String, String> authentification) {
        String emaile = authentification.get("email");
        codeService.generateCode(emaile);
    }
}
