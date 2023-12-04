package org.creativeblogger.org.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.creativeblogger.org.R
import org.creativeblogger.org.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            stringResource(R.string.welcome_back),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize
        )
        OutlinedTextField(
            value = loginViewModel.emailOrUsername,
            onValueChange = {
                loginViewModel.changeEmailOrUsername(it)
            },
            label = {
                Text(text = stringResource(R.string.email_or_username))
            },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = loginViewModel.password,
            onValueChange = {
                loginViewModel.changePassword(it)
            },
            label = {
                Text(text = stringResource(R.string.password))
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            loginViewModel.changeEmailOrUsername("Succès !")
        }, modifier = Modifier.fillMaxWidth()) {
            Text(stringResource(R.string.login))
        }
    }
}