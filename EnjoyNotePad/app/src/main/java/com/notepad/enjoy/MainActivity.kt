package com.notepad.enjoy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.notepad.enjoy.navhost.MyAppNavGraph
import com.notepad.enjoy.ui.theme.EnjoyNotePadTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EnjoyNotePadTheme {
                MyAppNavGraph()
            }
        }
    }
}
