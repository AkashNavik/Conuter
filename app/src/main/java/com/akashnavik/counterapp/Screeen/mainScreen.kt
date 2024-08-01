package com.akashnavik.counterapp.Screeen

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.akashnavik.counterapp.R
import com.akashnavik.counterapp.ViewModel.CounterViewModals

@Composable
fun mainScreenFinal(navHostController: NavHostController , viewModel: CounterViewModals){
    var id = remember {
        mutableStateOf(0)
    }
    var context = LocalContext.current
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp)
        .background(color = Color(44, 52, 60, 255))
        ,horizontalAlignment = Alignment.CenterHorizontally
        ,verticalArrangement = Arrangement.SpaceAround

    ) {
        Text(
            text = "Counter", style = TextStyle(
                fontSize = 100.sp,
                fontWeight = FontWeight.Bold, fontFamily = FontFamily.Cursive
                , color = Color(226, 226, 226)
            )
        )
        Column(
            modifier = Modifier.size(200.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Modes", style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default,
                    color = Color(226, 226, 226)
                )
            )
            Row(
                modifier = Modifier
                    .clickable {
                        id.value = 1
                        navHostController.navigate("secondScreen/${id.value}")
                    }
                    .width(120.dp)
                    .height(50.dp)
                    .background(color = Color(226, 226, 226), shape = RoundedCornerShape(25.dp)),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.minusicon), contentDescription = null,
                    tint = Color(226, 226, 226),
                    modifier = Modifier
                        .background(color = Color(244, 67, 54, 255), shape = CircleShape)
                        .size(40.dp)
                        .padding(8.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.plusicon), contentDescription = null,
                    tint = Color(226, 226, 226),
                    modifier = Modifier
                        .background(color = Color(76, 175, 80, 255), shape = CircleShape)
                        .size(40.dp)
                        .padding(8.dp)
                )

            }
            Row(modifier = Modifier
                .clickable {
                    id.value = 2
                    navHostController.navigate("secondScreen/${id.value}")
                }
                .width(120.dp)
                .height(50.dp)
                .background(color = Color(226, 226, 226), shape = RoundedCornerShape(25.dp)),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plusicon), contentDescription = null,
                    tint = Color(226, 226, 226),
                    modifier = Modifier
                        .background(color = Color(76, 175, 80, 255), shape = CircleShape)
                        .size(40.dp)
                        .padding(8.dp)
                )

            }

        }
        Row(modifier = Modifier.fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }, enabled = false) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "",
                    modifier = Modifier.size(75.dp),
                    tint = Color(226, 226, 226)
                )
            }
            Share(text = "https://github.com/AkashNavik/CounterApp", context = context)
        }
    }
}


@Composable
fun Share(text: String, context: Context) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    IconButton(onClick = {
        startActivity(context, shareIntent, null)
    }) {
        Icon(
            Icons.Default.Share,
            contentDescription = "",
            modifier = Modifier.size(75.dp),
            tint = Color(226, 226, 226)
        )
    }
}