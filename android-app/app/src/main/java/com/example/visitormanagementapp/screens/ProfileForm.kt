package com.example.visitormanagementapp.screens

import android.Manifest
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import coil.compose.AsyncImage
import com.example.visitormanagementapp.viewmodel.RegisterViewModel
import java.io.File
import kotlin.contracts.contract

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileForm(
    viewModel: RegisterViewModel
) {
    val identityOpt = viewModel.identityType
    val nationalityOpt = viewModel.nationalityType

    var expandedIdentity by remember { mutableStateOf(false) }
    var expandedNationality by remember { mutableStateOf(false) }

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current

    //camera dan galeri
    val getImageUri = remember {
        val file = File.createTempFile("photo_", ".jpg", context.cacheDir)
        FileProvider.getUriForFile(
            context,
            "${context.packageName}.provider",
            file
        )
    }
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ){ success ->
        if (success) {
            imageUri = getImageUri
            viewModel.pictureUri
        }
    }
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        uri?.let {
            imageUri = it
            viewModel.pictureUri = it
        }
    }
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            cameraLauncher.launch(getImageUri)
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getIdentityType()
        viewModel.getNationality()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = viewModel.name,
            onValueChange = { viewModel.name = it },
            label = { Text("Name", fontSize = 12.sp, color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF6200EE),
                unfocusedBorderColor = Color(0xFF831C91)
            ),
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = viewModel.phoneNumber,
                onValueChange = { if (it.all { char -> char.isDigit() }) viewModel.phoneNumber = it },
                label = { Text("Whatsapp", fontSize = 12.sp, color = Color.Black) },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF6200EE),
                    unfocusedBorderColor = Color(0xFF831C91)
                ),
            )

            OutlinedTextField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                label = { Text("Email", fontSize = 12.sp, color = Color.Black) },
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF6200EE),
                    unfocusedBorderColor = Color(0xFF831C91)
                ),
            )
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ExposedDropdownMenuBox(
                expanded = expandedIdentity,
                onExpandedChange = { expandedIdentity = !expandedIdentity },
                modifier = Modifier.weight(1f)
            ) {
                OutlinedTextField(
                    value = viewModel.identityTypeName,
                    onValueChange = {},
                    label = { Text("ID Type", fontSize = 12.sp, color = Color.Black) },
                    readOnly = true,
                    trailingIcon = { 
                        if (viewModel.isLoading) {
                            CircularProgressIndicator(modifier = Modifier.padding(12.dp), strokeWidth = 2.dp)
                        } else {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedIdentity) 
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
                    expanded = expandedIdentity,
                    onDismissRequest = { expandedIdentity = false }
                ) {
                    if (identityOpt.isEmpty() && !viewModel.isLoading) {
                        DropdownMenuItem(
                            text = { Text("No data found") },
                            onClick = { expandedIdentity = false }
                        )
                    } else {
                        identityOpt.forEach { type ->
                            DropdownMenuItem(
                                text = { Text(type.name) },
                                onClick = {
                                    viewModel.identityTypeName = type.name
                                    viewModel.selectedIdentityId = type.id
                                    expandedIdentity = false
                                }
                            )
                        }
                    }
                }
            }

            OutlinedTextField(
                value = viewModel.identityNumber,
                onValueChange = { viewModel.identityNumber = it },
                label = { Text("ID Number", fontSize = 12.sp, color = Color.Black) },
                modifier = Modifier.weight(1f),
                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF6200EE),
                    unfocusedBorderColor = Color(0xFF831C91)
                )
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ExposedDropdownMenuBox(
                expanded = expandedNationality,
                onExpandedChange = { expandedNationality = !expandedNationality },
                modifier = Modifier.weight(1f)
            ) {
                OutlinedTextField(
                    value = viewModel.nationalityText,
                    onValueChange = {},
                    label = { Text("Nationality", fontSize = 12.sp, color = Color.Black) },
                    readOnly = true,
                    trailingIcon = { 
                        if (viewModel.isLoading) {
                            CircularProgressIndicator(modifier = Modifier.padding(12.dp), strokeWidth = 2.dp)
                        } else {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedNationality) 
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
                    expanded = expandedNationality,
                    onDismissRequest = { expandedNationality = false }
                ) {
                    if (nationalityOpt.isEmpty() && !viewModel.isLoading) {
                        DropdownMenuItem(
                            text = { Text("No data found") },
                            onClick = { expandedNationality = false }
                        )
                    } else {
                        nationalityOpt.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(option.name) },
                                onClick = {
                                    viewModel.nationalityText = option.name
                                    viewModel.selectedNationalityId = option.id
                                    expandedNationality = false
                                }
                            )
                        }
                    }
                }
            }

            OutlinedTextField(
                value = viewModel.company,
                onValueChange = { viewModel.company = it },
                label = { Text("Company", fontSize = 12.sp, color = Color.Black) },
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF6200EE),
                    unfocusedBorderColor = Color(0xFF831C91)
                )
            )
        }

        //Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Upload Picture",
                fontSize = 14.sp,
                color = Color.Black
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Box (
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(8.dp)
                        ),
//                    .clickable {
//                        permissionLauncher.launch(Manifest.permission.CAMERA)
//                    },
                    contentAlignment = Alignment.Center
                )
                {
                    if (imageUri != null) {
                        AsyncImage(
                            model = imageUri,
                            contentDescription = "image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "person",
                                tint = Color.Black
                            )
                            Text(
                                text = "Upload",
                                fontSize = 11.sp,
                                color = Color.Black
                            )
                        }
                    }
//                imageUri?.let {
//                    AsyncImage(model = it, contentDescription = null)
//                }
                }

                Column(
                    modifier = Modifier.weight(2f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedButton(
                        onClick = {
                            permissionLauncher.launch(Manifest.permission.CAMERA)
                        },
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color(0xFF6200EE),
                            contentColor = Color.White
                        )
                        //border = BorderStroke(1.dp, Color(0xFF6200EE)),
                    ) {

                        Text(text = "Camera")
                    }
                    OutlinedButton(
                        onClick = {
                            galleryLauncher.launch(
                                PickVisualMediaRequest(
                                    ActivityResultContracts.PickVisualMedia.ImageOnly
                                )
                            )
                        },
                        modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                        border = BorderStroke(1.dp, Color(0xFF6200EE)),
                    ) {

                        Text(text = "Gallery", color = Color.Black)
                    }
                }

            }


        }


//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(12.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            Column (
//                verticalArrangement = Arrangement.spacedBy(4.dp)
//            ) {
//                OutlinedButton(
//                    onClick = {
//                        permissionLauncher.launch(Manifest.permission.CAMERA)
//                    },
//                    modifier = Modifier.fillMaxWidth(),
//                    border = BorderStroke(1.dp, Color(0xFF6200EE)),
//                ) {
//
//                    Text(text = "Camera", color = Color.White)
//                }
//
//            }





    }
}
