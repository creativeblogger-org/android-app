package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.example.myapplication.datastore.StoreToken
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val tokenStore = StoreToken(context = LocalContext.current);
            val token = tokenStore.getToken.collectAsState(initial = "");
            var tokenValue by remember {
                mutableStateOf("")
            }
            val coroutineScope = rememberCoroutineScope()
            MyApplicationTheme {
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(value = tokenValue, onValueChange = {tokenValue = it})
                    ElevatedButton(onClick = {
                        coroutineScope.launch {
                            tokenStore.saveToken(tokenValue)
                        }
                    }) {
                        Text("Sauvegarder")
                    }

                    if (token.value.isEmpty()) {
                        Text("Pas de token", color = MaterialTheme.colorScheme.onBackground, textAlign = TextAlign.Center)
                    } else {
                        Text("Token enregistré : ${token.value}", color = MaterialTheme.colorScheme.onBackground)
                    }
                }
            }
        }
    }
}
