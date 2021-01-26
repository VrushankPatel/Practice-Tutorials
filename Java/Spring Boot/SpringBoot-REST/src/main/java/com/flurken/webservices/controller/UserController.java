package com.flurken.webservices.controller;

import com.flurken.webservices.bean.Post;
import com.flurken.webservices.bean.User;
import com.flurken.webservices.dao.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDAOService userDAOService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return userDAOService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable("id") Integer id){
        User user =  userDAOService.findUser(id);
        return user;
    }

    @PostMapping(path = "/users") // Here, we'll get User class's attributes from request, so RequestBody annotation is used.
    public ResponseEntity<Object> createUser(@RequestBody User user){ // @Valid will check all the validation that apply to variables of User class, (check User class).
        // After successfully inserted, we should send correct response code.

        User insertedUser = userDAOService.save(user);

        // Once, user is inserted, we want to redirect the request to uri as /users/{id_of_user_inserted}
        // for that, we've to build the uri

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(insertedUser.getId())
                .toUri();
        // now, response entity will send the valid response code 201 which is for successfully created or inserted.
        // this is the post request, test it with postman, response code will be 201.
        // Check the Response Headers in POSTMan, you'll find the location there,
        // this new location will be of /users/{id_of_user_inserted}.
        return ResponseEntity.created(location).build();
    }

    // below endpoint is to delete the user, we'll respond empty with status code 200 if user successfully deleted.
    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id){
        userDAOService.deleteUser(id);
        // below are just other two ways to send OK response with 200 code.
        return ResponseEntity.status(200).build();
        // return ResponseEntity.ok().build();
    }

    // below endpoint is to create post for user, here we're using path variable and request body both.
    @PostMapping(path = "/users/{id}/posts")
    public Post createPost(@PathVariable("id") Integer id, @RequestBody Post post){
        return userDAOService.createPost(this.retrieveUser(id), post);
    }

    //below endpoint will show all the posts of the user whose id is provided in url
    @GetMapping(path = "/users/{id}/posts")
    public List<Post> getPosts(@PathVariable("id") Integer id){
        List<Post> posts = userDAOService.getPosts(id);
        return posts;
    }

    // This endpoint is to get specific post of particular user.
    @GetMapping(path = "/users/{id}/posts/{postId}")
    public Post getSpecificPost(@PathVariable("id") Integer id, @PathVariable("postId") Integer postId){
        Post post = userDAOService.getSpecificPost(id, postId);
        return post;
    }

}
