package com.example.walmartloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.walmart.account.User
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var listOfUsers = arrayListOf<User>()
    var extraList: ArrayList<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user1 = User("Marcelo", "Andrade", "mandrade@miu.edu", "012")
        val user2 = User("Pedro", "Almeida", "palmeida@miu.edu", "012")
        val user3 = User("Anderson", "Smith", "asmith@miu.edu", "012")
        val user4 = User("John", "Ballazi", "jballazi@miu.edu", "012")
        val user5 = User("Max", "Almada", "malmada@miu.edu", "012")
        listOfUsers = arrayListOf(user1, user2, user3, user4, user5)
    }


    fun login(view: View) {
        var username = username.text.toString();
        var password = password.text.toString();

        var user: User? = null
        var newList = listOfUsers

        val intent = intent
        try {
            extraList = intent.getSerializableExtra("listOfUsers") as ArrayList<User>
        } catch (e: Exception) {

        }

        if (newList.size > listOfUsers.size) {
            listOfUsers = newList
        }

        if (extraList != null) {
            newList = extraList as ArrayList<User>
        }

        for (element in listOfUsers) {
            if (element.username.equals(username) && element.password.equals(password)) {
                user = element
            }
        }
        if (user == null) {
            Toast.makeText(this, "User Verification Error!!!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "User Verified", Toast.LENGTH_SHORT).show();
            val intent = Intent(this@MainActivity, ShoppingCategory::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }

    fun forgotPassword(view: View) {
        val intent = Intent(this, RecoverPassword::class.java)
        intent.putExtra("listOfUsers", listOfUsers)
        startActivity(intent)
    }

    fun createAccount(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("listOfUsers", listOfUsers)
        startActivity(intent)
    }

}
