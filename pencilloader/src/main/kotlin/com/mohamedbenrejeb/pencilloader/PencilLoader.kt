package com.mohamedbenrejeb.pencilloader

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp

@Composable
fun PencilLoader(
    modifier: Modifier = Modifier,
    strokeWidth: Dp
) {

    val pencilRotationProgress = remember {
        Animatable(initialValue = 0f)
    }

    val circleProgress =
        if (pencilRotationProgress.value < 1f)
            pencilRotationProgress.value
        else
            2f - pencilRotationProgress.value

    val circleStart =
        if (pencilRotationProgress.value < 1f)
            0f
        else
            0.5f + (pencilRotationProgress.value - 1f)

    LaunchedEffect(key1 = pencilRotationProgress) {
        pencilRotationProgress.animateTo(
            targetValue = 2f,
            animationSpec = infiniteRepeatable(
                animation = keyframes {
                    durationMillis = 4000
                    // Drawing
                    0.0f at 0 with LinearOutSlowInEasing
                    1.0f at 1400 with LinearOutSlowInEasing
                    1.0f at 2000 with LinearOutSlowInEasing

                    // Erasing
                    2.0f at 3400 with LinearOutSlowInEasing
                    2.0f at 4000 with LinearOutSlowInEasing
                },
                repeatMode = RepeatMode.Restart
            )
        )
    }

    Box(
        modifier = modifier
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .graphicsLayer {
                    rotationZ = circleStart * 360
                }
                .fillMaxSize()
            ,
            progress = circleProgress,
            strokeWidth = strokeWidth,
            color = Color(0xff192c55)
        )

        Pencil(
            modifier = Modifier
                .graphicsLayer {
                    rotationZ = 360 * pencilRotationProgress.value
                }
                .fillMaxSize()
        )
    }

}