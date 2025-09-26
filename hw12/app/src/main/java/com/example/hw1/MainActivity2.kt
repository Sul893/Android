package com.example.hw1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val text = intent.getStringExtra("text") ?: "Экран 2"

            Column(Modifier.fillMaxSize()) {
                Text(text)

                Button(onClick = {
                    val intent = Intent(context, MainActivity3::class.java)
                    intent.putExtra("text", text)
                    context.startActivity(intent)
                }) {
                    Text("Третий экран")
                }

                Button(onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }) {
                    Text("Первый экран")
                }
            }
        }
    }
}