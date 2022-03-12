package com.example.adoptame.LoginSignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.adoptame.R
import com.example.adoptame.UserDashboardActivity
import com.example.adoptame.model.User
import com.example.adoptame.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_crear_cuenta.*
import kotlinx.android.synthetic.main.activity_start_up_screen.signup_btn

class SignUpActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        signup_btn.setOnClickListener {
            //insertDataToDatabase()
            val firstname = signup_firstname.editText?.text.toString().trim()
            val lastnane = signup_lastname.editText?.text.toString().trim()
            val email = signup_email.editText?.text.toString().trim()
            val password = signup_password.editText?.text.toString().trim()
            if(inputCheck(firstname, lastnane, email, password )) {
                val user = User(0, firstname, lastnane, email, password)
                mUserViewModel.addUser(user)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Have created account succesfull. Please Login again!!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }

        signup_login_button.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        signup_back_button.setOnClickListener {
            val intent = Intent(this, UserDashboardActivity::class.java)
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
            val user = User(0, firstname, lastnane, email, password)
            mUserViewModel.addUser(user)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Have created account succesfull. Please Login again!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstname: String, lastname: String, email: String, password: String): Boolean {
        return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastname) && TextUtils.isEmpty(email) && TextUtils.isEmpty(password))
    }
}