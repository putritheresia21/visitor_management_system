package com.example.visitormanagementapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationScreen() {
    val steps = listOf("First Form")
    var currentStep by remember { mutableIntStateOf(1) }
    val totalSteps = steps.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF6200EE)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Welcome Visitor",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Please fill in the form below",
                    color = Color.White.copy(alpha = 1f),
                    fontSize = 16.sp
                )
            }
        }

        StepIndicator(currentStep = currentStep, totalSteps = totalSteps)

        Box(modifier = Modifier.weight(1f)) {
            when (currentStep) {
                1 -> ProfileForm()

            }
        }
    }
}

@Composable
fun StepIndicator(currentStep: Int, totalSteps: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(26.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..totalSteps) {
            val isActive = i <= currentStep

            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(if (isActive) Color(0xFF03DAC5) else Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = i.toString(),
                    color = if (isActive) Color.Black else Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )
            }

            if (i < totalSteps) {
                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(2.dp)
                        .background(if (i < currentStep) Color(0xFF03DAC5) else Color(0xFFE0E0E0))
                )
            }
        }
    }
}
