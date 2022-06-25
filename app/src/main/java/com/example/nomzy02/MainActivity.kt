package com.example.nomzy02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nomzy02.databinding.SplashBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: SplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "GetStarted"

        binding.buttonGetStarted.setOnClickListener {
            navigateToRegistrationActivity()
        }
    }
    private fun navigateToRegistrationActivity(){
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }
}
