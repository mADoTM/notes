package ru.severstal.notes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.severstal.notes.entity.Note;
import ru.severstal.notes.service.NoteService;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final NoteService noteService;

    @GetMapping("/")
    public String getAllNotes(ModelMap model) {
        model.addAttribute("notes", noteService.all());
        return "index";
    }

    @PostMapping("/")
    public ModelAndView addNewNote(@RequestParam String text) {
        Note note = new Note();
        note.setText(text);

        noteService.saveNote(note);

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") long noteId) {
        noteService.deleteById(noteId);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "update_note";
    }

    @PostMapping("/save")
    public String saveNote(@ModelAttribute("note") Note note) {
        noteService.saveNote(note);
        return "redirect:/";
    }
}
