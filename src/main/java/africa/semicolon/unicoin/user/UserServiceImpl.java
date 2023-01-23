package africa.semicolon.unicoin.user;

import africa.semicolon.unicoin.exception.RegistrationException;
import africa.semicolon.unicoin.registration.token.ConfirmationToken;
import africa.semicolon.unicoin.registration.token.ConfirmationTokenService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Override
    public String createAccount(User user) {
        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now()
                ,LocalDateTime.now().plusMinutes(10),user);
confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    @Override
    public void enableUser(String emailAddress) {
        userRepository.enable(emailAddress);
    }

    @Override
    public String deleteUser(DeleteUserRequest deleteUserRequest) {
        User foundUser = userRepository.findByEmailAddressIgnoreCase(deleteUserRequest.getEmailAddress())
                .orElseThrow(()-> new RuntimeException("User not found"));
//        foundUser.setIsDisabled(false);
        String no = UUID.randomUUID().toString();
        String deletedEmail = "Deleted" + foundUser.getEmailAddress() + no;
        if (deleteUserRequest.getPassword().equals(foundUser.getPassword()))
            foundUser.setEmailAddress(deletedEmail);
        else throw new RuntimeException("Wrong password");
        userRepository.save(foundUser);
        return "Account deactivated successfully";
    }
}
