package com.compose.journal.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.compose.journal.app.entities.Journal;
import com.compose.journal.app.repositories.JournalRepository;

@Component
public class JournalServices {

    @Autowired(required = true)
    private JournalRepository journalRepository;

    /**
     * 
     * To save journal in database
     * 
     * @param journal
     * @return
     */
    public Journal saveJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    /**
     * 
     * To get all journals from database
     * 
     * @return List<Journal>
     */
    public List<Journal> getJournals() {
        return journalRepository.findAll();
    }

    /**
     * To get journal by id from database
     * 
     * @param id
     * @return Optional<Journal>
     */
    public Optional<Journal> getJournalById(String id) {
        return journalRepository.findById(id);
    }

    /**
     * To delete journal by id from database
     * 
     * @param id
     * @return String
     */
    public Boolean deleteJournal(String id) throws Exception {

        try {
            if (!journalRepository.existsById(id)) {
                return false;
            }
            journalRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            new Throwable(e.getMessage());
            return false;
        }

    }

    /**
     * To update journal by id from database
     * 
     * @param id
     * @param journal
     * @return String
     */
    public Boolean updateJournal(String id, Journal journal) throws Exception {
        if (!journalRepository.existsById(id)) {
            new Throwable("Entry id " + id + " does not exist in list");
            return false;
        }
        journal.setId(id);
        journalRepository.save(journal);
        return true;
    }

}
