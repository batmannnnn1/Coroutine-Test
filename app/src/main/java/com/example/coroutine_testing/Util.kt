package com.example.coroutine_testing

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Util(val dispatcher:CoroutineDispatcher){

    suspend fun getUserName():String{
        delay(2000)
        return "ayann"
    }
    var value = false

    suspend fun getUser():String{
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            value = true
        }
        return "User - CheezyCode"
    }

    suspend fun getAddress():String{
        withContext(dispatcher){
            delay(500)
        }
        return "Delhi"

    }

}