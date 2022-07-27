/*
 * MIT License
 *
 * Copyright (c) 2022 Ivan Bobrov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to
 * whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.vitassalvantes.spring_boot_up_and_running.controller;

import com.vitassalvantes.spring_boot_up_and_running.entity.Note;
import com.vitassalvantes.spring_boot_up_and_running.repository.NoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * The controller provides note management.
 *
 * @author Ivan Bobrov
 * @version 1.6.1
 * @see Note
 */
@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository noteRepository;


    public NoteController(final NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping
    Iterable<Note> getNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Note> getNoteById(@PathVariable final String id) {
        return noteRepository.findById(id);
    }

    @PostMapping
    Note postNote(@RequestBody final Note note) {
        return noteRepository.save(note);
    }

    @DeleteMapping("/{id}")
    void deleteNoteById(@PathVariable final String id) {
        noteRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<Note> putNote(@PathVariable final String id, @RequestBody final Note newNote) {
        return noteRepository.existsById(id)
                ? new ResponseEntity<>(noteRepository.save(newNote), HttpStatus.OK)
                : new ResponseEntity<>(postNote(newNote), HttpStatus.CREATED);
    }
}
