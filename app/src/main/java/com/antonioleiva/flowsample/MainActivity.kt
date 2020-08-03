package com.antonioleiva.flowsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.antonioleiva.flowsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter = MainAdapter()
    private lateinit var binding: ActivityMainBinding
    private val observer = { items: List<String> -> adapter.items = items }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter
        ItemsProvider.observable.subscribe(observer)
    }

    override fun onDestroy() {
        ItemsProvider.observable.unsubscribe(observer)
        super.onDestroy()
    }
}