package africa.semicolon.unicoin.email;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


public interface EmailSender{
    @Async
void send(String to, String email) throws MessagingException;

}
