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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37b.ui.theme.AI37BTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileBody()
            SpotifyProfile()
        }
    }
}

@Preview
@Composable
fun ProfileBody(){
    Scaffold {padding ->
        Column(modifier = Modifier.fillMaxSize()
            .padding(padding).
        background(color = Color.White)) {
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
                        contentColor = Color.White,
                        containerColor = Color.Blue
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


@Composable
fun SpotifyProfile(){
    Scaffold {padding->
        Column(modifier = Modifier.fillMaxSize()
            .background(color = Color.Black)
        ) {
            Row() {
                Row(
                    modifier = Modifier.weight(2f)
                        .padding(top = 40.dp, start = 30.dp)
                ) {
                    Text(
                        "Recently played",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier.weight(1f)
                            .padding(start = 4.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(
                            16.dp,
                            Alignment.End
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_notifications_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Icon(
                            painter = painterResource(R.drawable.outline_refresh_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Icon(
                            painter = painterResource(R.drawable.outline_settings_24),
                            contentDescription = null,
                            tint = Color.White
                        )

                    }
                }
            }
            Row(modifier = Modifier.padding(top = 20.dp)
                .fillMaxWidth()) {
                Column(modifier = Modifier.padding(start = 30.dp)) {
                    Image(
                        painter = painterResource(R.drawable.lana),
                        contentDescription = null,
                        modifier = Modifier.size(90.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text("Lana Del Rey",
                        modifier = Modifier.padding(start = 20.dp, top = 6.dp),
                        color = Color.White)
                }

                Column(modifier = Modifier.padding(start = 30.dp)) {
                    Image(
                        painter = painterResource(R.drawable.marvin),
                        contentDescription = null,
                        modifier = Modifier.size(90.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text("Marvin Gaye",
                        modifier = Modifier.padding(start = 20.dp, top = 6.dp),
                        color = Color.White)
                }


            }

            Row(modifier = Modifier.padding(top = 20.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.daily),
                    contentDescription = null,
                    modifier = Modifier.size(90.dp)
                        .padding(start = 30.dp)

                )

                Column(modifier = Modifier.padding(start = 20.dp)) {
                    Text("#SPOTIFYWRAPPED",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light)
                    Text("Your 2021 in review",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold)
                }
            }

            Row(modifier = Modifier.padding(top = 20.dp)
                .fillMaxWidth()) {
                Column(modifier = Modifier.padding(start = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.daily),
                        contentDescription = null,
                        modifier = Modifier.size(130.dp)
                            .fillMaxSize()

                    )
                    Text("Your Top Songs 2021",
                        modifier = Modifier.padding(start = 2.dp, top = 6.dp),
                        color = Color.White)
                }

                Column(modifier = Modifier.padding(start = 30.dp)) {
                    Image(
                        painter = painterResource(R.drawable.daily),
                        contentDescription = null,
                        modifier = Modifier.size(130.dp)

                    )
                    Text("Your Artists Revealed",
                        modifier = Modifier.padding(start = 2.dp, top = 6.dp),
                        color = Color.White)
                }


            }

            Row(modifier = Modifier.padding(start = 30.dp, top = 20.dp)
                .fillMaxWidth()) {
                Text("Editor's picks",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(modifier = Modifier.padding(top = 20.dp)
                .fillMaxWidth()) {
                Column(modifier = Modifier.padding(start = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.najeek),
                        contentDescription = null,
                        modifier = Modifier.size(130.dp)
                            .align (Alignment.Start)
                            .fillMaxSize()

                    )
                    Text("Bartika Em Rai,",
                        modifier = Modifier.padding(start = 2.dp, top = 6.dp)
                            .align (Alignment.Start ),
                        color = Color.White,
                       )

                    Text("Tribal Rain, Billie Eilish ",
                        modifier = Modifier.padding(start = 2.dp, top = 6.dp)
                            ,
                        color = Color.White)
                }

                Column(modifier = Modifier.padding(start = 30.dp)) {
                    Image(
                        painter = painterResource(R.drawable.ranga),
                        contentDescription = null,
                        modifier = Modifier.size(130.dp)
                            .align (Alignment.Start)

                    )
                    Text("Ranga,",
                        modifier = Modifier.padding(start = 2.dp, top = 6.dp),
                        color = Color.White)

                    Text("Sajan raj vaidya, Taral",
                        modifier = Modifier.padding(start = 2.dp, top = 6.dp),
                        color = Color.White)
                }


            }

        }
    }
}


@Preview
@Composable
fun PreviewProfile(){
    ProfileBody()
    SpotifyProfile()
}