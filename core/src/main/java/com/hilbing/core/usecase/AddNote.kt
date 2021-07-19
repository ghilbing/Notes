package com.hilbing.core.usecase

import com.hilbing.core.data.Note
import com.hilbing.core.repository.NoteRepository

class AddNote (private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)

}