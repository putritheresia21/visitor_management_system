package com.example.visitormanagementapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitormanagementapp.viewmodel.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisitForm(
    viewModel: RegisterViewModel
) {
    var expandedDepartement by remember { mutableStateOf(false) }
    var expandedEmployee by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (viewModel.departementList.isEmpty()) {
            viewModel.getDepartements()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = viewModel.visitPurpose,
            onValueChange = { viewModel.visitPurpose = it },
            label = { Text("Visit Purpose", fontSize = 12.sp, color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF6200EE),
                unfocusedBorderColor = Color(0xFF831C91)
            )
        )

        Text(
            text = "Visit to:",
            fontSize = 14.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )


        ExposedDropdownMenuBox(
            expanded = expandedDepartement,
            onExpandedChange = { expandedDepartement = !expandedDepartement }
        ) {
            OutlinedTextField(
                value = viewModel.departementText,
                onValueChange = {},
                label = { Text("Department", fontSize = 12.sp, color = Color.Black) },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDepartement)
                },
                modifier = Modifier
                    .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                    .fillMaxWidth(),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF6200EE),
                    unfocusedBorderColor = Color(0xFF831C91)
                )
            )

            ExposedDropdownMenu(
                expanded = expandedDepartement,
                onDismissRequest = { expandedDepartement = false }
            ) {
                if (viewModel.departementList.isEmpty() && !viewModel.isLoading) {
                    DropdownMenuItem(
                        text = { Text("No departements available") },
                        onClick = { expandedDepartement = false }
                    )
                } else {
                    viewModel.departementList.forEach { dept ->
                        DropdownMenuItem(
                            text = { Text(dept.departementName) },
                            onClick = {
                                viewModel.departementText = dept.departementName
                                viewModel.selectedDepartementId = dept.id
                                viewModel.employeeText = "" 
                                viewModel.employeeNumber = ""
                                viewModel.selectedEmployeeId = null
                                expandedDepartement = false
                                viewModel.getEmployeesByDepartmentId(dept.id)
                            }
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ExposedDropdownMenuBox(
                expanded = expandedEmployee,
                onExpandedChange = { 
                    if (viewModel.selectedDepartementId != null) {
                        expandedEmployee = !expandedEmployee 
                    }
                },
                modifier = Modifier.weight(0.6f)
            ) {
                OutlinedTextField(
                    value = viewModel.employeeText,
                    onValueChange = {},
                    label = { Text("Employee", fontSize = 12.sp, color = Color.Black) },
                    readOnly = true,
                    enabled = viewModel.selectedDepartementId != null,
                    trailingIcon = {
                        if (viewModel.isLoading) {
                            CircularProgressIndicator(modifier = Modifier.padding(12.dp), strokeWidth = 2.dp)
                        } else {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedEmployee)
                        }
                    },
                    modifier = Modifier
                        .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                        .fillMaxWidth(),
                    textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF6200EE),
                        unfocusedBorderColor = Color(0xFF831C91)
                    )
                )

                ExposedDropdownMenu(
                    expanded = expandedEmployee,
                    onDismissRequest = { expandedEmployee = false }
                ) {
                    if (viewModel.employeeList.isEmpty() && !viewModel.isLoading) {
                        DropdownMenuItem(
                            text = { Text("No employees found") },
                            onClick = { expandedEmployee = false }
                        )
                    } else {
                        viewModel.employeeList.forEach { employee ->
                            DropdownMenuItem(
                                text = { Text(employee.name ?: "Unknown") },
                                onClick = {
                                    viewModel.employeeText = employee.name ?: ""
                                    viewModel.employeeNumber = employee.numberEmployee ?: ""
                                    viewModel.selectedEmployeeId = employee.id
                                    expandedEmployee = false
                                }
                            )
                        }
                    }
                }
            }


            OutlinedTextField(
                value = viewModel.employeeNumber,
                onValueChange = { viewModel.onEmployeeNumberChange(it) },
                label = { Text("Code", fontSize = 12.sp, color = Color.Black) },
                modifier = Modifier.weight(0.4f),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF6200EE),
                    unfocusedBorderColor = Color(0xFF831C91)
                )
            )
        }

        OutlinedTextField(
            value = viewModel.employeePhone,
            onValueChange = { viewModel.onEmployeeNumberChange(it)},
            label = { Text("Whatsapp Employee", fontSize = 12.sp, color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF6200EE),
                unfocusedBorderColor = Color(0xFF831C91)
            )
        )

    }
}
