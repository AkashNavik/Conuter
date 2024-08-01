package com.akashnavik.counterapp.Screeen.mode

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun modeSecondfinal(viewModals: CounterViewModals) {
    var context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()
        , verticalArrangement = Arrangement.SpaceEvenly
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${viewModals.cont.value}", style = TextStyle(
                fontSize = 125.sp, fontWeight = FontWeight.Bold,
                color = Color(226, 226, 226)
            )
        )
        Button(onClick = { viewModals.increment()
            vibAndscound(context)
                         },
            modifier = Modifier.size(200.dp)
            ,colors = ButtonDefaults.buttonColors(
                containerColor = Color(76, 175, 80, 255))
            , shape = CircleShape
        ){
            Icon(
                painter = painterResource(id = R.drawable.plusicon), contentDescription = null,
                tint = Color(226, 226, 226),
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { viewModals.decrement()
                vibAndscound(context)
                             },
                modifier = Modifier.size(75.dp)
                ,colors = ButtonDefaults.buttonColors(
                    containerColor = Color(244, 67, 54, 255)
                )
                , shape = CircleShape
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.minusicon),
                    contentDescription = "",
                    tint = Color(226, 226, 226),
                    modifier = Modifier.size(75.dp)


                )
            }
            IconButton(onClick = { viewModals.zero()
                vibAndscound(context)
            }) {
                Icon(
                    Icons.Default.Refresh,
                    tint = Color(226, 226, 226),
                    contentDescription = "",
                    modifier = Modifier.size(75.dp),
                )
            }
        }
    }
}