package com.uabc.edu.gnomon.ui.perfil

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.uabc.edu.gnomon.R

class perfil : Fragment() {

    companion object {
        fun newInstance() = perfil()
    }

    private lateinit var viewModel: PerfilViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.perfil_fragment, container, false)
        val webview : WebView? = view.findViewById<WebView>(R.id.wvPerfil)
        webview?.settings?.javaScriptEnabled = true

        webview?.loadUrl("http://test.beetsool.com/gnomon/perfil.html")

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PerfilViewModel::class.java)
        // TODO: Use the ViewModel
    }

}