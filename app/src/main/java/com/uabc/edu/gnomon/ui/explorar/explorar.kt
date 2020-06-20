package com.uabc.edu.gnomon.ui.explorar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uabc.edu.gnomon.R

class explorar : Fragment() {

    private lateinit var viewModel: ExplorarViewModel

    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = explorar()
    }



    private val myDataSet = arrayOf(
        "PHP",
        "Javascript",
        "Go",
        "Python",
        "prueba1",
        "prueba2"
    )

    private val mAdapter by lazy {
        Adapter(myDataSet)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_explorar, container, false)

            recyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.setHasFixedSize(true)

            val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            recyclerView.layoutManager = layoutManager

            recyclerView.adapter = mAdapter


        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExplorarViewModel::class.java)
        // TODO: Use the ViewModel
    }

}