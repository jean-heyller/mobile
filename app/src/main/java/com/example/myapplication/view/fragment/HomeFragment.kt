package com.example.myapplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.view.viewmodel.JuegoViewModel

// HomeFragment es un Fragmento que representa una pantalla o sección de la interfaz de usuario.
// Utiliza Data Binding para acceder a las vistas del layout fragment_home.xml.
class HomeFragment : Fragment() {

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
        controladores(view)
        observadorViewModel()
        // Aquí puedes inicializar lógica relacionada con la vista.


    }


    private fun controladores(view: View){
        binding.botonGirar.setOnClickListener {

        }
    }


    private fun observadorViewModel(){
        observeRotacionBotella()
    }

    private fun observeRotacionBotella() {
       juegoViewModel.rotacionBotella.observe(viewLifecycleOwner){status ->


       }
    }
}