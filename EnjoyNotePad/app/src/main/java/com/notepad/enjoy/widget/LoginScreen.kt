package com.notepad.enjoy.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.notepad.enjoy.R

/**
 * @Description: 登录界面$
 * @Author: ChrisYe
 * @Date: 2025-11-30-13:08
 */
@Composable
fun LoginScreen(onNavigateToDetail: (String) -> Unit) {
    var username by remember { mutableStateOf("") }
    var passWord by remember { mutableStateOf("") }
    val token by remember { mutableStateOf("") }
    val email by remember { mutableStateOf("") }
    val passwordVisible by remember { mutableStateOf(false) }
    var submit by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(45.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(R.mipmap.logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(100.dp)
                .clip(shape = CircleShape)
        )

        Spacer(modifier = Modifier.height(60.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("账号") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = passWord,
            onValueChange = { passWord = it },
            label = { Text("密码") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )



        Spacer(modifier = Modifier.height(35.dp))

        Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
            Text("登录")
        }

        LoginOptionWidget(onNavigateToDetail)
    }
}

@Composable
fun LoginOptionWidget(onNavigateToDetail: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,
    ) {
        ImageIcon(
            R.mipmap.login_phone,
            modifierSize = 35,
            description = "手机号登录",
            onNavigateToDetail = onNavigateToDetail,
            route = "login_phone",
            modifier = Modifier.weight(1f),
        )

        Spacer(Modifier.width(15.dp))

        ImageIcon(
            R.mipmap.login_register,
            modifierSize = 35,
            description = "注册账号",
            onNavigateToDetail = onNavigateToDetail,
            route = "login_phone",
            modifier = Modifier.weight(1f),
        )

        Spacer(Modifier.width(15.dp))

        ImageIcon(
            R.mipmap.login_email,
            modifierSize = 35,
            description = "邮箱登录",
            onNavigateToDetail = onNavigateToDetail,
            route = "login_phone",
            modifier = Modifier.weight(1f),
        )
    }

    Spacer(Modifier.height(30.dp))
}

@Composable
@Preview
fun ShowLogin() {
}