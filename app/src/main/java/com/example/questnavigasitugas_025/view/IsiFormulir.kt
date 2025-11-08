package com.example.questnavigasitugas_025.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


private val NeonBlue   = Color(0xFF4F46E5)
private val NeonPurple = Color(0xFF7C3AED)

@Composable
fun Formulir(navController: NavController) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }

    val JK_Option = listOf("Laki-laki", "Perempuan")
    var selectedJK by remember { mutableStateOf(JK_Option[0]) }

    val SP_Option = listOf("Menikah", "Belum Menikah", "Duda/janda")
    var selectedSP by remember { mutableStateOf(SP_Option[0]) }

    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF020617), Color(0xFF020617))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            Text(
                "Formulir Pendaftaran",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                "Lengkapi data diri dengan benar untuk proses pendataan.",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color(0xFF9CA3AF)
                )
            )
            Spacer(Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF0F172A)
                ),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {

                    Column {
                        Text(
                            "Nama Lengkap",
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = Color(0xFFE5E7EB),
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        OutlinedTextField(
                            value = textNama,
                            onValueChange = { textNama = it },
                            placeholder = { Text("Isikan Nama Lengkap") },
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = LocalTextStyle.current.copy(color = Color.White), // teks putih
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = NeonPurple,
                                unfocusedBorderColor = Color(0xFF374151),
                                cursorColor = NeonPurple
                            )
                        )
                    }

                    Column {
                        Text(
                            "Jenis Kelamin",
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = Color(0xFFE5E7EB),
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        Column(Modifier.selectableGroup()) {
                            JK_Option.forEach { text ->
                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .selectable(
                                            selected = (text == selectedJK),
                                            onClick = { selectedJK = text },
                                            role = Role.RadioButton
                                        )
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = (text == selectedJK),
                                        onClick = null,
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = NeonPurple
                                        )
                                    )
                                    Text(
                                        text = text,
                                        modifier = Modifier.padding(start = 8.dp),
                                        color = Color(0xFFE5E7EB)
                                    )
                                }
                            }
                        }
                    }
                    Column {
                        Text(
                            "Status Perkawinan",
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = Color(0xFFE5E7EB),
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        Column(Modifier.selectableGroup()) {
                            SP_Option.forEach { text ->
                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .selectable(
                                            selected = (text == selectedSP),
                                            onClick = { selectedSP = text },
                                            role = Role.RadioButton
                                        )
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = (text == selectedSP),
                                        onClick = null,
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = NeonBlue
                                        )
                                    )
                                    Text(
                                        text = text,
                                        modifier = Modifier.padding(start = 8.dp),
                                        color = Color(0xFFE5E7EB)
                                    )
                                }
                            }
                        }
                    }
                    Column {
                        Text(
                            "Alamat",
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = Color(0xFFE5E7EB),
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        OutlinedTextField(
                            value = textAlamat,
                            onValueChange = { textAlamat = it },
                            placeholder = { Text("Isikan Alamat") },
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = LocalTextStyle.current.copy(color = Color.White), // teks putih
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = NeonBlue,
                                unfocusedBorderColor = Color(0xFF374151),
                                cursorColor = NeonBlue
                            )
                        )
                    }
                }
            }
            Spacer(Modifier.height(100.dp)) // ruang untuk tombol bawah
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate("Home") },
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, NeonBlue),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = NeonBlue
                )
            ) {
                Text("Beranda")
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = { showDialog = true },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = NeonPurple
                )
            ) {
                Text("Submit")
            }
        }
    }

    
}