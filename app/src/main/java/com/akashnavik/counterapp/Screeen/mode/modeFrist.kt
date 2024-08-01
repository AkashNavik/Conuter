package com.akashnavik.counterapp.Screeen.mode

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.akashnavik.counterapp.R
import com.akashnavik.counterapp.Screeen.setting.vibAndscound
import com.akashnavik.counterapp.ViewModel.CounterViewModals


@Composable
fun moodeFirst(viewModals: CounterViewModals) {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()
        , verticalArrangement = Arrangement.SpaceEvenly
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 40.dp))
        Text(text = "${viewModals.cont.value}"
            , style = TextStyle(
                fontSize = 125.sp
                , fontWeight = FontWeight.Bold
                , color = Color(226, 226, 226, 255)
            )
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(onClick = {
                viewModals.decrement()
                vibAndscound(context)                             },
                modifier = Modifier.size(150.dp)
                ,colors = ButtonDefaults.buttonColors(
                    containerColor = Color(244, 67, 54, 255)
                )
                , shape = CircleShape
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.minusicon), contentDescription = null,
                    tint = Color(226, 226, 226),
                    modifier = Modifier
                        .size(75.dp)
                        .padding(8.dp)
                )
            }
            Button(onClick = {
                viewModals.increment()
                vibAndscound(context)
                             },
                modifier = Modifier.size(150.dp)
                ,colors = ButtonDefaults.buttonColors(
                    containerColor = Color(76, 175, 80, 255))
                , shape = CircleShape
            ){
                Icon(
                    painter = painterResource(id = R.drawable.plusicon), contentDescription = null,
                    tint = Color(226, 226, 226),
                    modifier = Modifier
                        .size(75.dp)
                        .padding(8.dp)
                )
            }
        }
        IconButton(onClick = {
            viewModals.zero()
            vibAndscound(context)
                             },
            modifier = Modifier.size(150.dp)
        ){
            Icon(
                Icons.Default.Refresh, contentDescription = null,
                tint = Color(226, 226, 226),
                modifier = Modifier
                    .size(75.dp)
                    .padding(8.dp)
            )
        }
    }
}