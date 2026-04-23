package com.example.visitormanagementapp.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.visitormanagementapp.viewmodel.RegisterViewModel
import kotlinx.coroutines.launch

@Composable
fun RegistrationScreen(
    viewModel: RegisterViewModel = viewModel()
) {
    val steps = listOf("Profile", "Visit", "Confirmation")
    var currentStep by remember { mutableIntStateOf(1) }
    val totalSteps = steps.size
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = {
            Surface(
                color = Color.White,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if (currentStep > 1) {
                        Button(
                            onClick = { currentStep-- },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                        ) {
                            Text("Previous", color = Color.White)
                        }
                    } else {
                        Spacer(modifier = Modifier.size(1.dp))
                    }

                    if (currentStep < totalSteps) {
                        Button(
                            onClick = {
                                when (currentStep) {
                                    1 -> {
                                        if (viewModel.isProfileFormValid()) {
                                            currentStep++
                                        } else {
                                            scope.launch {
                                                snackbarHostState.showSnackbar("Please complete the profile form")
                                            }
                                        }
                                    }
                                    2 -> {
                                        if (viewModel.isVisitFormValid()) {
                                            currentStep++
                                        } else {
                                            scope.launch {
                                                snackbarHostState.showSnackbar("Please complete the visit details")
                                            }
                                        }
                                    }
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
                        ) {
                            Text("Next", color = Color.White)
                        }
                    } else {
                        Button(
                            onClick = {
                                viewModel.submitRegistration(context)
                                Toast.makeText(context, "Registration Submitted!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
                        ) {
                            Text("Submit", color = Color.White)
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
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
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }

            StepIndicator(currentStep = currentStep, totalSteps = totalSteps)

            Box(modifier = Modifier.weight(1f)) {
                when (currentStep) {
                    1 -> ProfileForm(viewModel = viewModel)
                    2 -> VisitForm(viewModel = viewModel)
                    3 -> ConfirmatonForm(viewModel = viewModel)
                }
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
                    .background(if (isActive) Color(0xFF406AAF) else Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = i.toString(),
                    color = if (isActive) Color.White else Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )
            }

            if (i < totalSteps) {
                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(2.dp)
                        .background(if (i < currentStep) Color(0xFF406AAF) else Color(0xFFE0E0E0))
                )
            }
        }
    }
}
