package com.akashnavik.counterapp.Screeen.setting


import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akashnavik.counterapp.R


@Composable
fun InfoScreen() {
    var handle = LocalUriHandler.current
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp)
        .background(color = Color(44, 52, 60)),
         verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(modifier = Modifier.padding(20.dp)
            , elevation = CardDefaults.elevatedCardElevation(20.dp)
            , colors = CardDefaults.cardColors(Color(226, 226, 226))
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
                , modifier = Modifier.padding(25.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .border(
                            BorderStroke(5.dp, color = Color(213, 45, 29, 255)),
                            CircleShape
                        )
                        .clip(CircleShape)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Person, contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        tint = Color(119, 119, 119, 255)
                    )
                    Text(
                        text = "Developer",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color(119, 119, 119, 255)
                        )
                    )
                }
                Text(
                    text = "Akash Navik",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(45, 94, 192, 255)
                    )
                )
                Text(
                    text = "Fresher Android Developer", style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(119, 119, 119, 255)
                    )
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Join with me if you want to learn something new about programming",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center,
                        color = Color(119, 119, 119, 255)
                    )
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.linkedin_),
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp)
                            .clickable { handle.openUri("https://www.linkedin.com/in/akash-navik-38007617a") }
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Image(painter = painterResource(id = R.drawable.github),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .clickable { handle.openUri("https://www.github.com/AkashNavik") }
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Image(painter = painterResource(id = R.drawable.instagram),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                handle.openUri("https://www.instagram.com/akashnavik/")
                            }
                    )
                }
            }
        }
    }
}


fun vibAndscound(context: Context ){
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    val mediaPlayer = MediaPlayer.create(context, R.raw.click)
    // vibration code
    vibrator.vibrate(50)
    // sound code
    mediaPlayer.setOnCompletionListener { it.release() }
    mediaPlayer.start()
}