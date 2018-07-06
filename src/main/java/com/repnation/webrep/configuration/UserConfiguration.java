package com.repnation.webrep.configuration;

import com.repnation.webrep.domain.model.User;
import com.repnation.webrep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
        userService.save(new User("Creusa"));
    }


}
