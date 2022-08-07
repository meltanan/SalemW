package com.example.salemweb.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeActivityViewModel: ViewModel() {

    suspend fun addingNumber(number: Int) = withContext(Dispatchers.IO){
        return@withContext number + 1
    }

    fun getNamesList(): List<String> = listOf("James Wiersma", "Angel Henderson", "Gustavo Loaiza", "Gregory Rogers", "Mohamed Eltanani", "Yaseen Eltanani", "Salem Web Network", "Richmond, Virginia", "Bible", "Android")
}