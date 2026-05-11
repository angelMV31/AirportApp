package com.aerosj.airport.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aerosj.airport.R
import com.aerosj.airport.components.CustomButton
import com.aerosj.airport.components.CustomInput

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(78.dp))

        Text(
            text = "Welcome",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.logo_aerosjw),
            contentDescription = "AeroSJ Logo",
            modifier = Modifier.size(160.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Please enter your details to sign in",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        CustomInput(
            label = "Email",
            value = email,
            placeholder = "example@example.com",
            onValueChange = { email = it },
            leadingIcon = {
                 Icon(Icons.Default.Email, contentDescription = null, tint = Color.Gray)
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        CustomInput(
            label = "Password",
            value = password,
            placeholder = "••••••••",
            onValueChange = { password = it },
            isPassword = true,
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null, tint = Color.Gray)
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            Text(
                text = "Forgot Password?",
                color = Color(0xFF1565C0),
                fontSize = 14.sp,
                modifier = Modifier.clickable { /* TODO: forgot password */ }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        CustomButton(text = "Sign In →") {
            navController.navigate("main")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign up link
        Text(
            text = buildAnnotatedString {
                append("Don't have account? ")
                withStyle(SpanStyle(color = Color(0xFF1565C0), fontWeight = FontWeight.Bold)) {
                    append("Sign Up")
                }
            },
            fontSize = 14.sp,
            modifier = Modifier.clickable { navController.navigate("register") }
        )
    }
}