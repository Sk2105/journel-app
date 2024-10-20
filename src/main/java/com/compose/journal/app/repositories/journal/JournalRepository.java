package com.compose.journal.app.repositories.journal;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.compose.journal.app.entities.journal.Journal;

public interface JournalRepository extends MongoRepository<Journal, String> {

    
}
