package com.uabc.edu.gnomon.ui.mensajes

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uabc.edu.gnomon.R

class mensajes : Fragment() {

    companion object {
        fun newInstance() = mensajes()
    }

    private lateinit var viewModel: MensajesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mensajes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MensajesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}