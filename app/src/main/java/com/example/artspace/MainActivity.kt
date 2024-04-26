package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {
    var leader by remember { mutableStateOf("1")}
    var country by remember { mutableStateOf("1")}
    var country_pic by remember { mutableStateOf("1")}


    Column(
        modifier = Modifier

            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // First child column
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .height(100.dp)
                .border(1.dp, Color(0xFF800080))
                .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp), // Adjust vertical spacing between nested columns
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Nested child columns
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Make the nested columns occupy equal space
                    .border(1.dp, Color.Red),

                ) {
                val image = painterResource(R.drawable.country_1_pic)
                Image(
                    painter = image, contentDescription = "Kim Jong Un",
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                )

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 8) // Make the nested columns occupy equal space
                    .border(1.dp, Color.Red)
                    .padding(horizontal = 70.dp, vertical = 0.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(65.dp)
                        .border(1.dp, Color.Gray)
                        .padding(horizontal = 0.dp, vertical = 0.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.leader_1),
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    )
                    Text(
                        text = stringResource(R.string.country_1),
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 12) // Make the nested columns occupy equal space
                    .border(1.dp, Color.Red),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = { /* Button 1 action */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        shape = RectangleShape) {
                        Text(text = "Previous")
                    }
                    Button(onClick = { /* Button 2 action */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        shape = RectangleShape) {
                        Text(text = "Next")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}