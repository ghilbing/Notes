package com.hilbing.notes.framework

import com.hilbing.core.usecase.AddNote
import com.hilbing.core.usecase.GetAllNotes
import com.hilbing.core.usecase.GetNote
import com.hilbing.core.usecase.RemoveNote

data class UseCases (
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote)