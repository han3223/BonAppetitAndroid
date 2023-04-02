package com.example.restaurantandroid.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.linguaflow.R
import com.example.linguaflow.basket
import com.example.restaurantandroid.ui.Eat

val buttonHall = mutableStateOf(R.color.button_price)
val buttonDelivery = mutableStateOf(R.color.white)
val order = mutableListOf<Eat>()
var price = mutableStateOf(0)

@Composable
fun BasketScreen() {
    var expanded by remember { mutableStateOf(false) }

    AnimatedVisibility(visible = basket.value, enter = fadeIn(), exit = fadeOut()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.black))
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Шапка
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.10f)
            ) {
                Image(
                    painter = painterResource(R.drawable.header),
                    contentDescription = null, modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(250.dp, 70.dp)
                            .padding(20.dp, 0.dp, 0.dp, 0.dp),
                    )
                }

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(0.dp, 15.dp, 0.dp, 0.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                if (order.isEmpty())
                    OrderEmpty()
                else {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(ScrollState(0))
                            .padding(0.dp, 0.dp, 0.dp, 60.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Box(
                            modifier = Modifier
                                .width(300.dp)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Column(modifier = Modifier.fillMaxWidth(1f)) {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Button(
                                        onClick = {
                                            buttonHall.value = R.color.button_price
                                            buttonDelivery.value = R.color.white
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth(0.5f),
                                        shape = RoundedCornerShape(8.dp, 0.dp, 0.dp, 8.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = colorResource(buttonHall.value)
                                        )
                                    ) {
                                        Text(
                                            text = "В зале",
                                            color = colorResource(buttonDelivery.value)
                                        )
                                    }
                                    Button(
                                        onClick = {
                                            buttonDelivery.value = R.color.button_price
                                            buttonHall.value = R.color.white
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        shape = RoundedCornerShape(0.dp, 8.dp, 8.dp, 0.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = colorResource(buttonDelivery.value)
                                        )
                                    ) {
                                        Text(text = "Доставка", color = colorResource(buttonHall.value))
                                    }
                                }
                                Box {
                                    Button(
                                        onClick = { expanded = true },
                                        modifier = Modifier
                                            .height(32.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = Color.White
                                        ),
                                        shape = RoundedCornerShape(8.dp)
                                    ) {
                                        IconButton(onClick = { expanded = true }) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.drop),
                                                contentDescription = "Показать меню",
                                                modifier = Modifier.fillMaxWidth(0.95f)
                                            )
                                        }
                                        IconButton(onClick = { expanded = true }) {
                                            Icon(
                                                Icons.Default.ArrowDropDown,
                                                contentDescription = "Показать меню"
                                            )
                                        }
                                    }
                                    DropdownMenu(
                                        expanded = expanded,
                                        onDismissRequest = { expanded = false }) {
                                        Text(
                                            "Скопировать",
                                            fontSize = 18.sp,
                                            modifier = Modifier
                                                .padding(10.dp)
                                                .clickable(onClick = {})
                                        )
                                        Text(
                                            "Вставить",
                                            fontSize = 18.sp,
                                            modifier = Modifier
                                                .padding(10.dp)
                                                .clickable(onClick = {})
                                        )
                                        Divider()
                                        Text(
                                            "Настройки",
                                            fontSize = 18.sp,
                                            modifier = Modifier
                                                .padding(10.dp)
                                                .clickable(onClick = {})
                                        )
                                    }
                                }
                                // Заказ
                                if (order.isNotEmpty()) {
                                    order.forEachIndexed { index, item ->
                                        Spacer(modifier = Modifier.size(15.dp))
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(10.dp, 10.dp),
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Column(modifier = w.value) {
                                                Row() {
                                                    Image(
                                                        painter = painterResource(id = item.icon!!),
                                                        contentDescription = item.title,
                                                        modifier = Modifier
                                                            .size(150.dp)
                                                            .clip(RoundedCornerShape(25.dp)),
                                                        alignment = Alignment.Center,
                                                        contentScale = ContentScale.FillBounds
                                                    )
                                                    Column(modifier = Modifier.padding(10.dp)) {
                                                        Text(item.title!!, color = Color.White)
                                                        Image(
                                                            painter = painterResource(id = R.drawable.line),
                                                            contentDescription = item.title,
                                                            modifier = Modifier
                                                                .size(150.dp, 3.dp)
                                                                .clip(RoundedCornerShape(25.dp)),
                                                            alignment = Alignment.Center,
                                                            contentScale = ContentScale.FillBounds
                                                        )
                                                        Text(
                                                            "каллорийность - ${item.calories!!} ккал \nбелки - 00г, жиры - 00г, углеводы - 00г",
                                                            fontSize = 3.em,
                                                            color = Color.White
                                                        )
                                                    }
                                                }
                                                Box(
                                                    modifier = Modifier.padding(
                                                        0.dp,
                                                        10.dp,
                                                        0.dp,
                                                        0.dp
                                                    )
                                                ) {
                                                    AddFood(item = item, index = index)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .fillMaxHeight(0.9f),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Column(modifier = Modifier.padding(0.dp, 0.dp, 15.dp, 0.dp)) {
                            Text(text = "Итог: ${price.value}р", color = Color.White)
                            Button(
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(id = R.color.button_price)
                                )
                            ) {
                                Text(text = "Оплатить", color = Color.White)
                            }
                        }
                    }
                }
            }

        }
    }

}

@Composable
fun OrderEmpty() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.order_empty),
                contentDescription = "order empty",
                modifier = Modifier.size(250.dp)
            )
            Text(
                text = "Вы пока ничего не заказали",
                fontSize = 10.em,
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle(1),
                textAlign = TextAlign.Center
            )
        }
    }

}