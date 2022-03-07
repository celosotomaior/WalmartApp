package com.example.walmartloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.walmart.account.User
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun clear() {
        firstName.text.clear()
        lastName.text.clear()
        username.text.clear()
        password.text.clear()
    }

    fun createAccount(view: View) {
        val fName = firstName.text.toString()
        val lName = lastName.text.toString()
        val username = username.text.toString()
        val password = password.text.toString()
        var newUser = User(fName, lName, username, password)
        if (fName != "" && lName != "" && username != "" && password != "") {
            val intent = intent
            var userList: ArrayList<User>? =
                intent.getSerializableExtra("userList") as ArrayList<User>
            if (userList != null) {
                userList.add(newUser)
                Toast.makeText(this, "You Can Login Now, Account Was Created!!", Toast.LENGTH_LONG)

                val intentObject = Intent(this, MainActivity::class.java)
                intentObject.putExtra("userList", userList)
                startActivity(intentObject)
                clear()
            } else {
                Toast.makeText(this, "Create Account Failed!!", Toast.LENGTH_LONG)
            }
        }
    }
}
