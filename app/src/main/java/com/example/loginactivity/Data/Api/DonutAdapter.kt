package com.example.loginactivity.Data.Api
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loginactivity.Data.Api.Models.Donut
import com.example.loginactivity.R


class DonutAdapter(
    private val donuts: List<Donut>,
    private val onItemClick: (Donut) -> Unit
) : RecyclerView.Adapter<DonutAdapter.DonutViewHolder>() {

    class DonutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvType: TextView = view.findViewById(R.id.tvType)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonutViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_donut, parent, false)
        return DonutViewHolder(view)
    }

    override fun onBindViewHolder(holder: DonutViewHolder, position: Int) {
        val donut = donuts[position]
        holder.tvName.text = "Nombre: ${donut.name}"
        holder.tvType.text = "Tipo: ${donut.type}"
        holder.tvPrice.text = "Precio: $${donut.ppu}"

        holder.itemView.setOnClickListener { onItemClick(donut) }
    }

    override fun getItemCount() = donuts.size
}