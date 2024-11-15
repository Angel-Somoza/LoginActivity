package com.example.loginactivity.Visual.Menu.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginactivity.Data.Api.DonutAdapter
import com.example.loginactivity.Data.Api.DonutApi
import com.example.loginactivity.Data.Models.Donut
import com.example.loginactivity.R
import com.example.loginactivity.Visual.Menu.Menu
import com.example.loginactivity.databinding.FragmentDonutListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class DonutListFragment : Fragment() {
    private var _binding: FragmentDonutListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DonutListFragmentViewModel by viewModels()
    private lateinit var adapter: DonutAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDonutListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchDonuts()
        setupRecyclerView()
       setupObservers()

    }

    private fun setupRecyclerView() {
        adapter = DonutAdapter { donut ->
            view?.visibility = View.GONE
            val action = DonutListFragmentDirections.actionDonutListFragmentToDonutDetailFragment(donut)
            findNavController().navigate(action)

        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@DonutListFragment.adapter
        }
    }

    private fun setupObservers() {
        viewModel.donuts.observe(viewLifecycleOwner) { donuts ->
           adapter.updateDonuts(donuts)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//    private fun onDonutClick() {
//        val action = DonutListFragmentDirections.actionDonutListFragmentToDonutDetailFragment()
//        findNavController().navigate(action)
//
//    }
}