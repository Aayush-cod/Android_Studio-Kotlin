package com.example.ai37b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37b.ui.theme.AI37BTheme
import com.example.ai37b.ui.theme.Green

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                DashboardCards()
        }
    }
}

@Composable

fun DashboardCards() {

    Scaffold() { padding ->
        Column(
            modifier = Modifier.padding(padding)
                .fillMaxSize()
                .background(color = Green)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 40.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.padding(top = 20.dp)) {
                    Text(
                        "Card",
                        modifier = Modifier,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 30.sp
                    )
                    Text(
                        "Simple and easy to use app",
                        modifier = Modifier,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                }

                Image(
                    painter = painterResource(R.drawable.luffy),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop

                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Column(
                modifier = Modifier.padding(horizontal = 15.dp)
            ) {

                Row(modifier = Modifier
                    .fillMaxWidth()) {
                        CardDashboard(
                            Modifier.height(180.dp)
                                .weight(1f)
                                ,
                            R.drawable.najeek,
                            label = "Text"

                        )

                    Spacer(modifier = Modifier.width(20.dp))

                    CardDashboard(
                        Modifier.height(180.dp)
                            .weight(1f),
                        R.drawable.google,
                        label = "Google"

                    )
                }

                Row(modifier = Modifier.padding(vertical = 10.dp)
                    .fillMaxWidth()) {
                    CardDashboard(
                        Modifier.height(180.dp)
                            .weight(1f)
                        ,
                        R.drawable.facebook,
                        label = "Facebook"

                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    CardDashboard(
                        Modifier.height(180.dp)
                            .weight(1f),
                        R.drawable.ranga,
                        label = "Ranga"

                    )
                }

                Row(modifier = Modifier
                    .fillMaxWidth()) {
                    CardDashboard(
                        Modifier.height(180.dp)
                            .weight(1f)
                        ,
                        R.drawable.daily,
                        label = "Daily"

                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    CardDashboard(
                        Modifier.height(180.dp)
                            .weight(1f),
                        R.drawable.marvin,
                        label = "Marvin"

                    )
                }


            }

            Card(modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
                .height(100.dp).fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )) {

                Row(modifier = Modifier.fillMaxWidth()
                    .fillMaxSize().
                    padding(start = 20.dp),
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
                        Text("Settings",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp)
                        Text("wjanajbcjieccjjcwdikn",
                            fontWeight = FontWeight.Light
                        )
                    }
                }
            }

            Card(modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
                .height(100.dp).fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )) {

                Row(modifier = Modifier.fillMaxWidth()
                    .fillMaxSize().
                    padding(start = 20.dp),
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
                        Text("Settings",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp)
                        Text("wjanajbcjieccjjcwdikn",
                            fontWeight = FontWeight.Light
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun CardDashboard(modifier : Modifier,images : Int,label : String){
    Card(modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )) {

        Column(modifier = Modifier.padding(vertical = 10.dp).fillMaxSize()
        , verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(images),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                label,
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 20.sp
            )
            Text("anjnjnakwl",
                fontWeight = FontWeight.Light)
        }
    }
}


@Preview
@Composable
fun DahboardPreview(){
    DashboardCards()
}