package com.example.walmartloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.walmart.account.User
import kotlinx.android.synthetic.main.activity_recover_password.*

class RecoverPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)
    }

    fun recoverPassword(view: View) {
        val intent = intent
        val userList = intent.getSerializableExtra("userList") as ArrayList<User>
        var email = email.text.toString()
        var user: User? = null
        for (element in userList) {
            if (element.username.equals(email)) {
                user = element
            }
        }
        if (user != null) {
            var emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Your new password is: ${user.password}")
            startActivity(emailIntent)
            Toast.makeText(this, "New Password Send To your email", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Email provided is invalid", Toast.LENGTH_LONG).show()
        }
    }
}
