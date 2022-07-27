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

package com.vitassalvantes.spring_boot_up_and_running.component;

import com.vitassalvantes.spring_boot_up_and_running.entity.Note;
import com.vitassalvantes.spring_boot_up_and_running.repository.NoteRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * The class creates sample data.
 *
 * @author IvanBobrov
 * @version 1.0.0
 */
@Component
public class DataLoader {

    private final NoteRepository noteRepository;

    public DataLoader(final NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostConstruct
    private void loadData() {
        noteRepository.saveAll(List.of(
                new Note("My first note"),
                new Note("My second note"),
                new Note("My third note")
        ));
    }
}
