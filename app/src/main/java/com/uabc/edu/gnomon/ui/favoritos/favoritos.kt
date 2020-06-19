package com.uabc.edu.gnomon.ui.favoritos

import Entidades.Empresa
import adaptadores.AdapterEmpresa
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uabc.edu.gnomon.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.lista_favoritos.*

class favoritos () : Fragment() {


    private lateinit var recyclerView: RecyclerView

    companion object {
       fun newInstance() = favoritos()


  }

    private lateinit var viewModel: FavoritosViewModel
    private val myDataSet = arrayOf(
        "PHP",
        "Javascript",
        "Go",
        "Python",
        "prueba1",
        "prueba2"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {

        val view = inflater.inflate(R.layout.favoritos_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = AdapterEmpresa(myDataSet)

        return view




    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FavoritosViewModel::class.java)
        // TODO: Use the ViewModel
    }



}