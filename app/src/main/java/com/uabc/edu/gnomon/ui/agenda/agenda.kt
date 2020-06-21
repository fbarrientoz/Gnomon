package com.uabc.edu.gnomon.ui.agenda

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
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
        val view = inflater.inflate(R.layout.agenda_fragment, container, false)
        val webview : WebView? = view.findViewById<WebView>(R.id.wvAgenda)
        webview?.settings?.javaScriptEnabled = true

        webview?.loadUrl("http://test.beetsool.com/gnomon/agenda.html")

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AgendaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}