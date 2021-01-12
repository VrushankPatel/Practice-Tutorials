package com.demo.jpa;

import com.demo.jpa.entity.User;
import com.demo.jpa.service.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
 * In this we'll save the user by DAOService, which is the way but not recommended way to use
 * But using this way, we can store the user, but if we've multiple repository, we've to create DAO for them all.
 * The More Efficient way is to create UserRepository and use it's command line runner, that way, please see UserRepositoryCommandLineRunner.
 * */

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
    @Autowired
    private UserDAOService userDAOService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jack", "Admin");
        long insertId = userDAOService.insert(user);
        log.info("User is created " + user);
    }
}
