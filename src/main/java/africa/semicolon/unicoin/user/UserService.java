package africa.semicolon.unicoin.user;

import africa.semicolon.unicoin.registration.token.ConfirmTokenRequest;

public interface UserService {
    public String createAccount(User user);

    void enableUser(String emailAddress);

}
