package com.example.myapplication.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.view.viewmodel.JuegoViewModel

// HomeFragment es un Fragmento que representa una pantalla o sección de la interfaz de usuario.
// Utiliza Data Binding para acceder a las vistas del layout fragment_home.xml.
class HomeFragment : Fragment() {

    //private lateinit var navController : NavController

    private val juegoViewModel: JuegoViewModel by viewModels()

    // 'binding' permite acceder a las vistas del layout usando Data Binding.
    // Se inicializa en onCreateView.
    private lateinit var binding: FragmentHomeBinding

    /**
     * Crea y retorna la vista asociada al fragmento.
     * @param inflater: Infla (convierte) el archivo XML de layout en objetos View.
     * @param container: ViewGroup padre donde se insertará la vista del fragmento.
     * @param savedInstanceState: Si no es null, contiene datos del estado previo del fragmento.
     * @return La vista raíz del layout del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout usando Data Binding y asigna el lifecycleOwner.
        binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
        // La línea siguiente es innecesaria porque ya se retorna binding.root.
        // return inflater.inflate(R.layout.fragment_home, container, false)
    }

    /**
     * Se llama después de que la vista ha sido creada.
     * @param view: La vista raíz retornada por onCreateView.
     * @param savedInstanceState: Datos del estado previo, si existen.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
        observadorViewModel()
        // Aquí puedes inicializar lógica relacionada con la vista.


    }


    private fun controladores() {
        //navController = view.findNavController()
        binding.icContentMenu.icImgReglas.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_reglasJuegoFragment)
        }

        binding.botonGirar.setOnClickListener {
            juegoViewModel.girarBotella()

        }
    }


    private fun observadorViewModel() {
        observeRotacionBotella()
        observeHabilitarBoton()
        observeMostrarSerpentina()
    }

    private fun observeMostrarSerpentina() {
        juegoViewModel.mostrarSerpentina.observe(viewLifecycleOwner) { mostrarSerpentina ->
            binding.lottieCerpentina.isVisible = mostrarSerpentina
            binding.lottieCerpentina.playAnimation()
        }
    }

    private fun observeHabilitarBoton() {
        juegoViewModel.habilitarBoton.observe(viewLifecycleOwner) { habilitarBoton ->
            binding.botonGirar.isVisible = habilitarBoton
            binding.lottieCerpentina.isVisible = !habilitarBoton
        }
    }

    private fun observeRotacionBotella() {
        juegoViewModel.rotacionBotella.observe(viewLifecycleOwner) { rotacion ->
            juegoViewModel.estadoRotacionBotella.observe(viewLifecycleOwner) { estadoRotacion ->
                if (estadoRotacion) {
                    binding.ivBotella.startAnimation(rotacion)
                }
            }
        }
    }
}