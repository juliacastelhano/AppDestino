package br.edu.up.app.ui.destino

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import br.edu.up.app.data.Destino
import br.edu.up.app.data.Fotos
import br.edu.up.app.databinding.FragmentItemDestinoBinding

class DestinosAdapter(
    private val destinos: List<Destino>,
    val viewModel: DestinoViewModel
    ) :
    RecyclerView.Adapter<DestinosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemDestinoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemDestino = destinos[position]

        val idFoto = Fotos.get(itemDestino.foto)

        holder.imgFoto.setImageResource(idFoto)
        holder.txtNome.text = itemDestino.nome
        holder.txtPais.text = itemDestino.pais

        // editar destino
        holder.itemView.setOnClickListener { view ->
            viewModel.editar(itemDestino)
            val action = DestinosFragmentDirections.actionNavHomeToDestinoFragment()
            view.findNavController().navigate(action)
        }

        // excluir destino
        holder.itemView.setOnLongClickListener { view ->
            AlertDialog.Builder(view.context)
                .setMessage("ATENÇÃO: Tem certeza que deseja excluir este destino?")
                .setPositiveButton("Sim") { dialog, id ->
                    viewModel.excluir(itemDestino)
                }
                .setNegativeButton("CANCELAR") { dialog, id ->
                }
                .create()
                .show()
            true
        }
    }

    override fun getItemCount(): Int = destinos.size

    inner class ViewHolder(binding: FragmentItemDestinoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val imgFoto: ImageView = binding.imgFoto
        val txtNome: TextView = binding.txtNome
        val txtPais: TextView = binding.txtPais
    }

}