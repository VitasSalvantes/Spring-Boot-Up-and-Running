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

package com.vitassalvantes.spring_boot_up_and_running.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * The class represents an immutable note.
 *
 * @author Ivan Bobrov
 * @version 1.2.0
 */
@Entity
public class Note {

    @Id
    private String id;
    private String text;

    public Note() {
    }

    public Note(final String id, final String text) {
        validateString(id);
        validateString(text);

        this.id = id;
        this.text = text;
    }

    public Note(final String text) {
        this(UUID.randomUUID().toString(), text);
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        validateString(id);

        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        validateString(text);

        this.text = text;
    }

    private void validateString(final String string) {
        if (string == null) {
            throw new IllegalArgumentException("The string must not be null");
        }
    }
}
