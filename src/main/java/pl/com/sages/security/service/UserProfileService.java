package pl.com.sages.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.sages.security.entity.UserProfile;
import pl.com.sages.security.repository.UserProfileRepository;

@Service
public class UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    public void addNewUserProfile(UserProfile userProfile){
        userProfileRepository.saveAndFlush(userProfile);
    }

}
