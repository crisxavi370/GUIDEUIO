package com.example.adoptame.LoginSignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.adoptame.R
import com.example.adoptame.Activity_Dashboard
import com.example.adoptame.model.Usuario
import com.example.adoptame.viewmodel.UsuarioViewModel
import kotlinx.android.synthetic.main.activity_crear_cuenta.*
import kotlinx.android.synthetic.main.activity_start_up_screen.signup_btn

class SignUpActivity : AppCompatActivity() {

    private lateinit var mUsuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        mUsuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        signup_btn.setOnClickListener {
            //insertDataToDatabase()
            val firstname = signup_firstname.editText?.text.toString().trim()
            val lastnane = signup_lastname.editText?.text.toString().trim()
            val email = signup_email.editText?.text.toString().trim()
            val password = signup_password.editText?.text.toString().trim()
            if(inputCheck(firstname, lastnane, email, password )) {
                val user = Usuario(0, firstname, lastnane, email, password)
                mUsuarioViewModel.addUser(user)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Cuenta creada con exito. Inicia sesión", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        signup_login_button.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        signup_back_button.setOnClickListener {
            val intent = Intent(this, Activity_Dashboard::class.java)
            startActivity(intent)
        }

    }

    // Create user account
    private fun insertDataToDatabase() {
        val firstname = signup_firstname.editText?.text.toString().trim()
        val lastnane = signup_lastname.editText?.text.toString().trim()
        val email = signup_email.editText?.text.toString().trim()
        val password = signup_password.editText?.text.toString().trim()
        if(inputCheck(firstname, lastnane, email, password )) {
            val user = Usuario(0, firstname, lastnane, email, password)
            mUsuarioViewModel.addUser(user)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Cuenta creada con exito. Inicia sesión", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstname: String, lastname: String, email: String, password: String): Boolean {
        return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastname) && TextUtils.isEmpty(email) && TextUtils.isEmpty(password))
    }
}