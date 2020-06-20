package adaptadores

import android.view.View

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uabc.edu.gnomon.R

class AdapterEmpresa(val favoritosList: Array<String>, onFavListener: OnFavoritoListener) : RecyclerView.Adapter<AdapterEmpresa.ViewHolder>()
{
    var onFavListener : OnFavoritoListener

    init {
        this.onFavListener = onFavListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.lista_favoritos,parent,false)
        return ViewHolder(view, onFavListener)
    }

    override fun getItemCount(): Int {
       return favoritosList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //var empresa: Empresa = favoritosList[position]
        holder.tituloempresa.text = "motiva"
        holder.tipoempresa.text = "Psicologia"

    }

    class ViewHolder(item:View,onFavListener:OnFavoritoListener) : RecyclerView.ViewHolder(item), View.OnClickListener
    {
        var onFavListener:OnFavoritoListener
        init {
            item.setOnClickListener(this)
            this.onFavListener = onFavListener
        }
        var tituloempresa:TextView = item.findViewById(R.id.titulo_empresa)
        var tipoempresa:TextView = item.findViewById(R.id.tipo_empresa)
        var imagen: ImageView = item.findViewById(R.id.imagen_empresa)

        override fun onClick(v: View?) {
            onFavListener.onFavoritoClick(adapterPosition)
        }

    }

    public interface OnFavoritoListener{
        fun onFavoritoClick(position:Int)
    }
}


