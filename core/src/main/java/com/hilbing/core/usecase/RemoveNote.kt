package com.hilbing.core.usecase

import com.hilbing.core.data.Note
import com.hilbing.core.repository.NoteRepository

class RemoveNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.removeNote(note)
}