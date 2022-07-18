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

import com.vitassalvantes.spring_boot_up_and_running.domain.Note;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The controller provides note management.
 *
 * @author Ivan Bobrov
 * @version 1.2.1
 * @see Note
 */
@RestController
@RequestMapping("/notes")
public class NoteController {

    private final List<Note> notes;

    public NoteController() {
        notes = new ArrayList<>();
        notes.addAll(List.of(
                new Note("My first note"),
                new Note("My second note"),
                new Note("My third note")
        ));
    }

    @GetMapping
    Iterable<Note> getNotes() {
        return notes;
    }

    @GetMapping("/{id}")
    Optional<Note> getNoteById(@PathVariable final String id) {
        for (Note note : notes) {
            if (note.id().equals(id)) {
                return Optional.of(note);
            }
        }

        return Optional.empty();
    }

    @PostMapping
    Note postNote(@RequestBody final Note note) {
        notes.add(note);
        return note;
    }
}
