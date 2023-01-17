package com.algawas.signinproject

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    private val username = "Saifaldeen"
    private val password = "12Abc"

    fun confirmLength(pw: String): Boolean = pw.count()>=5


    fun confirmlogIn(user: String, pw: String): Boolean{
        Log.d("TAG", "confirmlogIn: ${confirmLength(pw)} user: $user pw: $pw")
        return confirmLength(pw) && user == username && pw == password
    }
}