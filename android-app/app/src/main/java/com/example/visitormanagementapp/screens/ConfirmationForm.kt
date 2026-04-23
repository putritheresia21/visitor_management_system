package com.example.visitormanagementapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.visitormanagementapp.viewmodel.RegisterViewModel

@Composable
fun ConfirmatonForm(
    viewModel: RegisterViewModel,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Please Check your data before submit",
            fontSize =  16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFF6200EE)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ){
            Text(
                text = "Visistor Profile",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                fontSize = 14.sp,
                modifier = Modifier.padding(16.dp)
            )

            Box(
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(8.dp)).background(Color.White).align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center
            ){
                if (viewModel.pictureUri != null){
                    AsyncImage(
                        model = viewModel.pictureUri,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                } else{
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(50.dp),
                        tint = Color.Gray
                    )
                }
            }

            ConfirmationItem("Name", viewModel.name)
            ConfirmationItem("Email", viewModel.email)
            ConfirmationItem("Whatsapp", viewModel.phoneNumber)
            ConfirmationItem("Identity Type", viewModel.identityTypeName)
            ConfirmationItem("Identity Number", viewModel.identityNumber)
            ConfirmationItem("Nationality", viewModel.nationalityText)
            ConfirmationItem("Company", viewModel.company)

        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFF6200EE)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ){
            Text(
                text = "Visit Details",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                fontSize = 14.sp,
                modifier = Modifier.padding(16.dp)
            )

            ConfirmationItem("Purpose", viewModel.visitPurpose)
            ConfirmationItem("Visit to", viewModel.employeeText)
            ConfirmationItem("Employee Whatsapp", viewModel.employeePhone)
            ConfirmationItem("Department", viewModel.departementText)
            ConfirmationItem("Area Visit", viewModel.areaVisitText)

        }
    }
}

@Composable
fun ConfirmationItem(label: String, value: String){
    Row(
        modifier = Modifier.fillMaxWidth().padding(6.dp),
    ) {
        Text(
            text = label,
            modifier = Modifier.width(130.dp).padding(2.dp),
            color = Color.Gray,
            fontSize = 12.sp,
        )
        Text (
            text = ": $value",
            fontSize = 12.sp,
            color = Color.Black
        )
    }
    HorizontalDivider(color = Color(0xFFEEEEEE))

}
