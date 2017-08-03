package pl.com.sages.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import pl.com.sages.security.entity.UserProfile;
import pl.com.sages.security.entity.Authority;
import pl.com.sages.security.entity.User;
import pl.com.sages.security.service.UsersService;

import javax.annotation.PostConstruct;

@Configuration
public class Security extends WebSecurityConfigurerAdapter {

//    @PostConstruct
//    public void init() {
//        User user = new User();
//        user.setLogin("admin");
//        user.setPassword("123");
//        UserProfile userProfile = new UserProfile("Justyna","Salacinska");
//        Authority authority = new Authority();
//        authority.setName(Role.ADMIN.name());
//        user.setUserProfile(userProfile);
//        usersService.addUser(user);
//    }

    @Autowired
    private UsersService usersService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(passwordEncoder);
    }

}
