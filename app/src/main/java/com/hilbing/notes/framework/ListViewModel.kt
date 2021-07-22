package com.hilbing.notes.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hilbing.core.data.Note
import com.hilbing.core.repository.NoteRepository
import com.hilbing.core.usecase.AddNote
import com.hilbing.core.usecase.GetAllNotes
import com.hilbing.core.usecase.GetNote
import com.hilbing.core.usecase.RemoveNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ListViewModel(application: Application): AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository = NoteRepository(RoomNoteDataSource(application))

    val useCases = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )

    val notes = MutableLiveData<List<Note>>()

    fun getNotes(){
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            notes.postValue(noteList)
        }
    }

}