package com.example.test_kotlincoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var myTextV : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTextV = findViewById(R.id.tx1)
        runBlocking { printMyTextAfterDelay("Amr nasser") }

    }

    private suspend fun printMyTextAfterDelay(myText : String){
        GlobalScope.launch(Dispatchers.IO) {
        delay(2000)
            withContext(Dispatchers.Main){
                myTextV.text = myText
            }
        }
    }
}