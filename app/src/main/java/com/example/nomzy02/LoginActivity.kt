package com.example.nomzy02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nomzy02.databinding.UserLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: UserLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email")
        val pass = intent.getStringExtra("pass")
        binding.loginActivityEmail.setText(email)
        binding.loginActivityPassword.setText(pass)

        val actionBar = supportActionBar
        actionBar!!.title = "LoginActivity"

        binding.loginActivityBtn.setOnClickListener {
            navigateToDashBoardActivity()
        }
    }
    private fun navigateToDashBoardActivity(){
        val intent = Intent(this, DashBoardActivity::class.java)
        startActivity(intent)
    }
}