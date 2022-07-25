package com.example.nomzy02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
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
            login()
        }
        nameFocusListener()
        emailFocusListener()
        passwordFocusListener()
        confirmPasswordFocusListener()
        passwordAndConfirmPasswordFocusListener()
    }

    private fun navigateToLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        val email = binding.tvLayoutEmail.text.toString()
        val pass = binding.tvLayoutEnterPassword.text.toString()
        val name = binding.tvLayoutFullName.text.toString()

        intent.putExtra("email",email)
        intent.putExtra("pass",pass)
        intent.putExtra("name",name)
        startActivity(intent)
    }
    private fun validName(): String? {
        val nameText = binding.tvLayoutFullName.text.toString()
        if(nameText.isEmpty())
        {return "Required"}
        if(!nameText.matches(".*[a-z].*".toRegex()))
        {
            return "must contain lowercase alphabet"
        }
        if(nameText.matches(".*[0-9].*".toRegex()))
        {
            return "must be an alphabet"
        }
        if(nameText.length < 3)
        { return "Minimum 3 character name" }

        return null
    }
    private fun validEmail(): String? {
        val emailText = binding.tvLayoutEmail.text.toString()
        if(emailText.isEmpty())
        {return "Required"}
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "Invalid Email Address"
        }
        return null
    }
    private fun validPassword(): String? {
        val passwordText = binding.tvLayoutEnterPassword.text.toString()
        if(passwordText.isEmpty())
        {return "Required"}
        if(passwordText.length < 8)
        { return "Minimum 8 character password" }
        return null
    }
    private fun validConfirmPassword(): String? {
        val confirmPasswordText = binding.tvLayoutConfirmPassword.text.toString()
        if(confirmPasswordText.isEmpty())
        {return "Required"}
//        if(confirmPasswordText.length < 8)
//        { return "Minimum 8 character password" }
        return null
    }
    private fun validPasswordAndConfirmPassword(): String? {
        val password = binding.tvLayoutEnterPassword.text.toString()
        val confirmPassword = binding.tvLayoutConfirmPassword.text.toString()
        if(confirmPassword.isEmpty())
        {return "Required"}
//        if(confirmPassword.length < 8)
//        { return "Minimum 8 character password" }
        if (password != confirmPassword){
            return "Password does not match"
        }
        return null
    }
    private fun login(){
        binding.etLayoutFullName.helperText = validName()
        binding.etLayoutEmail.helperText = validEmail()
        binding.etLayoutEnterPassword.helperText = validPassword()
        binding.etLayoutConfirmPassword.helperText = validConfirmPassword()
        binding.etLayoutConfirmPassword.helperText = validPasswordAndConfirmPassword()

        val validName = binding.etLayoutFullName.helperText == null
        val validEmail = binding.etLayoutEmail.helperText == null
        val validPassword = binding.etLayoutEnterPassword.helperText == null
        val validConfirmPassword = binding.etLayoutConfirmPassword.helperText == null
        val  validPasswordAndConfirmPassword = binding.etLayoutConfirmPassword.helperText == null

        if (validName && validEmail && validPassword && validConfirmPassword && validPasswordAndConfirmPassword){
            navigateToLoginActivity()
          //  resetForm()
        }
        else
            Toast.makeText(this, "Invalid Form",Toast.LENGTH_SHORT).show()
    }

    private fun resetForm() {
        binding.tvLayoutFullName.text = null
        binding.tvLayoutEmail.text = null
        binding.tvLayoutEnterPassword.text = null
        binding.tvLayoutConfirmPassword.text = null

        binding.etLayoutFullName.helperText = "Required"
        binding.etLayoutEmail.helperText = "Required"
        binding.etLayoutEnterPassword.helperText = "Required"
        binding.etLayoutConfirmPassword.helperText = "Required"
    }
    private fun nameFocusListener(){
        binding.tvLayoutFullName.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.etLayoutFullName.helperText = validName()
            }
        }
    }
    private fun emailFocusListener(){
        binding.tvLayoutEmail.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.etLayoutEmail.helperText = validEmail()
            }
        }
    }
    private fun passwordFocusListener(){
        binding.tvLayoutEnterPassword.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.etLayoutEnterPassword.helperText = validPassword()
            }
        }
    }
    private fun confirmPasswordFocusListener(){
        binding.tvLayoutConfirmPassword.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.etLayoutConfirmPassword.helperText = validConfirmPassword()
            }
        }
    }
    private fun passwordAndConfirmPasswordFocusListener(){
        binding.tvLayoutConfirmPassword.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.etLayoutConfirmPassword.helperText = validPasswordAndConfirmPassword()
            }
        }
    }

}