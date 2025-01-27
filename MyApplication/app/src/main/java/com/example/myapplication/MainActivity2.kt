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

    private lateinit var textDisplayer: TextView
    private lateinit var textoDisplayer: TextView
    private lateinit var previousButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        previousButton = findViewById(R.id.btnPrevious)

        textoDisplayer = findViewById(R.id.textView3)
        textoDisplayer.text = intent.getStringExtra(EXTRA_TEXT)

        previousButton.setOnClickListener {
            val previousIntent = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(previousIntent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutPrincipal2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}