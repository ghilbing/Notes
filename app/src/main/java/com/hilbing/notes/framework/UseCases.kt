package com.hilbing.notes.framework

import com.hilbing.core.usecase.*

data class UseCases (
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    val wordCount: GetWordCount)