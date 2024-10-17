package com.compose.journal.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.compose.journal.app.entities.Journal;

public interface JournalRepository extends MongoRepository<Journal, String> {

    
}
