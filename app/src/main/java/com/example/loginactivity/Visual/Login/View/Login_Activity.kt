package com.example.loginactivity.Visual.Login.View

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.loginactivity.Base.Base_Activity
import com.example.loginactivity.R
import com.example.loginactivity.Visual.Menu.Menu
import com.example.loginactivity.Visual.Register.View.Register_Activity
import com.example.loginactivity.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Login_Activity : Base_Activity() {
    private  val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.TvRegistrar.setOnClickListener()
        {
            viewModel.Register_Click()
        }
        binding.BtnIngresar.setOnClickListener() {
            viewModel.Login(
                binding.EtUsuario.text.toString().trim(),
                binding.EdPassword.text.toString().trim()
            )
        }

        try {
            viewModel.ErrorMessage.observe(this, Observer { message ->
                message?.let {

                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Querido usario")
                    builder.setMessage(it)
                    builder.setPositiveButton("Aceptar") { dialog, _ ->
                        dialog.dismiss()
                    }
                    builder.create().show()
                }
            })
        }catch (e:Exception)
        {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Querido usario")
            builder.setMessage(e.message)
            builder.setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            builder.create().show()
        }


       try {
           viewModel.NaviagateToActivity.observe(this) {
               val intent = Intent(this, Register_Activity::class.java)
               startActivity(intent)
           }
       } catch (e: Exception){
           val builder = AlertDialog.Builder(this)
           builder.setTitle("Querido usario")
           builder.setMessage(e.message)
           builder.setPositiveButton("Aceptar") { dialog, _ ->
               dialog.dismiss()
           }
           builder.create().show()
       }
         //resultados, Login
        try {
            viewModel.NaviagateToMenu.observe(this) { username ->
                val intent = Intent(this, Menu::class.java)
                intent.putExtra("USERNAME", username)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }catch (e: Exception){
            toast(this, e.message)
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }
}




