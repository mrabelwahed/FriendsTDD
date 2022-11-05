package com.ramadan.freindstdd.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ramadan.freindstdd.R

@Composable
fun SignUpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        ScreenTitle(R.string.create_account)
        Spacer(modifier = Modifier.height(16.dp))
        EmailField(email, onValueChange = { email = it })
        PasswordField(password, onValueChange = { password = it })

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { },

            ) {
            Text(text = stringResource(id = R.string.signup))
        }
    }
}

@Composable
private fun EmailField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        label = { Text(text = stringResource(id = R.string.email)) },
        onValueChange = onValueChange
    )
}

@Composable
private fun PasswordField(value: String, onValueChange: (String) -> Unit) {
    var isVisible by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        label = { Text(text = stringResource(id = R.string.password)) },
        trailingIcon = {
            IconButton(onClick = {isVisible = !isVisible}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_visibility),
                    contentDescription = stringResource(id = R.string.toggle_visibility)
                )
            }
        },
        visualTransformation = if (isVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        onValueChange = onValueChange
    )
}

@Composable
private fun ScreenTitle(@StringRes titleResource: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = titleResource))
    }
}