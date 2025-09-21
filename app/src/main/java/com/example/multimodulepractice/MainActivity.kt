package com.example.multimodulepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.multimodulepractice.ui.theme.MultiModulePracticeTheme
import com.example.network.Character
import com.example.network.KtorClient
import com.example.network.TestText

class MainActivity : ComponentActivity() {
    private val client = KtorClient()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var character by remember { mutableStateOf<Character?>(null) }

            LaunchedEffect( key1=Unit, block = {
               character = client.getCharacter(27)
            })
            MultiModulePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize().padding(top = 32.dp)){
                        Card(modifier = Modifier.padding(16.dp)) {
                            Column {
                                Text("Id : ${character?.id}")
                                Text("Name : ${character?.name}")
                                Text("Origin : ${character?.origin}")
                            }
                        }
                    }
                }
            }
        }
    }
}