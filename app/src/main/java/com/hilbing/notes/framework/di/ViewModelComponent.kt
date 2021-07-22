package com.hilbing.notes.framework.di

import com.hilbing.notes.framework.ListViewModel
import com.hilbing.notes.framework.NoteViewModel
import dagger.Component

@Component(modules = [AppModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}