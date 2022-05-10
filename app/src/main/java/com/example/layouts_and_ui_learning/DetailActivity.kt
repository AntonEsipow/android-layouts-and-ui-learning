package com.example.layouts_and_ui_learning

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val textView: TextView = findViewById(R.id.textView)
        textView.text = intent.getStringExtra("title") ?: "No title"
    }
}