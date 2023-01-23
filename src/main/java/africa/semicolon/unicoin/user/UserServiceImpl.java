package africa.semicolon.unicoin.user;

import africa.semicolon.unicoin.registration.token.ConfirmationToken;
import africa.semicolon.unicoin.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
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
    public String login(LoginRequest loginRequest) {
        Optional<User> foundUser = Optional.ofNullable(userRepository.findByEmailAddressIgnoreCase(loginRequest.getEmailAddress())
                .orElseThrow(() -> new IllegalStateException("User doesn't exist")));
        String successful = "";
        if (foundUser.isEmpty()) throw new IllegalStateException("User not found");
        if (Objects.equals(loginRequest.getPassword(), foundUser.get().getPassword())) successful = "Login successful";
        return successful;
    }
    @Override
    public String changePassword(ChangePasswordRequest changePasswordRequest){
        User foundUser = userRepository.findByEmailAddressIgnoreCase(changePasswordRequest.getEmailAddress())
                .orElseThrow(()-> new IllegalStateException("Invalid email address"));
        if (foundUser.getPassword().equals(changePasswordRequest.getOldPassword())){
            foundUser.setPassword(changePasswordRequest.getNewPassword());
            userRepository.save(foundUser);
        }else throw new IllegalStateException("Invalid password");
        return "Password changed successfully";
    }
}
