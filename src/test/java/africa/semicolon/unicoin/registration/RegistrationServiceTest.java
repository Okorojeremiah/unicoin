package africa.semicolon.unicoin.registration;

import africa.semicolon.unicoin.MockUtils;
import africa.semicolon.unicoin.email.EmailSender;
import africa.semicolon.unicoin.registration.RegistrationRequest;
import africa.semicolon.unicoin.registration.RegistrationService;
import africa.semicolon.unicoin.user.User;
import africa.semicolon.unicoin.user.UserRepository;
import africa.semicolon.unicoin.user.UserService;
import africa.semicolon.unicoin.user.UserServiceImpl;
import jakarta.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.mockito.internal.util.MockUtil;

import static africa.semicolon.unicoin.MockUtils.emailSenderMock;
import static africa.semicolon.unicoin.MockUtils.userRepositoryMock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistrationServiceTest {
  private static final UserServiceImpl userServiceMock = spy(MockUtils.userService());

    private static final RegistrationService registrationService = new RegistrationService(
            userServiceMock,
            userRepositoryMock,
            emailSenderMock,
            MockUtils.confirmationTokenServiceMock()
    );
    private UserService userService;

    @Test
    void testRegister() throws MessagingException {
        RegistrationRequest registrationRequest = new RegistrationRequest(
                "Jonathan","Martins","dejiMartins99@gmail.com","pass12345"
        );
     doReturn("4d5814e4-816b-4d45-803a-3675d4deca96")
             .when(userServiceMock).createAccount(any(User.class));
     assertEquals(registrationService.register(registrationRequest),"4d5814e4-816b-4d45-803a-3675d4deca96");
    }

    @Test
    void confirmationToken() {

    }
}