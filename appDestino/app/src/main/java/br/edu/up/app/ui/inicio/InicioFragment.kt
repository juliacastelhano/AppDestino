package br.edu.up.app.ui.inicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.up.app.R
import br.edu.up.app.databinding.FragmentInicioBinding
import br.edu.up.app.databinding.FragmentListaDestinosBinding
import br.edu.up.app.ui.destino.DestinoViewModel
import br.edu.up.app.ui.destino.DestinosAdapter
import br.edu.up.app.ui.destino.DestinosFragmentDirections
import kotlinx.coroutines.launch

class InicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Injeção automática de dependência
        val viewModel : DestinoViewModel by activityViewModels()

        val binding = FragmentInicioBinding.inflate(layoutInflater)

        binding.btnCadastrar.setOnClickListener { view ->
            viewModel.novo()

            val action = DestinosFragmentDirections.actionNavGalleryToDestinoFragment()

            findNavController(R.id.nav_host_fragment_content_main).navigate(action)
        }


    // This property is only valid between onCreateView and
    // onDestroyView.
//    private val binding get() = _binding!!

/*    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(InicioViewModel::class.java)

        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val viewModel : DestinoViewModel by viewModels()*/

//        _binding.btnCadastrar.setOnClickListener{ view ->
//            viewModel.novo()
//            //Action safeArgs
//            val action = DestinosFragmentDirections.actionNavHomeToDestinoFragment()
//            //Nav controller
//            findNavController(R.id.nav_host_fragment_content_main).navigate(action)
//        }




//        val textView: TextView = binding.textGallery
//        galleryViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
//        return root
//    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
