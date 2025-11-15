package com.example.ai37b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai37b.ui.theme.AI37BTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileBody()
        }
    }
}


@Composable
fun ProfileBody(){
    Scaffold {padding ->
        Column(modifier = Modifier.fillMaxSize()
            .padding(padding)) {
            Row(modifier = Modifier
                .padding(start = 12.dp, end = 8.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
                ) {
                Icon(
                    painter = painterResource(R.drawable.outline_arrow_back_ios_24),
                    contentDescription = null,

                )


                Text("Aayush123",
                    )
                Icon(
                    painter = painterResource(R.drawable.baseline_more_horiz_24),
                    contentDescription = null,
                    modifier = Modifier
                )
            }
            Row(modifier = Modifier.fillMaxWidth()
                .padding(top = 10.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround) {
                Box(
                    modifier = Modifier
                        .size(100.dp) // Outer circle size
                        .border(
                            width = 3.dp,
                            color = Color(0xFFE1306C), // highlight color
                            shape = CircleShape
                        )
                        .padding(4.dp) // space between border and image
                ) {
                    Image(
                        painter = painterResource(R.drawable.luffy),
                        contentDescription = null,
                        modifier = Modifier.size(90.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }

                Column() {
                    Text("329")
                    Text("Posts")
                }
                Column() {
                    Text("2M")
                    Text("Followers")
                }
                Column() {
                    Text("5")
                    Text("Following")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier
            .fillMaxWidth().
            padding(start = 20.dp)
                ) {
                Text("Bio mine")
                Text("Follow me")
                Text("Followed by ishan g and b")
            }

            Button(onClick = {

            },
                modifier = Modifier.fillMaxWidth().padding(start = 18.dp, end = 8.dp)
                   ,
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(2.dp, color = Color.LightGray),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color.White
                )

            ) {
                Text("Button")
            }

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {

                Button(onClick = {

                },
                    modifier = Modifier.padding(start = 18.dp)
                    ,
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(2.dp, color = Color.LightGray),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    )

                ) {
                    Text("Follow")
                }

                Button(onClick = {

                },
                    modifier = Modifier
                    ,
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(2.dp, color = Color.LightGray),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    )

                ) {
                    Text("Message")
                }

                Button(onClick = {

                },
                    modifier = Modifier
                    ,
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(2.dp, color = Color.LightGray),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    )

                ) {
                    Text("Email")
                }
                Box(modifier = Modifier.padding(5.dp).background(color = Color.White,)
                    .size(40.dp)
                    .border(BorderStroke(2.dp, color = Color.LightGray,
                        ),
                        shape = RoundedCornerShape(6.dp)
                    ).fillMaxWidth(),
                    contentAlignment = Alignment.Center,

                ){
                    Icon(
                        painter = painterResource(R.drawable.baseline_keyboard_arrow_down_24),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()

                    )
                }
            }
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly) {
                Column( horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier .padding(start = 8.dp)) {
                    Box(
                        modifier = Modifier
                            .size(70.dp) // Outer circle size
                            .border(
                                width = 3.dp,
                                color = Color.LightGray, // highlight color
                                shape = CircleShape
                            )
                            .padding(4.dp) // space between border and image
                    ) {
                        Image(
                            painter = painterResource(R.drawable.luffy),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                                .clip(shape = CircleShape), contentScale = ContentScale.Crop

                        )
                    }
                    Text("Story 1")
                }

                Column() {
                    Box(
                        modifier = Modifier
                            .size(70.dp) // Outer circle size
                            .border(
                                width = 3.dp,
                                color = Color.LightGray, // highlight color
                                shape = CircleShape
                            )
                            .padding(4.dp) // space between border and image
                    ) {
                        Image(
                            painter = painterResource(R.drawable.luffy),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                                .clip(shape = CircleShape), contentScale = ContentScale.Crop

                        )
                    }
                    Text("Story 2")
                }

                Column() {
                    Box(
                        modifier = Modifier
                            .size(70.dp) // Outer circle size
                            .border(
                                width = 3.dp,
                                color = Color.LightGray, // highlight color
                                shape = CircleShape
                            )
                            .padding(4.dp) // space between border and image
                    ) {
                        Image(
                            painter = painterResource(R.drawable.luffy),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                                .clip(shape = CircleShape), contentScale = ContentScale.Crop

                        )
                    }
                    Text("Story 3")
                }

                Column() {
                    Box(
                        modifier = Modifier
                            .size(70.dp) // Outer circle size
                            .border(
                                width = 3.dp,
                                color = Color.LightGray, // highlight color
                                shape = CircleShape
                            )
                            .padding(4.dp) // space between border and image
                    ) {
                        Image(
                            painter = painterResource(R.drawable.luffy),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                                .clip(shape = CircleShape), contentScale = ContentScale.Crop

                        )
                    }
                    Text("Story 4")
                }

                Column() {
                    Box(
                        modifier = Modifier
                            .size(70.dp) // Outer circle size
                            .border(
                                width = 3.dp,
                                color = Color.LightGray, // highlight color
                                shape = CircleShape
                            )
                            .padding(4.dp) // space between border and image
                    ) {
                        Image(
                            painter = painterResource(R.drawable.luffy),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                                .clip(shape = CircleShape), contentScale = ContentScale.Crop

                        )
                    }
                    Text("Story 5")
                }
            }

        }
    }
}

@Preview
@Composable
fun PreviewProfile(){
    ProfileBody()
}