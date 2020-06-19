package adaptadores

import android.view.View
import Entidades.Empresa
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uabc.edu.gnomon.R

class AdapterEmpresa(val favoritosList: Array<String> ) : RecyclerView.Adapter<AdapterEmpresa.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.lista_favoritos,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return favoritosList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //var empresa: Empresa = favoritosList[position]
        holder.tituloempresa.text = "motiva"
        holder.tipoempresa.text = "Psicologia"

    }

    class ViewHolder(item:View) : RecyclerView.ViewHolder(item)
    {
        var tituloempresa:TextView = item.findViewById(R.id.titulo_empresa)
        var tipoempresa:TextView = item.findViewById(R.id.tipo_empresa)
        var imagen: ImageView = item.findViewById(R.id.imagen_empresa)

    }


}


