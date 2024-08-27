package com.example.coroutinedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val result1 = realSuspend()
            val result2 = fakeSuspend()
            Log.d("TAG", "${result1} ${result2}")
        }
    }

    private suspend fun fakeSuspend(): String {
        return "fakeSuspend"
    }

    private suspend fun realSuspend(): String {
        return "realSuspend"
    }
}