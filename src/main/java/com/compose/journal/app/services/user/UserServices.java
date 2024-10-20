package com.compose.journal.app.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.compose.journal.app.entities.user.User;
import com.compose.journal.app.repositories.user.UserRepository;

@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    /**
     * To get all users from the database
     * 
     * @return ResponseEntity<?>
     */
    public ResponseEntity<?> getUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * To save user in database
     * 
     * @param username
     *                 username of the user
     * @param password
     *                 password of the user
     * @return ResponseEntity<?>
     */
    public ResponseEntity<?> saveUser(String username, String password) {
        try {
            User user = new User(username, password);
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * To get user by id from database
     * 
     * @param id
     *           id of the user
     * @return ResponseEntity<?>
     */
    public ResponseEntity<?> getUserById(String id) {
        try {
            Optional<User> user = userRepository.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * To delete user by id from database
     * 
     * @param id
     *           id of the user
     * @return ResponseEntity<?>
     */
    public ResponseEntity<?> deleteUser(String id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
