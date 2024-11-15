package com.example.loginactivity.Visual.Menu.Fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginactivity.Data.Models.Donut
import com.example.loginactivity.Data.Repositorys.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
//al hacer esto no pasa nada
@HiltViewModel
class DonutListFragmentViewModel  @Inject constructor(
    private val repository: NetworkRepository // Asume que tienes un repositorio
) : ViewModel() {
    private val _donuts = MutableLiveData<List<Donut>>()
    val donuts: LiveData<List<Donut>> = _donuts

    fun fetchDonuts() {
        viewModelScope.launch {
            try {
                val result = repository.getDonuts()
                _donuts.value = result
            } catch (e: Exception) {

            }
        }
    }
}