package com.example.miappfg

import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.example.miappfg.ui.theme.MiAppFGTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiAppFGTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .padding(WindowInsets.statusBars.asPaddingValues())
                ) { innerPadding ->
                    mensaje("Fedu")
                }
            }

            /*
            MiAppFGTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    mensaje("Federicu")
                }
            }
            * */


        }
    }
}

@Composable
fun mensaje(nombre: String) {
    Column{
        agregarHeader(nombre)
        Spacer(modifier = Modifier.height(30.dp))
        Box(modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.Center){
            var texto by remember { mutableStateOf("Hello") }
            Column(modifier = Modifier
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                TextField(
                    value = "Patricia",
                    onValueChange = { texto = it },
                    label = { Text("Tu nombre") }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick= {
                    println("Boton presionado")
                }){
                    Text("Go")
                }
            }

        }
        Spacer(modifier = Modifier.height(60.dp))
        unaCaja()
    }

}

@Composable
fun agregarHeader(nombre: String) {
    Column {
        Text(text = "Hola $nombre!", color = Color.Red, fontSize = 32.sp)
        Text(
            text = "Esto es una prueba de elementos",
            style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.LightGray, offset = Offset(5.0f, 10.0f), blurRadius = 3f
                )
            )
        )
        Row(modifier = Modifier.padding(all = 10.dp)) {
            Image(
                painter = painterResource(R.drawable.pim),
                contentDescription = "Este es pim",
                modifier = Modifier.size(80.dp)
            )
            VerticalDivider(
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .height(80.dp)
                    .width(1.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            cita()
        }
    }
}

@Composable
fun unaCaja(){
    Box(
        modifier = Modifier
            .background(color = Color.Cyan)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "A1",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                Text(
                    "B1",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                Text(
                    "C1",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
            HorizontalDivider(thickness = 5.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("A2", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                Text("B2", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                Text("C2", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
            }
            HorizontalDivider(thickness = 5.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("A3", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                Text("B3", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                Text("C3", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
            }
        }
    }
}
@Composable
fun cita(){
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
            append("\"Todo lo que vemos o parecemos es solo un sueño dentro de un sueño\"")
        }
        append(". - ")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("Edgard Allan Poe")
        }

    })
}

@Preview(showBackground = true)
@Composable
fun mensajePreview() {
    MiAppFGTheme {
        mensaje("Prevista")
    }
}
