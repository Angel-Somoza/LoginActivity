    package com.example.loginactivity.Base

    import android.content.Context
    import android.graphics.Paint
    import android.os.Bundle
    import android.os.Message
    import android.view.Window
    import android.view.WindowManager
    import android.widget.TextView
    import android.widget.Toast
    import androidx.annotation.LayoutRes
    import androidx.appcompat.app.AppCompatActivity
    import com.example.loginactivity.R
    import com.example.loginactivity.databinding.ActivityMainBinding
    import com.example.loginactivity.databinding.ActivityRegisterBinding
    import kotlin.time.Duration

    abstract class Base_Activity: AppCompatActivity() {

        // usamos esto para evitar repetir codigo en el metodo oncreate
        override fun onCreate(savedInstanceState: Bundle?) {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
            super.onCreate(savedInstanceState)
            setContentView(getLayout())

        }

        @LayoutRes
        abstract fun getLayout(): Int
        fun Context.toast(
            context: Context = applicationContext,
            message: String?,
            duration: Int = Toast.LENGTH_SHORT
        ) {
            Toast.makeText(context, message, duration).show()
        }
    }




