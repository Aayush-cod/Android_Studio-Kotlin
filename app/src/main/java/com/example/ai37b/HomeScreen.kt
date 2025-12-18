package com.example.ai37b


import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37b.model.ProductModel
import com.example.ai37b.repository.ProductRepoImpl
import com.example.ai37b.ui.theme.BgColor
import com.example.ai37b.ui.theme.Blue
import com.example.ai37b.ui.theme.CardBGColor
import com.example.ai37b.ui.theme.White
import com.example.ai37b.viewmodel.ProductViewModel


data class CategoryItem(val name: String, val iconRes: Int)
data class ProductItem(val name: String, val price: String, val oldPrice: String, val imageRes: Int)


@Composable
fun HomeScreen(){

    val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }


    val product = productViewModel.product.observeAsState(initial =null)


    val products = productViewModel.allProducts.observeAsState(initial = emptyList())



    val context = LocalContext.current

    val activity = context as Activity

    var showDialog by remember { mutableStateOf(false) }

    var editDialog by remember { mutableStateOf(false) }

    var name by remember { mutableStateOf("") }

    var dom by remember { mutableStateOf("") }


    LaunchedEffect(product.value) {
        productViewModel.getAllProduct()

//        if (data.value != null){}
        product.value?.let {
                product ->
            name = product.productName
            dom = product.dom
        }
    }





//    var search by remember { mutableStateOf("") }
//
//    val categories = listOf(
//        CategoryItem("Beauty", R.drawable.lana),
//        CategoryItem("Home & Decor", R.drawable.luffy),
//        CategoryItem("Fashion", R.drawable.marvin),
//        CategoryItem("Appliances", R.drawable.daily),
//        CategoryItem("Party items", R.drawable.ranga),
//        CategoryItem("Beauty+", R.drawable.najeek)
//    )
//
//    val flashSale = listOf(
//        ProductItem("Sonic Headphones", "PKR 800", "PKR 1500", R.drawable.luffy),
//        ProductItem("Mini Clock", "PKR 800", "PKR 1300", R.drawable.lana),
//        ProductItem("Wireless Earpods", "PKR 800", "PKR 1500", R.drawable.google)
//    )
//
//    val recommended = listOf(
//        ProductItem("Perfume", "PKR 900", "PKR 1400", R.drawable.luffy),
//        ProductItem("Makeup Kit", "PKR 1200", "PKR 1800", R.drawable.najeek),
//        ProductItem("Gift Box", "PKR 700", "PKR 1100", R.drawable.facebook)
//    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BgColor)
            .padding(15.dp)
    ) {

        items(products.value!!.size){index ->

            val data = products.value!![index]
            Card(

                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 5.dp)
            ) {
                Row() {
                    Column(
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 6.dp)
                    ) {
                        Text(data.productName)
                        Text(data.dom)




                    }


                    Spacer(modifier = Modifier.weight(1f))


                    IconButton(onClick = {
                        editDialog = true
                        productViewModel.getProductById(data.productId)
                    }) {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = null
                        )
                    }





                    IconButton(onClick = {

                        showDialog = true


                    }) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = null
                        )
                    }

                    if (showDialog){
                        AlertDialog(
                            onDismissRequest = {
                                showDialog = false
                            },
                            title =  {Text("Delete product")},
                            text = {Text("Are you sure want to delete product?")},
                            confirmButton = {
                                TextButton(onClick ={
                                showDialog = false

                                    var id = data.productId



                                    productViewModel.deleteProduct(id) { success, message ->
                                        if (success) {

                                            Toast.makeText(context, message, Toast.LENGTH_SHORT)
                                                .show()



                                        } else {
                                            Toast.makeText(context, message, Toast.LENGTH_SHORT)
                                                .show()

                                        }
                                    }}
                                ) {
                                    Text("Delete")
                                }


                            },
                            dismissButton = {
                                TextButton(onClick = {
                                    showDialog = false
                                }) {
                                    Text("Cancel")
                                }
                            }

                        )
                    }


                    if (editDialog){
                        AlertDialog(
                            onDismissRequest = {
                                editDialog = false
                            },
                            title = {
                                Text("Edit Product profile")
                            },
                            text = {
                                Column() {
                                    Text(
                                        "Edit Product: ${data.productName}",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(bottom = 16.dp)
                                    )

                                    OutlinedTextField(
                                        value = name,
                                        onValueChange = { name = it },
                                        label = { Text("Product Name") },
                                        shape = RoundedCornerShape(8.dp),
                                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                                    )

                                    OutlinedTextField(
                                        value = dom,
                                        onValueChange = { dom = it },
                                        label = { Text("Date of Manufacture") },
                                        shape = RoundedCornerShape(8.dp),
                                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                                    )
                                }
                            },
                            confirmButton = {
                                TextButton(onClick = {
                                    editDialog = false

                                    var pmodel = ProductModel(
                                       product.value!!.productId
                                        ,name,
                                        dom
                                    )
                                    productViewModel.editProduct(pmodel){success, message ->
                                        if (success){
                                            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()


                                        }else{
                                            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                }) {
                                    Text("Edit")
                                }
                            },
                            dismissButton = {
                                TextButton(onClick = {
                                    editDialog = false
                                }) {
                                    Text("Cancel")
                                }
                            }

                        )
                    }
                }





            }

        }



