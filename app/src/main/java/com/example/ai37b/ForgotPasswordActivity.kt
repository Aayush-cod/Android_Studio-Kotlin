package com.example.ai37b

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai37b.repository.UserRepoImpl
import com.example.ai37b.ui.theme.AI37BTheme
import com.example.ai37b.ui.theme.PurpleGrey80
import com.example.ai37b.viewmodel.UserViewModel

class ForgotPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForgotPassUi()

        }
    }
}


@Composable
fun ForgotPassUi(){

    val userViewModel  = remember { UserViewModel(UserRepoImpl()) }


    var email by remember { mutableStateOf("") }

    val context = LocalContext.current

    val activity = context as Activity

    Scaffold() {
        padding ->
        Column(modifier = Modifier.padding(padding)
            .fillMaxSize()) {

            Row() {
                Text("Email : ")

                OutlinedTextField(
                    value = email,
                    onValueChange = {data ->
                        email = data
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    shape = RoundedCornerShape(15.dp),

                    
                    placeholder = {
                        Text("abc@gmail.com")
                    }
                    ,
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

            }

            Button(
                onClick = {

                    userViewModel.forgetPassword(email){
                        success, message ->
                            if (success){
                                Toast.makeText(context, message, Toast.LENGTH_SHORT)
                                    .show()

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
                Text("Reset")
            }



        }
    }
}

@Preview
@Composable
fun ForgotPassUiPreview(){

    ForgotPassUi()

}