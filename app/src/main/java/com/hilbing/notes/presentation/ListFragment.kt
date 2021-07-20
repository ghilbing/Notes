package com.hilbing.notes.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.hilbing.notes.R
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNote.setOnClickListener { goToNoteDetails() }
    }

    private fun goToNoteDetails(id: Long = 0L){
        val action = ListFragmentDirections.actionListFragmentToNoteFragment(id)
        Navigation.findNavController(notesRecyclerView).navigate(action)
    }

}