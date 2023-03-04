package ru.severstal.notes.repository;

import org.springframework.data.repository.CrudRepository;
import ru.severstal.notes.entity.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
