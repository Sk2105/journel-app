package com.compose.journal.app.entities.journal;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "journals")
@Data
public class Journal {
    private String id;
    private String title;
    private String content;

    public Journal(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}
