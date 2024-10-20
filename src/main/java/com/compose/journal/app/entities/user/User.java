package com.compose.journal.app.entities.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.compose.journal.app.entities.journal.Journal;
import com.mongodb.lang.Nullable;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    @Nullable
    private String username;

    @Nullable
    private String password;

    @DBRef
    private List<Journal> journals = new ArrayList<>();
    

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }

}
