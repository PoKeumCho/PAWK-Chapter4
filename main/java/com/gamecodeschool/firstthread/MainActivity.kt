package com.gamecodeschool.firstthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** -- Looper & Handler -- **/
        var looper = Thread {
            Looper.prepare()    // initialized
            Looper.loop()
        }
        looper.start()

        // Creating a Handler that posts tasks to the UI Thread
        var handler = Handler(Looper.getMainLooper())
    }
}