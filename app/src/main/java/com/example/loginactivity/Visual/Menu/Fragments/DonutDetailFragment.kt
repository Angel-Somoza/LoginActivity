package com.example.loginactivity.Visual.Menu.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.loginactivity.Data.Models.Donut
import com.example.loginactivity.R

class DonutDetailFragment : Fragment() {
    private var donut: Donut? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_donut_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvName).text = "Nombre: ${donut?.name}"
        view.findViewById<TextView>(R.id.tvType).text = "Tipo: ${donut?.type}"
        view.findViewById<TextView>(R.id.tvPrice).text = "Precio: $${donut?.ppu}"
        view.findViewById<TextView>(R.id.tvBatters).text = "Masas: ${donut?.batters?.batter?.joinToString(", ") { it.type }}"
        view.findViewById<TextView>(R.id.tvToppings).text = "Coberturas: ${donut?.topping?.joinToString(", ") { it.type }}"
    }

    companion object {
        fun newInstance(donut: Donut): DonutDetailFragment {
            val fragment = DonutDetailFragment()
            fragment.donut = donut
            return fragment
        }
    }
}