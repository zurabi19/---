package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var player1=findViewById<EditText>(R.id.editText)
        var player2=findViewById<EditText>(R.id.editText2)
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity,MainActivity2::class.java)
            intent.putExtra("player1",player1.text.toString())
            intent.putExtra("player2",player2.text.toString())

            startActivity(intent)
        }
    }



}