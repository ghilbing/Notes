package com.hilbing.notes.framework

import android.content.Context
import com.hilbing.core.data.Note
import com.hilbing.core.repository.NoteDataSource
import com.hilbing.notes.framework.db.DatabaseService
import com.hilbing.notes.framework.db.NoteEntity

class RoomNoteDataSource(context: Context): NoteDataSource {
    val noteDao = DatabaseService.getInstance(context).noteDato()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll() = noteDao.getAllNoteEntities().map {it.toNote()}

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}