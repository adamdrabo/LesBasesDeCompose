package com.adamdrabo.lesbasesdecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adamdrabo.lesbasesdecompose.ui.theme.LesBasesDeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LesBasesDeComposeTheme {
                LesBasesDeCompose()
            }
        }
    }
}

@Composable
fun LesBasesDeCompose(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.systemBars)
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DemoColumn()

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color.DarkGray)
        )

        DemoRow()

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color.DarkGray)
        )

        DemoBox(
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun DemoColumn(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bonjour Adam")
        Text("Bienvenue sur mon application")
    }
}

@Composable
fun DemoRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Campagne")
        Text("Champ")
    }
}

@Composable
fun DemoBox(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(100.dp)
            .clip(CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LesBasesDeComposePreview() {
    LesBasesDeCompose()
}