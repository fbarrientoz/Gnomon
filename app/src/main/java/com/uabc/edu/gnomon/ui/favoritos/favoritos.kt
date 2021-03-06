package com.uabc.edu.gnomon.ui.favoritos

import adaptadores.AdapterEmpresa
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uabc.edu.gnomon.R
import com.uabc.edu.gnomon.ui.empresa.Detalle_Fragment

class favoritos () : Fragment(),AdapterEmpresa.OnFavoritoListener {

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
        recyclerView.adapter = AdapterEmpresa(myDataSet, this)



        return view




    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FavoritosViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onFavoritoClick(position: Int) {
        val fragment = Detalle_Fragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}