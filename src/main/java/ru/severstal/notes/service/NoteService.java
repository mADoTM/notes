package ru.severstal.notes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.severstal.notes.entity.Note;
import ru.severstal.notes.repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> all() {
        return (List<Note>) noteRepository.findAll();
    }

    public Note getById(long id) {
        return noteRepository
                .findById(id)
                .orElseGet(Note::new);
    }

    public void saveNote(Note note) {
        noteRepository.save(note);
    }

    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }
}
