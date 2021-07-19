package com.hilbing.core.usecase

import com.hilbing.core.repository.NoteRepository

class GetNote (private val noteRepository: NoteRepository) {
    suspend operator fun invoke(id: Long) = noteRepository.getNote(id)
}