package com.antonioleiva.flowsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.antonioleiva.flowsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter = MainAdapter()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter
        ItemsProvider.observable.observe(this, Observer {
            adapter.items = it
        })
    }
}