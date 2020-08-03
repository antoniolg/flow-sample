package com.antonioleiva.flowsample

class Observable<T>(var value: T) {
    private var observers: MutableList<(T) -> Unit> = mutableListOf()

    fun subscribe(observer: (T) -> Unit) {
        observers.add(observer)
        observer(value)
    }

    fun unsubscribe(observer: (T) -> Unit) {
        observers.remove(observer)
    }

    fun updateValue(newValue: T) {
        value = newValue
        notifyObservers()
    }

    private fun notifyObservers() {
        observers.forEach { it(value) }
    }
}