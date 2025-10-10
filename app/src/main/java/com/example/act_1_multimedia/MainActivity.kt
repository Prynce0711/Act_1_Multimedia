package com.example.act_1_multimedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.act_1_multimedia.navigation.Navigation
import com.example.act_1_multimedia.ui.theme.Act_1_MultimediaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Act_1_MultimediaTheme {
                Navigation()
            }
        }
    }
}
