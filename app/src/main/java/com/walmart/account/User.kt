package com.walmart.account

import java.io.Serializable

class User(firstName: String, lastName: String, username: String, password: String) :Serializable{
    var firstName: String = firstName
    var lastName: String = lastName
    var username: String = username
    var password: String = password
}