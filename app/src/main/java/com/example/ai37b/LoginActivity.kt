package com.example.ai37b

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ai37b.repository.UserRepoImpl


import com.example.ai37b.ui.theme.PurpleGrey80
import com.example.ai37b.viewmodel.UserViewModel


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                LoginBody()
        }
    }
}

@Composable
fun LoginBody( ){

    val userViewModel = remember { UserViewModel(UserRepoImpl()) }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }

    var isLoading by remember { mutableStateOf(false    ) }

    val context = LocalContext.current
    val activity = context as Activity


    val sharedPreferences = context.getSharedPreferences("User",
        Context.MODE_PRIVATE)

    val localEmail : String? = sharedPreferences.getString("email","")
    val localPassword : String? = sharedPreferences.getString("password","")




    Scaffold {
                padding ->
        Column(modifier = Modifier.fillMaxSize()
            .padding(padding)) {

            Spacer(modifier = Modifier.height(50.dp))

            Text("Sign In",
                modifier = Modifier.fillMaxWidth(),
                color = Color.Blue
                , fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
                )

            Text("This is a aplication to login and" +
                    " explore facebook with friends and family and to chat with them",
                color = Color.Black.copy(0.5f),
                modifier = Modifier.fillMaxWidth().fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 20.dp),
                textAlign = TextAlign.Center)

            Row(modifier = Modifier.
            fillMaxWidth().
            padding(horizontal = 15.dp)) {

                CardCopy(
                    Modifier.
                    height(60.dp  ).
                    weight(1f),
                    R.drawable.facebook,
                    "Facebook"
                )
                Spacer(modifier = Modifier.width(20.dp))

                CardCopy(
                    Modifier.
                    height(60.dp)
                        .weight(1f),
                    R.drawable.google,
                    "Google"
                )


            }
            Row(modifier = Modifier.
            padding(horizontal = 15.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {


                HorizontalDivider(modifier = Modifier.weight(0.25f))
                Text("Or", modifier = Modifier.padding(horizontal = 8.dp))
                HorizontalDivider(modifier = Modifier.weight(0.25f))
            }

            OutlinedTextField(
                value = email,
                onValueChange = { data ->
                    email = data
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text("abc@gmail.com")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = PurpleGrey80,
                    unfocusedContainerColor = PurpleGrey80,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Transparent
                )

            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { data ->
                    password = data
                },
                trailingIcon = {
                    IconButton(onClick = {
                        visibility = !visibility
                    }) {
                        Icon(
                            painter = if (visibility)
                                painterResource(R.drawable.outline_visibility_off_24)
                            else
                                painterResource(R.drawable.baseline_visibility_24),
                            contentDescription = null
                        )
                    }
                },
                visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text("*********")
                },

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = PurpleGrey80,
                    unfocusedContainerColor = PurpleGrey80,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Transparent
                )

            )

            Text(
                "Forget Password",
                style = TextStyle(
                    color = Color.Blue,
                    textAlign = TextAlign.End
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 15.dp)
                    .clickable{
                        val intent = Intent(context, ForgotPasswordActivity::class.java)

                        context.startActivity(intent)
                    }
            )

            Button(
                onClick = {

                    userViewModel.login(email, password ){
                        success, message ->

                            if (success){

                                Toast.makeText(context, message, Toast.LENGTH_SHORT)
                                    .show()

                                val intent = Intent(context, DashboardTwoActivity::class.java)

                                context.startActivity(intent)

                                activity.finish()


                            }else{
                                Toast.makeText(context, message, Toast.LENGTH_SHORT)
                                    .show()
                            }

                    }



                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .height(60.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 15.dp
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Log In")
            }

            Text(buildAnnotatedString {
                append("Don't have an account? ")

                withStyle(SpanStyle(color = Color.Blue)){
                    append("Sign up")
                }
            }, modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
                .clickable{
                    val intent = Intent(
                        context, RegistrationActivity::class.java
                    )
                    context.startActivity(intent)
                })

        }
    }
}

@Composable
fun CardCopy(modifier: Modifier,image : Int ,label : String ){
    Card(modifier = modifier

    ) {
        Row(modifier = Modifier.fillMaxSize()
            , verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(label  )
        }
    }

}
@Preview
@Composable
fun PreviewLogin(){
    LoginBody()
}