package com.example.ai37b

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.ai37b.ui.theme.AI37BTheme
import com.example.ai37b.ui.theme.Green
import com.example.ai37b.ui.theme.Purpleblue
import com.example.ai37b.ui.theme.blue
import com.example.ai37b.ui.theme.brown
import com.example.ai37b.ui.theme.lightblue
import com.example.ai37b.ui.theme.yellow

class DashboardTwoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                DashboardTwoCard()
        }
    }
}

@Composable
fun DashboardTwoCard(){

    val context = LocalContext.current
    val activity = context as Activity

    val email = activity.intent.getStringExtra("email")
    val password = activity.intent.getStringExtra("password")

    Scaffold() {padding ->
        Column(modifier = Modifier
            .padding(padding))
        {
            Row(modifier = Modifier.fillMaxWidth()
                .background(color = Green)) {
                Row( modifier = Modifier.padding(horizontal = 15.dp, vertical = 40.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        "Card",
                        modifier = Modifier,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 30.sp
                    )
                    Image(
                        painter = painterResource(R.drawable.luffy),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop

                    )
                }
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-40).dp)   // move this box up by 40.dp to overlap the header
                .zIndex(1f  )
                .verticalScroll(rememberScrollState())
            ) {

                Card(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                        .height(120.dp).fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = yellow
                    )
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .fillMaxSize().padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_settings_24),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            tint = Color.LightGray
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Column() {
                            Text(
                                "email : $email ",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(
                                "Password : $password",
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                        .height(100.dp).fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = blue
                    )
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .fillMaxSize().padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_settings_24),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            tint = Color.LightGray
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Column() {
                            Text(
                                "Settings",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(
                                "wjanajbcjieccjjcwdikn",
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                        .height(130.dp).fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Purpleblue
                    )
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .fillMaxSize().padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_settings_24),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            tint = Color.LightGray
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Column() {
                            Text(
                                "Settings",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(
                                "wjanajbcjieccjjcwdikn",
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                        .height(140.dp).fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = brown
                    )
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .fillMaxSize().padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_settings_24),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            tint = Color.LightGray
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Column() {
                            Text(
                                "Settings",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(
                                "wjanajbcjieccjjcwdikn",
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                        .height(100.dp).fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = lightblue
                    )
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .fillMaxSize().padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_settings_24),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            tint = Color.LightGray
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Column() {
                            Text(
                                "Settings",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(
                                "wjanajbcjieccjjcwdikn",
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                        .height(120.dp).fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = yellow
                    )
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .fillMaxSize().padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_settings_24),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            tint = Color.LightGray
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Column() {
                            Text(
                                "Settings",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(
                                "wjanajbcjieccjjcwdikn",
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun DashboardTwoPreivew(){
    DashboardTwoCard()
}