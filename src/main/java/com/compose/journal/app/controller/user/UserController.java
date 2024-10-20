package com.compose.journal.app.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compose.journal.app.entities.user.User;
import com.compose.journal.app.services.user.UserServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    /**
     * To get all users from database
     * 
     * @return ResponseEntity<?>
     */
    @RequestMapping
    public ResponseEntity<?> getUsers() {
        return userServices.getUsers();
    }

    /**
     * To save user in database
     * 
     * @param entity
     *            Entity of the user
     * @return ResponseEntity<?>
     */
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User entity) {

        return userServices.saveUser(entity.getUsername(), entity.getPassword());
    }

    /**
     * To delete user by id from database
     * 
     * @param entity
     *            Entity of the user
     * @return ResponseEntity<?>
     */
    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody User entity) {
        return userServices.deleteUser(entity.getId());
    }

    /**
     * To get user by id from database
     * 
     * @param id id of the user
     * @return ResponseEntity<?>
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        return userServices.getUserById(id);
    }

}
