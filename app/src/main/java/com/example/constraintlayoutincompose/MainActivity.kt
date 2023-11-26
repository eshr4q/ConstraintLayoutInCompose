package com.example.constraintlayoutincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.example.constraintlayoutincompose.ui.theme.ConstraintLayoutInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sizeState by remember { mutableStateOf(200.dp)}
            Box (modifier = Modifier
                .background(Color.Red)
                .size(sizeState),
                contentAlignment = Alignment.Center){
                Button(onClick = {
                 sizeState += 50.dp
               }) {
                    Text ("increase size")
                }
            }
        }



        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayoutInComposeTheme {
        Greeting("Android")
    }
}

// <ConstraintLayout>

//    val constraints = ConstraintSet {
//        val greenBox = createRefFor( "greenbox")
//        val redBox = createRefFor( "redbox")
//        val guidLine = createGuidelineFromTop(0.5f )
//
//        constrain(greenBox) {
//            top.linkTo(guidLine)
//            start.linkTo(parent.start)
//            width = Dimension.value(100.dp)
//            height = Dimension.value(100.dp)
//        }
//        constrain(redBox) {
//            top.linkTo(parent.top)
//            start.linkTo(greenBox.end)
//            end.linkTo(parent.end)
//            width = Dimension.value(100.dp)
//            height = Dimension.value(150.dp)
//        }
//        createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
//
//    }
//    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
//        Box(modifier = Modifier
//            .background(Color.Green)
//            .layoutId("greenbox")
//        )
//        Box(modifier = Modifier
//            .background(Color.Red)
//            .layoutId("redbox")
//        )
//
//    }
//
//
//}