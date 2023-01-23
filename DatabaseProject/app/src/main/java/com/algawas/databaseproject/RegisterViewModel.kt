package com.algawas.databaseproject

import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel(){

    fun checkPhone(phone: String): Boolean{
        //has @, has .com? maybe check from xml
       return if (phone.isEmpty()) false else true
    }

    fun isPhoneValid(phone: String){
        //phone.length
    }

}