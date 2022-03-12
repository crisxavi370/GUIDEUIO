package com.example.adoptame

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adoptame.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_peril_usuario.*


class ProfileActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peril_usuario)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userProfile()

        back_pressed_profile.setOnClickListener {
            super.onBackPressed()
        }
    }

    fun userProfile() {
        val spf = getSharedPreferences("myuserpassword", Context.MODE_PRIVATE)
        val email = spf.getString("email", null)
        val password = spf.getString("password", null)
        if(email!=null && password!=null) {
            var userprofile = mUserViewModel.findUserByEmailPassword(email, password)
            userprofile.observe(this, Observer {user->
                user.forEach {u->
                    contact_profile.text = u.email.toString()
                    username.text = u.firstName.toString() + " " + u.lastName.toString()
                }
            })
        }
    }
}