package com.example.loginactivity.Visual.Menu.Fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginactivity.Data.Models.Donut
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DonutDetailViewModel @Inject constructor() : ViewModel() {

    private val _donutDetail = MutableLiveData<Donut>()
    val donutDetail: LiveData<Donut> = _donutDetail

    fun setDonut(donut: Donut) {
        _donutDetail.value = donut
    }
}