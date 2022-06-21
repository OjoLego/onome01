package com.example.nomzy02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var buttonGetStarted : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        buttonGetStarted = findViewById(R.id.buttonGetStarted)
        buttonGetStarted.setOnClickListener {
            navigateToRegistrationActivity()
        }
    }
    private fun navigateToRegistrationActivity(){
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }
}
