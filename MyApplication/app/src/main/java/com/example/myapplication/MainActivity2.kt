package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.MainActivity.Companion.EXTRA_TEXT

class MainActivity2 : AppCompatActivity() {

    private lateinit var textDisplayer : TextView
    private lateinit var previousButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        previousButton = findViewById(R.id.btnPrevious)

        val intent = intent
        val text = intent.getStringExtra(MainActivity.EXTRA_TEXT)

        textDisplayer = findViewById(R.id.tdTextDisplay)
        textDisplayer.text = text

        previousButton.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            intent.putExtra(EXTRA_TEXT, text)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutPrincipal2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}