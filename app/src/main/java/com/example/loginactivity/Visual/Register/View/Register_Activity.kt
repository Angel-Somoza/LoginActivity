package com.example.loginactivity.Visual.Register.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.loginactivity.Base.Base_Activity
import com.example.loginactivity.Data.Room.DataBase
import com.example.loginactivity.R
import com.example.loginactivity.Visual.Register.Presenter.Register_Presenter
import com.example.loginactivity.Visual.Register.Register_Contract
import com.example.loginactivity.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Register_Activity : Base_Activity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BtnSignUp.setOnClickListener {
        }


    }
    override fun getLayout(): Int {

        return (R.layout.activity_register)
    }



}




