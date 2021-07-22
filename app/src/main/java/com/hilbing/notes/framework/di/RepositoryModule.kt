package com.hilbing.notes.framework.di

import android.app.Application
import com.hilbing.core.repository.NoteRepository
import com.hilbing.notes.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}