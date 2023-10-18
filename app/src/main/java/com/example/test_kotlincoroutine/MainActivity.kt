package com.example.test_kotlincoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
  //  lateinit var myTextV : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // myTextV = findViewById(R.id.tx1)
       // runBlocking { printMyTextAfterDelay("Amr nasser") }

        GlobalScope.launch {
            val time = measureTimeMillis {
                val dataUser = async { getUserFromDatabase() }
                val localUser = async { getUserFromNetwork() }


                if (dataUser.await()==localUser.await()){
                    Log.d("here", "equal: ")

                }else {
                    Log.d("here", "not equal: ")
                }
            }
            Log.d("here", time.toString())
        }

    }

   /*  private suspend fun printMyTextAfterDelay(myText : String){
        GlobalScope.launch(Dispatchers.IO) {
        delay(2000)
            withContext(Dispatchers.Main){
                myTextV.text = myText
            }
        }
    } */

    private suspend fun getUserFromNetwork():String{
        delay(2000)
        return "Amr"
    }
    private suspend fun getUserFromDatabase():String{
        delay(2000)
        return "Amr"
    }
}