package com.example.nomzy02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nomzy02.databinding.DashboardBinding

class DashBoardActivity : AppCompatActivity() {

    private lateinit var binding: DashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        binding.textView2.text = "Welcome back $name !"

        val actionBar = supportActionBar
        actionBar!!.title = "DashBoardActivity"
    }
}