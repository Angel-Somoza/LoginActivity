package com.example.loginactivity.Visual.Menu.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginactivity.Data.Api.DonutAdapter
import com.example.loginactivity.Data.Api.DonutApi
import com.example.loginactivity.R
import com.example.loginactivity.Visual.Menu.Menu
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DonutListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DonutAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_donut_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://private-d24209-ocisneros.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(DonutApi::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val donuts = api.getDonuts()
                adapter = DonutAdapter(donuts) { selectedDonut ->
                    (activity as? Menu)?.showDonutDetail(selectedDonut)
                }
                recyclerView.adapter = adapter
            } catch (e: Exception) {
                // Manejo de errores
                e.printStackTrace()
            }
        }
    }
}