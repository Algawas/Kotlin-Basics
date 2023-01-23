package com.algawas.databaseproject

import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel(){

    //Use when instead of Ifs
    fun checkPhone(phone: String): Boolean{
       return (phone.isNotEmpty() && phone.length>=10)
    }

    fun checkEmail(email: String): Boolean{
        return (email.isNotEmpty() &&
                email.contains("@"))
    }

    fun checkName(name: String): Boolean{
        return name.isNotEmpty()
    }
    fun isPhoneValid(phone: String, name: String, email: String): Boolean{
        return (checkPhone(phone) &&
                checkName(name) &&
                checkEmail(email))
    }
}