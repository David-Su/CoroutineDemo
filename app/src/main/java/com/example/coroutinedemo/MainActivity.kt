package com.example.coroutinedemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val result = listOf(
                delaySuspend(),
                fakeSuspend(),
                withContextSuspend(),
                callBackSuspend(),
            )
            Log.d("TAG", "$result")
        }
    }

    private suspend fun fakeSuspend(): String {
        return "fakeSuspend"
    }

    private suspend fun delaySuspend(): String {
        delay(1000L)
        return "realSuspend"
    }

    private suspend fun withContextSuspend(): String = withContext(Dispatchers.Default) {
        "withContextSuspend"
    }

    private suspend fun callBackSuspend() = suspendCancellableCoroutine<String> { cont ->
        cont.resume("callBackSuspend")
    }
}