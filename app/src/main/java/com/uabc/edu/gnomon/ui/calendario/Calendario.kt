package com.uabc.edu.gnomon.ui.calendario

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uabc.edu.gnomon.R

class Calendario : Fragment() {

    companion object {
        fun newInstance() = Calendario()
    }

    private lateinit var viewModel: CalendarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.calendario_fragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CalendarioViewModel::class.java)
        // TODO: Use the ViewModel
    }

}