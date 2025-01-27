package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var nextButton: Button
    private lateinit var layoutPrincipal: ConstraintLayout
    private lateinit var deuxiemeTextView: TextView
    private lateinit var tiTextInput : TextView
    private lateinit var validateButon : Button

    companion object {
        const val EXTRA_TEXT = "text_to_display"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        nextButton = findViewById(R.id.btnNext)
        layoutPrincipal = findViewById(R.id.layoutPrincipal)
        tiTextInput = findViewById(R.id.tiTextInput)
        validateButon = findViewById(R.id.btnValider)
        deuxiemeTextView = TextView(this)
        layoutPrincipal.addView(deuxiemeTextView)


        validateButon.setOnClickListener {
            val text = tiTextInput.text.toString()
        }

        nextButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra(EXTRA_TEXT, tiTextInput.text.toString())
            startActivity(intent)

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutPrincipal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}