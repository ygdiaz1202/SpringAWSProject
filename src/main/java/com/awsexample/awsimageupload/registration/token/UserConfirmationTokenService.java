package com.awsexample.awsimageupload.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserConfirmationTokenService {

    private final UserConfirmationTokenRepository userConfirmationTokenRepository;


    public void saveUserConfirmationToken(UserConfirmationToken userConfirmationToken){
        userConfirmationTokenRepository.save(userConfirmationToken);
    }

    public Optional<UserConfirmationToken> getToken(String token) {
        return userConfirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return userConfirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
