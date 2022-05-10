package com.example.layouts_and_ui_learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleTetView: TextView = findViewById(R.id.titleTextView)
        val title = titleTetView.text

        val learnMoreButton: Button = findViewById(R.id.learnMoreButton)
        learnMoreButton.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }
    }
}