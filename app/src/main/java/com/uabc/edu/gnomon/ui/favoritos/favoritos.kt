package com.uabc.edu.gnomon.ui.favoritos

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uabc.edu.gnomon.R

class favoritos : Fragment() {

    companion object {
        fun newInstance() = favoritos()
    }

    private lateinit var viewModel: FavoritosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favoritos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FavoritosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}