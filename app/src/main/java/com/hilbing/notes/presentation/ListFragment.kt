package com.hilbing.notes.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.hilbing.notes.R
import com.hilbing.notes.framework.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    private val notesListAdapter = NotesListAdapter(arrayListOf())
    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = notesListAdapter
        }
        addNote.setOnClickListener { goToNoteDetails() }
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.notes.observe(viewLifecycleOwner, Observer {
            loadingView.visibility = View.GONE
            notesRecyclerView.visibility = View.VISIBLE
            notesListAdapter.updateNotes(it.sortedBy{it.updateTime})
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNotes()
    }

    private fun goToNoteDetails(id: Long = 0L){
        val action = ListFragmentDirections.actionListFragmentToNoteFragment(id)
        Navigation.findNavController(notesRecyclerView).navigate(action)
    }

}