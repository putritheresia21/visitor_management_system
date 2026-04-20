package com.example.visitormanagementapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.visitormanagementapp.screens.RegistrationScreen
import com.example.visitormanagementapp.ui.theme.VisitorManagementAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitorManagementAppTheme {
                RegistrationScreen()
            }
        }
    }
}
