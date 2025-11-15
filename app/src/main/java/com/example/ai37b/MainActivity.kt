package com.example.ai37b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37b.ui.theme.AI37BTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                  MainBody()
        }
    }
}

@Composable
fun MainBody(){
  Scaffold() { padding->
      Column(
          modifier = Modifier.fillMaxSize()
              .padding(padding)
              .background(color = Color.Gray),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.SpaceAround

      ) {
          Text("Hello", modifier = Modifier.background(color = Color.Red),
              style = TextStyle(
              fontSize = 25.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White,
              textDecoration = TextDecoration.Underline,
              fontStyle = FontStyle.Italic
          ))
          Text("Android", modifier = Modifier.background(color = Color.White),
              style = TextStyle(
                  fontSize = 25.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.DarkGray,
                  textDecoration = TextDecoration.Underline,
                  fontStyle = FontStyle.Italic
              ))
          Text("Hello world", style = TextStyle(
              fontSize = 25.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White,
              textDecoration = TextDecoration.Underline,
              fontStyle = FontStyle.Italic

          ))
      }
  }


}

@Preview
@Composable
fun MainPreview(){
    MainBody()
}