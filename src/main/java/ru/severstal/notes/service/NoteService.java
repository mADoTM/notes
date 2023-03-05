package ru.severstal.notes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.severstal.notes.entity.Note;
import ru.severstal.notes.repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> all() {
        log.info("RETURNING ALL NOTES FROM DB");
        return (List<Note>) noteRepository.findAll();
    }

    public Note getById(long id) {
        log.info("SEARCHING NOTE IN DB WITH ID {}", id);
        return noteRepository
                .findById(id)
                .orElseGet(Note::new);
    }

    public void saveNote(Note note) {
        log.info("SAVED NOTE - {}", note);
        noteRepository.save(note);
    }

    public void deleteNote(Note note) {
        log.info("DELETING NOTE - {}", note);
        noteRepository.delete(note);
    }

    public void deleteById(long id) {
        log.info("DELETING NOTE BY ID - {}", id);
        noteRepository.deleteById(id);
    }
}
