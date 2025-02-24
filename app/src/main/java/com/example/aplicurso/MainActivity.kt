package com.example.aplicurso
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.aplicurso.ui.theme.ApliCursoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApliCursoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SigninPage(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SigninPage(modifier: Modifier = Modifier) {
    var userSignIn = remember { mutableStateOf("") }
    var passwordSignIn = remember { mutableStateOf("") }
    var errorMessage = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign In", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de Usuario
        TextField(
            value = userSignIn.value,
            onValueChange = { userSignIn.value = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de Contraseña
        TextField(
            value = passwordSignIn.value,
            onValueChange = { passwordSignIn.value = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de Sign In
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (userSignIn.value.isEmpty() || passwordSignIn.value.isEmpty()) {
                    errorMessage.value = "Todos los campos son obligatorios"
                } else {
                    errorMessage.value = "" // Aquí podrías hacer la llamada a la API
                }
            }
        ) {
            Text(text = "Sign In")
        }


        if (errorMessage.value.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = errorMessage.value, color = MaterialTheme.colorScheme.error)
        }
    }
}
