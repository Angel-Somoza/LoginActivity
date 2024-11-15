package com.example.loginactivity.Visual.Menu

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.loginactivity.Data.Models.Donut
import com.example.loginactivity.R
import com.example.loginactivity.Visual.Login.View.Login_Activity
import com.example.loginactivity.Visual.Menu.Fragments.DonutDetailFragment
import com.example.loginactivity.Visual.Menu.Fragments.DonutListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)



        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, DonutListFragment())
                .commit()
      }
        val username = intent.getStringExtra("USERNAME")
        val tvTitle = findViewById<TextView>(R.id.tv_title)
        tvTitle.text = "Querido usuario bienvenido, $username"

    }

       override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logout() {
        val intent = Intent(this, Login_Activity::class.java)
        startActivity(intent)
        finish()
    }


    fun showDonutDetail(donut: Donut) {
        val detailFragment = DonutDetailFragment.newInstance(donut)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}