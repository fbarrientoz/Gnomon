package com.uabc.edu.gnomon.ui.empresa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import com.uabc.edu.gnomon.R
import com.uabc.edu.gnomon.R.id.button2
import com.uabc.edu.gnomon.ui.calendario.Calendario
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_detalle.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Detalle_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Detalle_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detalle, container, false)
        val webview : WebView? = view.findViewById<WebView>(R.id.wvContainer)
        webview?.settings?.javaScriptEnabled = true

        val loadUrl = webview?.loadUrl("http://test.beetsool.com/gnomon/index.html")
        val button:Button = view.findViewById(R.id.button2)
        button.setOnClickListener {
            val fragment = Calendario()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
            //fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

            return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Detalle_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Detalle_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}