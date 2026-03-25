package components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButtom (text:String, onClick: ()-> Unit){
    Box(
        modifier = Modifier
            .fillMaxWidth() // Botón de ancho completo como en el diseño
            .height(55.dp)   // Una altura estándar
            .clip(RoundedCornerShape(12.dp)) // Esquinas redondeadas
            .background(Color(0xFF000000)) // Fondo Negro Sólido
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ){
        BasicText(
            text = text,
            style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview(){
    CustomButton(text = "Boton customizado", onClick = {})
}

@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    TODO("Not yet implemented")
}