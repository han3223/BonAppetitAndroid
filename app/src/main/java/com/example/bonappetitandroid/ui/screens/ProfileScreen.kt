package com.example.restaurantandroid.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.linguaflow.R
import com.example.bonappetitandroid.profile

var forgotPassword = mutableStateOf(false)
var logIn = mutableStateOf(true)
var signUp = mutableStateOf(false)

@Composable
fun ProfileScreen() {
    AnimatedVisibility(visible = profile.value, enter = fadeIn(), exit = fadeOut()) {
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

            if (forgotPassword.value)
                ForgotPassword()
            else if (logIn.value)
                LoginPage()
            else if (signUp.value)
                SignUp()
            else
                Profile()

        }
    }
}

@Composable
fun Profile() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
            .padding(0.dp, 15.dp, 0.dp, 0.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
        Box(modifier = Modifier.width(300.dp)) {
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Text(text = "", color = Color.White, fontSize = 6.em)
                        Text(text = "", color = Color.White, fontSize = 6.em)
                    }

                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = "profile",
                        modifier = Modifier.size(60.dp),
                        alignment = Alignment.BottomEnd
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = "line",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .clip(RoundedCornerShape(25.dp)),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "тел: 89116172604", color = Color.White, fontSize = 6.em)
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "email: ivan.vazhenin34@gmail.com",
                        color = Color.White,
                        fontSize = 6.em,
                        modifier = Modifier.width(260.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(30.dp, 120.dp)
                ) {
                    Text(
                        text = "адрес доставки:\nул. Коровникова, д. 12, кв. 101",
                        color = Color.White,
                        fontSize = 6.em,
                        modifier = Modifier.width(260.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(30.dp, 120.dp)
                        .padding(0.dp, 25.dp, 0.dp, 0.dp)
                ) {
                    Text(
                        text = "История заказов:",
                        color = Color.White,
                        fontSize = 6.em,
                        modifier = Modifier.width(260.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(30.dp, 120.dp)
                        .padding(0.dp, 5.dp, 0.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Время заказа",
                        color = Color.White,
                        fontSize = 5.em,
                    )
                    Text(
                        text = "Сумма",
                        color = Color.White,
                        fontSize = 5.em,
                    )
                    Text(
                        text = "Чек",
                        color = Color.White,
                        fontSize = 5.em,
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = "line",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .clip(RoundedCornerShape(25.dp)),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(30.dp, 120.dp)
                        .padding(0.dp, 5.dp, 0.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "12 фев. 2023 г. 18:32",
                        color = Color.White,
                        fontSize = 4.em,
                    )
                    Text(
                        text = "1780 ₽",
                        color = Color.White,
                        fontSize = 4.em,
                    )
                    Text(
                        text = "Посмотреть",
                        color = Color.White,
                        fontSize = 4.em,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }

    }
}

@Composable
fun ForgotPassword() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
            .padding(0.dp, 15.dp, 0.dp, 0.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .width(300.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val username = remember {
                mutableStateOf(TextFieldValue())
            }

            Text(
                text = "Forgot Password",
                style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                label = { Text(text = "Email", color = Color.White) },
                value = username.value,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White
                ),
                onValueChange = { username.value = it },
            )

            Spacer(modifier = Modifier.height(15.dp))

            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.button_price)
                    )
                ) {
                    Text(text = "Забыли пароль", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun LoginPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
            .padding(0.dp, 15.dp, 0.dp, 0.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .width(300.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val username = remember {
                mutableStateOf(TextFieldValue())
            }
            val password = remember {
                mutableStateOf(TextFieldValue())
            }

            Text(
                text = "Login",
                style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                label = { Text(text = "Email", color = Color.White) },
                value = username.value,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White
                ),
                onValueChange = { username.value = it }
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                label = { Text(text = "Password", color = Color.White) },
                value = password.value,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White
                ),
                onValueChange = { password.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.button_price)
                    )
                ) {
                    Text(text = "Войти", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            ClickableText(
                text = AnnotatedString("Забыли пароль?"),
                onClick = {
                    forgotPassword.value = true
                    logIn.value = false
                },
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Default,
                    color = Color.White
                )
            )
            ClickableText(
                text = AnnotatedString("Зарегистрироваться"),
                modifier = Modifier
                    .padding(20.dp),
                onClick = {
                    signUp.value = true
                    logIn.value = false
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default,
                    textDecoration = TextDecoration.Underline,
                    color = colorResource(id = R.color.button_price)
                )
            )
        }
    }

}

@Composable
fun SignUp() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
            .padding(0.dp, 15.dp, 0.dp, 0.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .width(300.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val username = remember {
                mutableStateOf(TextFieldValue())
            }

            val email = remember {
                mutableStateOf(TextFieldValue())
            }

            val password = remember {
                mutableStateOf(TextFieldValue())
            }

            val passwordConfirm = remember {
                mutableStateOf(TextFieldValue())
            }

            Text(
                text = "SignUp",
                style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                label = { Text(text = "ФИО", color = Color.White) },
                value = username.value,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White
                ),
                onValueChange = { username.value = it }
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                label = { Text(text = "Email", color = Color.White) },
                value = email.value,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White
                ),
                onValueChange = { email.value = it }
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                label = { Text(text = "Введите пароль", color = Color.White) },
                value = password.value,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White
                ),
                onValueChange = { password.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                label = { Text(text = "Подтвердите пароль", color = Color.White) },
                value = passwordConfirm.value,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White
                ),
                onValueChange = { passwordConfirm.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.button_price)
                    )
                ) {
                    Text(text = "Зарегистрироваться", color = Color.White)
                }
            }
            ClickableText(
                text = AnnotatedString("Войти"),
                modifier = Modifier
                    .padding(20.dp),
                onClick = {
                    signUp.value = false
                    logIn.value = true
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default,
                    textDecoration = TextDecoration.Underline,
                    color = colorResource(id = R.color.button_price)
                )
            )
        }
    }
}
