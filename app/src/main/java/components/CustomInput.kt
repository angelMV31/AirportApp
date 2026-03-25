package components

import android.R.attr.textColor
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomInput(
    label: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
    ) {
        BasicText(
            text = label,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 14.sp
            ),
            modifier = Modifier.padding(bottom = 4.dp)
        )

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(color = Color(0xFF000000), fontSize = 16.sp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(size = 8.dp))
                        .border(width = 1.dp, color = Color(0xFF000000), shape = RoundedCornerShape(8.dp))
                        .background(Color(0xFFFFFFFF)),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = TextStyle(color = Color(0xFF000000), fontSize = 16.sp),
                            modifier = Modifier.padding(start = 12.dp)
                        )
                    }

                    Box(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {
                        innerTextField()
                    }
                }
            }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun CustomInputPreview(){
    CustomInput( label = "Nombre", value = "", placeholder = "Escribe el nombre...", onValueChange = {})
}