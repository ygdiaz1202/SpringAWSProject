package com.awsexample.awsimageupload.appuser;

import com.awsexample.awsimageupload.registration.token.UserConfirmationToken;
import com.awsexample.awsimageupload.registration.token.UserConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static  String USER_NOT_FOUND =
            "user with email %s not found";
    private final AppUserRepository appUserRepository;
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserConfirmationTokenService userConfirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                                .orElseThrow
                                        (
                                    ()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email))
                                );
    }

    public String signUpUser(AppUser appUser){
        boolean userExists= appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExists){
            throw new IllegalStateException("email already taken");
        }

        String encodePassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodePassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        //TODO : send confirmation token
        UserConfirmationToken userConfirmationToken=new UserConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );
        userConfirmationTokenService.saveUserConfirmationToken(userConfirmationToken);
        return  token;
       //TODO : send email to the user
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
