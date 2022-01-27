package com.example.roomdb_33_tifany

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import com.example.roomdb_33_tifany.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextButton.setOnClickListener{
            if(!isUsernameValid(binding.usernameTextEdit.text!!)) {
                binding.usernameTextInput.error = "Username harus lebih dari 6 karakter"
            }else{
                if(!isPasswordValid(binding.passwordTextEdit.text!!)) {
                    binding.passwordTextInput.error = "Password harus lebih dari 8 karakter"
                }else{
                    binding.passwordTextInput.error = null

                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        binding.usernameTextEdit.setOnKeyListener{ _, _, _ ->
            if (isUsernameValid(binding.usernameTextEdit.text!!)) {
                binding.usernameTextInput.error = null
            }
            false
        }

        binding.passwordTextEdit.setOnKeyListener{ _, _, _ ->
            if (isPasswordValid(binding.passwordTextEdit.text!!)) {
                binding.passwordTextInput.error = null
            }
            false
        }
    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >=8
    }

    private fun isUsernameValid(text: Editable?): Boolean {
        return text != null && text.length >=6
    }
}