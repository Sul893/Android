package com.example.hw1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val text = remember { mutableStateOf("") }
            val context = LocalContext.current

            Column(Modifier.fillMaxSize()) {
                TextField(
                    value = text.value,
                    onValueChange = { text.value = it }
                )

                Button(onClick = {
                    val intent = Intent(context, MainActivity2::class.java)
                    intent.putExtra("text", text.value)
                    context.startActivity(intent)
                }) {
                    Text("Второй экран")
                }

                Button(onClick = {
                    val intent = Intent(context, MainActivity3::class.java)
                    intent.putExtra("text", text.value)
                    context.startActivity(intent)
                }) {
                    Text("Третий экран")
                }
            }
        }
    }
}