package com.demo.jpa;

import com.demo.jpa.entity.User;
import com.demo.jpa.repository.UserRepository;
import com.demo.jpa.service.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/*
* In here, we'll use UserRepository to store the data.
* by that, we don't need to create a method for insert or any other operation,
* we can directly use the persisted methods as save, findByUserName etc..
* This way is more efficient way then creating DAO services.
* */
@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jill", "Admin");
        User savedUser = userRepository.save(user);
        log.info("User is created " + savedUser);

        // Let's get user by Id
        Optional<User> users = userRepository.findById(1L);
        log.info("User with id 1 is : " + users);

        List<User> usersList = userRepository.findAll();
        log.info("All users are : " + usersList);

        log.info("Total users in DB is : " + userRepository.count());

        log.info("Deleting all users in DB");

        userRepository.deleteAll();

        log.info("Now, Total users in DB is : " + userRepository.count());

    }
}
