package com.aerosj.airport.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aerosj.airport.R
import com.aerosj.airport.components.CustomButton
import com.aerosj.airport.components.CustomButtonWhite


@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF000000))
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_aerosjb),
            contentDescription = "AeroSJ Logo Black",
            modifier = Modifier
                .size(220.dp)
                .padding(bottom = 60.dp)
        )

        CustomButtonWhite(text = "Sign In →") {
            navController.navigate("login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        CustomButton(text = "Sign Up →") {
            navController.navigate("register")
        }
    }
}