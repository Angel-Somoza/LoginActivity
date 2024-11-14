package com.example.loginactivity.Visual.Register.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.loginactivity.Base.Base_Activity
import com.example.loginactivity.Data.LocalData.DataBase
import com.example.loginactivity.Logic.Interactor.Register_Interactor.Register_Interactor_Impl
import com.example.loginactivity.R
import com.example.loginactivity.Visual.Register.Presenter.Register_Presenter
import com.example.loginactivity.Visual.Register.Register_Contract
import com.example.loginactivity.databinding.ActivityRegisterBinding

class Register_Activity : Base_Activity(),Register_Contract.Register_View {
    private lateinit var binding: ActivityRegisterBinding

    private lateinit var presenter: Register_Presenter

    private lateinit var db: DataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        presenter = Register_Presenter(Register_Interactor_Impl(DataBase(this)))
        presenter.attach_View(this)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        db = DataBase(this)

        binding.BtnSignUp.setOnClickListener {
              signUp()
        }


    }

    override fun getLayout(): Int {

        return (R.layout.activity_register)
    }

    override fun navigate_ToMain(user: String) {
        val intent = Intent(this, com.example.loginactivity.Visual.Menu.Menu::class.java)
        intent.putExtra("USERNAME", user)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun signUp() {
        val user = binding.EtUsuarioSignUp.text.toString()
        val password = binding.EtPw1SignUp.text.toString()
        val cpassword = binding.EtPw2SignUp.text.toString()
        if (presenter.check_EmptyName(user)) {
            binding.EtUsuarioSignUp.error = "Ingrese su usuario"
            return
        }
        if (user.length < 8) {
            binding.EtUsuarioSignUp.error = "El nombre de usuario debe tener al menos 8 caracteres"
            return
        }

        if (presenter.check_Empty_Passwords(password, cpassword)) {
            binding.EtPw1SignUp.error = "Ingrese su contraseña"
            binding.EtPw2SignUp.error = "Ingrese su contraseña"
            return
        }

        if (password.length < 6 || !password.any { it.isUpperCase() }) {
            binding.EtPw1SignUp.error = "La contraseña debe tener al menos 6 caracteres y contener al menos una letra mayúscula"
            return
        }

       if (!presenter.check_Password_Match(password, cpassword)) {
            binding.EtPw1SignUp.error = "Las contraseñas no coinciden"
            binding.EtPw2SignUp.error = "Las contraseñas no coinciden"
       }
     presenter.signUp(user, password)
    }

        override fun Show_Progress() {
            binding.PbSignUp.visibility = View.VISIBLE
            binding.BtnSignUp.visibility = View.GONE
        }

        override fun hideProgress() {
            binding.PbSignUp.visibility = View.GONE
            binding.BtnSignUp.visibility = View.VISIBLE
        }

        override fun showError(errormsg: String) {
            toast(this, errormsg)
        }

    override fun showSuccessMessage(message: String) {
        toast(this, message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach_View()
    }
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detach_View()
    }

}




