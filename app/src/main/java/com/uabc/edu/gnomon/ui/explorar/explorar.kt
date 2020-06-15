package com.uabc.edu.gnomon.ui.explorar

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uabc.edu.gnomon.R

class explorar : Fragment() {

    companion object {
        fun newInstance() = explorar()
    }

    private lateinit var viewModel: ExplorarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explorar, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExplorarViewModel::class.java)
        // TODO: Use the ViewModel
    }

}