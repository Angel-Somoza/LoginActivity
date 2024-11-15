package com.example.loginactivity.Visual.Register.View

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.loginactivity.Base.Base_Activity
import com.example.loginactivity.Data.Room.DataBase
import com.example.loginactivity.R
import com.example.loginactivity.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Register_Activity : Base_Activity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BtnSignUp.setOnClickListener {
            viewModel.Register(
                binding.EtUsuarioSignUp.text.toString(),
                binding.EtPw1SignUp.text.toString(),
                binding.EtPw2SignUp.text.toString()
            )
        }
        viewModel.NaviagateToActivity.observe(this) {
            finish()
        }
        viewModel.ErrorMessage.observe(this) { message ->
            message?.let {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Querido usario")
                builder.setMessage(message)
                builder.setPositiveButton("Aceptar") { dialog, _ ->
                    dialog.dismiss()
                }
                builder.create().show()
            }
        }


    }
    override fun getLayout(): Int {

        return (R.layout.activity_register)
    }



}