//        item {
//            TextField(
//                value = search,
//                onValueChange = { search = it },
//                modifier = Modifier.fillMaxWidth(),
//                placeholder = { Text("Search here") },
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White,
//                    unfocusedContainerColor = Color.White,
//                    focusedIndicatorColor = Color.White,
//                    unfocusedIndicatorColor = Color.White
//                ),
//                leadingIcon = {
//                    Icon(
//                        painter = painterResource(R.drawable.outline_refresh_24),
//                        contentDescription = null
//                    )
//                },
//                shape = RoundedCornerShape(12.dp)
//            )
//
//            Spacer(modifier = Modifier.height(15.dp))
//
//            Card(
//                modifier = Modifier.fillMaxWidth(),
//                colors = CardDefaults.cardColors(CardBGColor),
//                shape = RoundedCornerShape(12.dp)
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 12.dp, vertical = 8.dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Icon(
//                        painter = painterResource(R.drawable.outline_settings_24),
//                        contentDescription = null
//                    )
//                    Column(
//                        modifier = Modifier
//                            .weight(1f)
//                            .padding(horizontal = 8.dp)
//                    ) {
//                        Text("Location", fontSize = 13.sp, color = Color.Gray)
//                        Text("St. no 8, KTM, Nepal", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
//                    }
//                    Icon(
//                        painter = painterResource(R.drawable.outline_notifications_24),
//                        contentDescription = null
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(15.dp))
//
//            Card(
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(16.dp),
//                colors = CardDefaults.cardColors(Color(0xFFFFD54F))
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        modifier = Modifier.weight(1f)
//                    ) {
//                        Text("Time for Special Deal", fontSize = 13.sp, color = Color.DarkGray)
//                        Text(
//                            "70% Off",
//                            fontSize = 26.sp,
//                            fontWeight = FontWeight.Bold,
//                            color = Color(0xFFCC0000)
//                        )
//                        Text(
//                            "Use voucher now while supplies available. Get extra 10% off on your first order.",
//                            fontSize = 11.sp,
//                            color = Color.DarkGray
//                        )
//                        Spacer(modifier = Modifier.height(10.dp))
//                        Button(
//                            onClick = { },
//                            shape = RoundedCornerShape(30.dp),
//                            colors = ButtonDefaults.buttonColors(containerColor = Blue)
//                        ) {
//                            Text("Shop Now", fontSize = 12.sp, color = Color.White)
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Image(
//                        painter = painterResource(R.drawable.luffy),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .height(100.dp)
//                            .aspectRatio(1f),
//                        contentScale = ContentScale.Crop
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(18.dp))
//
//            LazyRow(
//                horizontalArrangement = Arrangement.spacedBy(14.dp)
//            ) {
//                items(categories) { cat ->
//                    CategoryCard(cat)
//                }
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Column {
//                    Text("Flash Sale", fontSize = 18.sp, fontWeight = FontWeight.Bold)
//                    Text(
//                        "Only few items left, ending soon!",
//                        fontSize = 12.sp,
//                        color = Color.Gray
//                    )
//                }
//                Text("20 items left", fontSize = 12.sp, color = Blue)
//            }
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
//                items(flashSale) { product ->
//                    ProductCard(product)
//                }
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Column {
//                    Text("Recommended for you", fontSize = 18.sp, fontWeight = FontWeight.Bold)
//                    Text(
//                        "Buy them before it’s too late!",
//                        fontSize = 12.sp,
//                        color = Color.Gray
//                    )
//                }
//                Text("See all", fontSize = 12.sp, color = Blue)
//            }
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
//                items(recommended) { product ->
//                    ProductCard(product)
//                }
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))
//        }
    }


}
//
//@Composable
//fun CategoryCard(item: CategoryItem) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Card(
//            shape = RoundedCornerShape(12.dp),
//            colors = CardDefaults.cardColors(White),
//            modifier = Modifier
//                .size(70.dp)
//        ) {
//            Image(
//                painter = painterResource(item.iconRes),
//                contentDescription = null,
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
//        }
//        Spacer(modifier = Modifier.height(6.dp))
//        Text(item.name, fontSize = 12.sp)
//    }
//}
//
//@Composable
//fun ProductCard(item: ProductItem) {
//    Card(
//        modifier = Modifier
//            .width(140.dp),
//        shape = RoundedCornerShape(12.dp),
//        colors = CardDefaults.cardColors(White)
//    ) {
//        Column(
//            modifier = Modifier.padding(8.dp)
//        ) {
//            Image(
//                painter = painterResource(item.imageRes),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(90.dp),
//                contentScale = ContentScale.Crop
//            )
//            Spacer(modifier = Modifier.height(6.dp))
//            Text(item.name, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
//            Spacer(modifier = Modifier.height(2.dp))
//            Text(item.price, fontSize = 12.sp, color = Blue, fontWeight = FontWeight.Bold)
//            Text(
//                item.oldPrice,
//                fontSize = 11.sp,
//                color = Color.Gray
//            )
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen()
}