package ru.severstal.notes.repository;

import org.springframework.data.repository.CrudRepository;
import ru.severstal.notes.model.Note;

public interface NoteRepository extends CrudRepository<Note, Integer> {
}
