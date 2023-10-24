package br.edu.up.app.ui.destino

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.edu.up.app.data.Destino
import br.edu.up.app.databinding.FragmentDestinoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DestinoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel : DestinoViewModel by activityViewModels()
        val binding = FragmentDestinoBinding.inflate(layoutInflater)

        // ************* MUDAR NOMES DOS INPUTS ************
        val destino = viewModel.destino
        binding.inputNome.setText(destino.nome)
        binding.inputPais.setText(destino.pais)
        binding.inputPontosTuristicos.setText(destino.pontosTuristicos)
        binding.inputPrevisaoPartida.setText(destino.previsaoPartida)
        binding.inputFoto.setText(destino.foto)

        binding.btnSalvar.setOnClickListener {
            val destinoSalvar = Destino(
                destino.id,
                binding.inputNome.text.toString(),
                binding.inputPais.text.toString(),
                binding.inputPontosTuristicos.text.toString(),
                binding.inputPrevisaoPartida.text.toString(),
                binding.inputFoto.text.toString(),
            )
            viewModel.destino = destinoSalvar
            viewModel.salvar()
            findNavController().popBackStack()
        }

        return binding.root
    }
}