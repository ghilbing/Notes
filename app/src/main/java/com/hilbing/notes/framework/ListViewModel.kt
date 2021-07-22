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
import com.hilbing.notes.framework.di.AppModule
import com.hilbing.notes.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class ListViewModel(application: Application): AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init{
        DaggerViewModelComponent.builder()
            .appModule(AppModule(getApplication()))
            .build()
            .inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes(){
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            noteList.forEach{
                it.wordCount = useCases.wordCount.invoke(it)
            }
            notes.postValue(noteList)
        }
    }


}