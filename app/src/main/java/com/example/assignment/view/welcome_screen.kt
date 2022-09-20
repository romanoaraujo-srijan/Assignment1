package com.example.assignment.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.assignment.ui.theme.productList

import com.google.gson.annotations.SerializedName
//
//data class Product(
//    @SerializedName("title")
//    var productName: String,
//    @SerializedName("image")
//    var imageUrl: String
//)
data class Product(
    @SerializedName("title")
    var productName: String,
    @SerializedName("image")
    var imageUrl: String
)

//Home Screen
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun productScreen() {

    // var newList = productList ?: listOf<Product>()
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.background(Color.Cyan),
        content = {
            items(productList!!.size) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(5.dp),
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(3.dp, Color.Black),
                ) {
                    Image(
                        painter = rememberImagePainter(productList!![index].imageUrl),
                        contentDescription = "",
                        contentScale = ContentScale.Fit
                    )

                    Box(
                        contentAlignment = Alignment.BottomCenter,
                        modifier = Modifier.background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.DarkGray),
                                startY = 400f
                            )
                        )
                    ) {
                        Text(
                            text = productList!![index].productName,
                            modifier = Modifier.padding(5.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        })
}
