package com.example.constraintlayoutincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.example.constraintlayoutincompose.ui.theme.ConstraintLayoutInComposeTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ){
                CircularProgressBar(percentage = 0.8f, number = 100 )

            }

        }
    }
}

@Composable
fun CircularProgressBar (
    percentage: Float,
    number: Int,
    textUnit: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Red,
    strokeWith: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
    ) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercentage = animateFloatAsState (
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay,

        )
    )
    LaunchedEffect(key1 =true){
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                -90f,
                360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWith.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (curPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
        )
    }
}







//        animated whatever ************************************************

//            var sizeState by remember { mutableStateOf(200.dp)}
//            val size by animateDpAsState(
//                targetValue = sizeState,
//                keyframes {  }
//                )
//            Box (modifier = Modifier
//                .background(Color.Red)
//                .size(size),
//                contentAlignment = Alignment.Center){
//                Button(onClick = {
//                 sizeState += 50.dp
//               }) {
//                    Text ("increase size")
//                }
//            }
//        }
//
//
//
//        }
//    }
//
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ConstraintLayoutInComposeTheme {
//        Greeting("Android")
//    }
//}

// <ConstraintLayout>*****************************************************************************

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