package com.antonioleiva.flowsample

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

object ItemsProvider {
    val observable = Observable<List<String>>(emptyList())
    private var values = emptyList<String>()
    private val random = Random(System.currentTimeMillis())

    fun startEmitting() {
        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                delay(1000)
                values = values + random.nextInt().toString()
                observable.updateValue(values)
            }
        }
    }
}