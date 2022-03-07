package com.example.walmartloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.walmart.account.User
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity() {

    lateinit var result: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
        val intent = intent
        result = intent.getSerializableExtra("user") as User
        loggedUser.text = result.username
    }

    fun onBeautyClicked(view: View) {
        Toast.makeText(this, "You chose the Beauty category of shopping", Toast.LENGTH_LONG).show()
    }

    fun onClothesClicked(view: View) {
        Toast.makeText(this, "You chose the Clothes category of shopping", Toast.LENGTH_LONG).show()
    }

    fun onElectronicClicked(view: View) {
        Toast.makeText(this, "You chose the Electronics category of shopping", Toast.LENGTH_LONG).show()
    }

    fun onShoesClicked(view: View) {
        Toast.makeText(this, "You chose the Shoes category of shopping", Toast.LENGTH_LONG).show()
    }

}
