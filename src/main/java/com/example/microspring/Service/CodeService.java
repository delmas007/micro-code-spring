package com.example.microspring.Service;

import com.example.microspring.Model.Code;
import com.example.microspring.Repository.CodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

@Service
@AllArgsConstructor
public class CodeService {
    CodeRepository codeRepository;
    NotificationMailServiceImp notificationMailServiceImp;
    public void generateCode(String email) {
        Code codee = new Code();
        Instant creation = Instant.now();
        Instant expiration = creation.plus((Duration.ofMinutes(5)));
        codee.setCreation(creation);
        codee.setExpiration(expiration);
        codee.setEmail(email);

        Random random = new Random();
        int randomCode = random.nextInt(999999);
        String code = String.format("%06d", randomCode);
        codee.setCode(code);

        codeRepository.save(codee);
        notificationMailServiceImp.sendNotificationMail(codee);

    }
}
