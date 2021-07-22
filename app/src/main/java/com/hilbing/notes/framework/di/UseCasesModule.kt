package com.hilbing.notes.framework.di

import com.hilbing.core.repository.NoteRepository
import com.hilbing.core.usecase.AddNote
import com.hilbing.core.usecase.GetAllNotes
import com.hilbing.core.usecase.GetNote
import com.hilbing.core.usecase.RemoveNote
import com.hilbing.notes.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )
}