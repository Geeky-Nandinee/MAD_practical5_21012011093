package com.example.mad_practical5_21012011093

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val browseButton: Button = findViewById(R.id.browse_btn)
        val dialno: EditText = findViewById(R.id.Phone)

        val editText: EditText = findViewById(R.id.url)
        browseButton.setOnClickListener() {
            openBrowser(editText.text.toString())
        }
        val callButton: Button = findViewById(R.id.call_btn)
        val editCall: EditText = findViewById(R.id.Phone)
        callButton.setOnClickListener() {
            call(editCall.text.toString())
        }
        val cal: Button = findViewById(R.id.button)
        cal.setOnClickListener() {
            callLog()
        }

        val galleryButton: Button = findViewById(R.id.button2)
        galleryButton.setOnClickListener() {
            gallery()
        }

        val cam: Button = findViewById(R.id.button3)
        cam.setOnClickListener() {
            camera()
        }

        val alr: Button = findViewById(R.id.button4)
        alr.setOnClickListener() {
            alarm()
        }

    }

    fun openBrowser(url: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }

    fun call(number: String) {
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$number")).also { startActivity(it) }
    }

    fun callLog() {
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also {
            startActivity(it)
        }

    }

    fun gallery() {
        Intent(Intent.ACTION_PICK).setType("image/*").also {
            startActivity(it)
        }
    }

    fun camera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
            startActivity(it)
        }
    }

    fun alarm() {
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also {
            startActivity(it)
        }
    }
}