package com.compose.journal.app.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import com.compose.journal.app.entities.Journal;
import com.compose.journal.app.services.JournalServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/journals")
public class JournalController {

    @Autowired(required = true)
    private JournalServices journalServices;

    /**
     * To get all journals from database
     * 
     * @return ResponseEntity<?>
     */
    @GetMapping
    public ResponseEntity<?> getJournals() {
        return new ResponseEntity<>(journalServices.getJournals(), HttpStatus.OK);
    }

    /**
     * To get journal by id from database
     * 
     * @param id
     * @return ResponseEntity<?>
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getJournalById(@PathVariable String id) {

        Optional<Journal> journal = journalServices.getJournalById(id);

        if (journal.isPresent()) {
            return new ResponseEntity<>(
                    journal.get(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Journal not found", HttpStatus.NOT_FOUND);
    }

    /**
     * To add journal in database
     * 
     * @param journal
     * @return ResponseEntity<?>
     */
    @PostMapping
    public ResponseEntity<?> addJournal(@RequestBody Journal journal) {
        Journal savedJournal = journalServices.saveJournal(journal);
        if (savedJournal != null) {
            return new ResponseEntity<>(
                    savedJournal,
                    HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Journal not found", HttpStatus.BAD_REQUEST);
    }

    /**
     * To delete journal by id from database
     * 
     * @param id
     * @return ResponseEntity<?>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJournal(@PathVariable String id) {
        try {
            Boolean deleted = journalServices.deleteJournal(id);
            if (!deleted) {
                return new ResponseEntity<>("Entry id " + id + " does not exist in list", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Entry id " + id + " was deleted from list", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * To update journal by id from database
     * 
     * @param id
     * @param entity
     * @return ResponseEntity<?>
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable String id, @RequestBody Journal entity) {

        try {
            Boolean updated = journalServices.updateJournal(id, entity);

            if (!updated) {
                return new ResponseEntity<>("Entry id " + id + " does not exist in list", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Entry id " + id + " was updated in list", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
