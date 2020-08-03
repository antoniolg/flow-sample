package com.antonioleiva.flowsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

object ItemsProvider {
    private val _observable = MutableLiveData<List<String>>()
    val observable: LiveData<List<String>> get() = _observable

    private var values = emptyList<String>()
    private val random = Random(System.currentTimeMillis())

    fun startEmitting() {
        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                delay(1000)
                values = values + random.nextInt().toString()
                _observable.value = values
            }
        }
    }
}