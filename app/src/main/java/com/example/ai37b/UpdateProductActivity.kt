package com.example.ai37b

import android.app.Activity
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.ai37b.model.ProductModel
import com.example.ai37b.repository.ProductRepoImpl
import com.example.ai37b.ui.theme.AI37BTheme
import com.example.ai37b.ui.theme.PurpleGrey80
import com.example.ai37b.viewmodel.ProductViewModel

class UpdateProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            updateProductBody()

        }
    }
}


@Composable
fun updateProductBody() {
    Scaffold() { padding ->

        val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }

        var email by remember { mutableStateOf("") }
        var isLoading by remember { mutableStateOf(false) }


        val context = LocalContext.current
        val activity = context as Activity

        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        var selectedDate by remember { mutableStateOf("") }
        val datepicker = DatePickerDialog(
            context, { _, year, month, day ->
                selectedDate = "$year/${month + 1}/$day"

            }, year, month, day
        )

        LazyColumn(
            modifier = Modifier.padding(padding)
                .fillMaxSize()
        ) {

            item {

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
                    enabled = false,
                    value = selectedDate,
                    onValueChange = { data ->
                        selectedDate = data
                    },
                    modifier = Modifier
                        .fillMaxWidth().clickable {
                            datepicker.show()
                        }
                        .padding(horizontal = 15.dp),
                    shape = RoundedCornerShape(15.dp),
                    placeholder = {
                        Text("dd/mm/yyyy")
                    },

                    colors = TextFieldDefaults.colors(
                        disabledIndicatorColor = Color.Transparent,
                        disabledContainerColor = PurpleGrey80,
                        focusedContainerColor = PurpleGrey80,
                        unfocusedContainerColor = PurpleGrey80,
                        focusedIndicatorColor = Color.Blue,
                        unfocusedIndicatorColor = Color.Transparent
                    )

                )

                Button(onClick = {

                    var model = ProductModel(
                        "",
                        productName = email,
                        dom = selectedDate
                    )
                    productViewModel.addProductToDatabase(model){
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
                    enabled = !isLoading,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .height(60.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 15.dp
                    ),
                    shape = RoundedCornerShape(10.dp)) {
                    Text("Add Product")
                }
            }

        }
    }
}