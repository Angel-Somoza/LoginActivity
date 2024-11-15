package com.example.loginactivity.Data.Api
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loginactivity.Data.Models.Donut
import com.example.loginactivity.databinding.ItemDonutBinding


class DonutAdapter( val onItemClick: (Donut) -> Unit) :
    RecyclerView.Adapter<DonutAdapter.DonutViewHolder>() {
    private var donuts: List<Donut> = emptyList()

    fun updateDonuts(NewDonuts: List<Donut>) { // funcion para actualizar los datos
        donuts = NewDonuts // actualizamos los datos
        notifyDataSetChanged()// notificamos al adaptador que los datos han cambiado
    }

    // para poder tener un acceso al onitemclick
    inner class DonutViewHolder(private val binding: ItemDonutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // instanciamos el binding y el root para poder acceder a la vista
        fun bind(donut: Donut) { // instanciamos a donut para poder acceder a sus atributos
            binding.apply { // aplicamos el binding
                tvName.text = "Nombre: ${donut.name}"
                tvType.text = "Tipo: ${donut.type}"
                tvPrice.text = "Precio: $${donut.ppu}"
//                tvBatters.text = "Masas en oferta: ${donut.batters.batter[1].type}"
                root.setOnClickListener { onItemClick(donut) }
                // configuramos el onitemclick cuando se hace click

            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DonutViewHolder { // creamos el viewholder
        return DonutViewHolder( // retornamos el viewholder
            ItemDonutBinding.inflate(// inflamos el layout para poder acceder a sus atributos
                LayoutInflater.from(parent.context),// inflamos el layout con el from del parent
                parent, // esto es para poder inflar el layout en el parent
                false // esto es para que no se infle en el parent
            )
        )
    }

//        override fun onBindViewHolder(holder: DonutViewHolder, position: Int) {
//            val donut = getItem(position)
//            holder.bind(donut)
//            holder.itemView.setOnClickListener { onDonutClick(donut) }
//        }

    override fun onBindViewHolder(holder: DonutViewHolder, position: Int) {
        holder.bind(donuts[position]) // llamamos a la funcion bind para poder acceder a los atributos del donut

        // position es la posicion del donut en la lista
    }

    override fun getItemCount() = donuts.size // retornamos el tamaño de la lista

//        object DiffCallback : DiffUtil.ItemCallback<Donut>() {
//            override fun areItemsTheSame(oldItem: Donut, newItem: Donut) =
//                oldItem.id == newItem.id
//
//            override fun areContentsTheSame(oldItem: Donut, newItem: Donut) =
//                oldItem == newItem
//        }

}