package ru.severstal.notes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.severstal.notes.model.Note;
import ru.severstal.notes.repository.NoteRepository;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public Iterable<Note> all() {
        return noteRepository.findAll();
    }

    public Note getById(int id) {
        return noteRepository
                .findById(id)
                .orElseGet(Note::new);
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }
}
