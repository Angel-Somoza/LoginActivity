    package com.example.loginactivity.Visual.Login.View

    import android.content.Intent
    import android.graphics.Paint
    import android.os.Bundle
    import android.view.View
    import com.example.loginactivity.Base.Base_Activity
    import com.example.loginactivity.Data.LocalData.DataBase
    import com.example.loginactivity.Logic.Interactor.Login_Interactor.Login_Interactor_Impl

    import com.example.loginactivity.R
    import com.example.loginactivity.Visual.Login.Login_contract
    import com.example.loginactivity.Visual.Login.Presenter.Login_Presenter
    import com.example.loginactivity.Visual.Register.View.Register_Activity
    import com.example.loginactivity.databinding.ActivityMainBinding


    class Login_Activity : Base_Activity(),Login_contract.Login_View {

        lateinit var  presenter: Login_Presenter

        private lateinit var binding: ActivityMainBinding
        private lateinit var dbh: DataBase
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
//            presenter = Login_Presenter(Login_Interactor_Impl(DataBase(this)))

            presenter.attachView(this)

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
//            dbh = DataBase(this)

            binding.TvRegistrar.paintFlags = binding.TvRegistrar.paintFlags or Paint.UNDERLINE_TEXT_FLAG//subrayado de el view registrar.
            binding.TvRegistrar.setOnClickListener()
            {
                navigateToRegistro()
            }
            binding.BtnIngresar.setOnClickListener() {
                signIn()
            }
        }
        override fun showProgressBar() {
            binding.PbSighIn.visibility = View.VISIBLE
            binding.BtnIngresar.visibility = View.GONE
        }

        override fun hideProgressBar() {
            binding.PbSighIn.visibility = View.GONE
            binding.BtnIngresar.visibility = View.VISIBLE
        }

        override fun getLayout(): Int {
            return R.layout.activity_main
        }

        override fun showError(msgError: String?) {
            toast(this, msgError)    }


        override fun signIn() {
            val user = binding.EtUsuario.text.toString()
            val password = binding.EdPassword.text.toString()

            if (presenter.checkEmptyFields(user, password))  {
                toast(this, "agregar usuario y contraseña")
            }

            if (user.length < 8) {
                toast(this, "El nombre de usuario debe tener al menos 8 caracteres")
                return
            }

            if (password.length < 6 || !password.any { it.isUpperCase() }) {
                toast(this, "La contraseña debe tener al menos 6 caracteres y contener al menos una letra mayúscula")
                return
            }
                presenter.userandpassword(user, password)

        }

        override fun navigateToMain(user: String) {
            val intent = Intent(this, com.example.loginactivity.Visual.Menu.Menu::class.java)
            intent.putExtra("USERNAME", user)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
               }

        override fun navigateToRegistro() {
            startActivity(Intent(this, Register_Activity::class.java))
        }

        override fun onDestroy() {
            super.onDestroy()
            presenter.dettachView()
        }

        override fun onDetachedFromWindow() {
            super.onDetachedFromWindow()
            presenter.dettachView()
        }
    }
