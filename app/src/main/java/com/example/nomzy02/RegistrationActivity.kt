package com.example.nomzy02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nomzy02.databinding.RegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: RegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "RegistrationActivity"

        binding.buttonRegistration.setOnClickListener {
            navigateToLoginActivity()
        }
    }
    private fun navigateToLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
