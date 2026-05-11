package com.aerosj.airport.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aerosj.airport.components.CustomButton
import com.aerosj.airport.components.CustomInput

@Composable
fun RegisterScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var acceptedTerms by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.height(78.dp))

        Text(
            text = "Create Account",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        CustomInput(
            label = "Name",
            value = name,
            placeholder = "Angel",
            onValueChange = { name = it },
            leadingIcon = {
                Icons.Default.Person
            }
        )

        CustomInput(
            label = "Last Name",
            value = lastName,
            placeholder = "Mendoza",
            onValueChange = { lastName = it },
            leadingIcon = {
                Icons.Default.Person
            }
        )

        CustomInput(
            label = "Email Address",
            value = email,
            placeholder = "example@example.com",
            onValueChange = { email = it },
            leadingIcon = {
                Icons.Default.Email
            }
        )

        CustomInput(
            label = "Password",
            value = password,
            placeholder = "••••••••",
            onValueChange = { password = it },
            isPassword = true,
            leadingIcon = {
                Icons.Default.Lock
            }
        )

        CustomInput(
            label = "Confirm Password",
            value = confirmPassword,
            placeholder = "••••••••",
            onValueChange = { confirmPassword = it },
            isPassword = true,
            leadingIcon = {
                Icons.Default.Lock
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Terms & conditions
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = acceptedTerms,
                onCheckedChange = { acceptedTerms = it }
            )
            Text(
                text = buildAnnotatedString {
                    append("I agree to the ")
                    withStyle(SpanStyle(color = Color(0xFF1565C0), fontWeight = FontWeight.Bold)) {
                        append("Terms of Service")
                    }
                    append(" and ")
                    withStyle(SpanStyle(color = Color(0xFF1565C0), fontWeight = FontWeight.Bold)) {
                        append("Privacy Policy")
                    }
                    append(".")
                },
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        CustomButton(text = "Create Account") {
            if (acceptedTerms) {
                navController.navigate("login")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}