package com.flurken.webservices.dao;

import com.flurken.webservices.bean.Post;
import com.flurken.webservices.bean.User;
import com.flurken.webservices.exception.PostDoesNotExistsException;
import com.flurken.webservices.exception.PostsNotFoundException;
import com.flurken.webservices.exception.UserNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;
    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eva", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List findAll(){
        return users;
    }

    public User save(User user){
        if (user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findUser(int id){
        for (User user: users) {
            if (user.getId() == id){
                return user;
            }
        }
        throw new UserNotFoundException("No user exists with id : "+id);
    }

    public Boolean deleteUser(int id){
        return users.remove(this.findUser(id));
    }

    public Post createPost(User user, Post post){
        user.getPosts().add(post);
        return post;
    }

    public List<Post> getPosts(Integer id){
        User user = this.findUser(id);
        List<Post> posts = user.getPosts();
        if (posts.isEmpty()) throw new PostsNotFoundException("No posts are uploaded from id : "+id);
        return posts;
    }

    public Post getSpecificPost(Integer id, Integer postId){
        List<Post> posts = this.getPosts(id);
        for (Post post : posts) {
            if (post.getId() == postId){
                return post;
            };
        }
        throw new PostDoesNotExistsException("User " + id + " has no such post.");
    }

}
