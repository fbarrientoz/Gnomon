package com.uabc.edu.gnomon.ui.agenda

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uabc.edu.gnomon.R

class agenda : Fragment() {

    companion object {
        fun newInstance() = agenda()
    }

    private lateinit var viewModel: AgendaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.agenda_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AgendaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}