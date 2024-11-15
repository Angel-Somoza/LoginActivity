package com.example.loginactivity.Visual.Menu.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.loginactivity.Data.Models.Donut
import com.example.loginactivity.R
import com.example.loginactivity.databinding.FragmentDonutDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DonutDetailFragment : Fragment() {
    private var _binding: FragmentDonutDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DonutDetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDonutDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()

        arguments?.getParcelable<Donut>(ARG_DONUT)?.let { donut ->
            viewModel.setDonut(donut)
        }
    }

    private fun setupObservers() {
        viewModel.donutDetail.observe(viewLifecycleOwner) { donut -> // Actualiza la UI con los datos del donut
            binding.apply {
                tvName.text = "Nombre: ${donut.name}"
                tvType.text = "Tipo: ${donut.type}"
                tvPrice.text = "Precio: $${donut.ppu}"
                tvBatters.text = "Masas: ${donut.batters.batter.joinToString(", ") { it.type }}"
                tvToppings.text = "Coberturas: ${donut.topping.joinToString(", ") { it.type }}"
            }
        }
    }

    override fun onDestroyView() { // Limpia el binding al destruir la vista
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_DONUT = "donut" // Nombre de la clave para el argumento

        fun newInstance(donut: Donut): DonutDetailFragment { // Crea una nueva instancia del fragmento
            return DonutDetailFragment().apply {// aplicamos los arugumetos al fragmento para pasarlo a la vista
                arguments = Bundle().apply { // bundle es un contenedor para guardar datos
                    putParcelable(ARG_DONUT, donut) // guarda el donut en el bundle
                }
            }
        }
    }
}