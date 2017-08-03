package pl.com.sages.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import pl.com.sages.security.repository.AuthoritiesRepository;
import pl.com.sages.security.repository.UsersRepository;
import pl.com.sages.security.service.UsersService;

@Configuration
public class UsersBeans {

    @Bean
    public UsersService usersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        return new UsersService(usersRepository, passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }

}
