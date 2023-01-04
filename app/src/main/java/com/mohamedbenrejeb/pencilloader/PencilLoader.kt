package com.mohamedbenrejeb.pencilloader

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PencilLoader(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition()
    val progress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(modifier = modifier) {
        CircularProgressIndicator(
            modifier = Modifier
                .graphicsLayer {
                    rotationZ = 0f
                }
                .fillMaxSize()
            ,
            progress = progress,
            strokeWidth = 10.dp,
            color = Color(0xff192c55)
        )

        Pencil(
            modifier = Modifier
                .graphicsLayer {
                    rotationZ = 360 * progress
                }
                .fillMaxSize()
        )
    }

}

@Preview
@Composable
fun PencilLoaderPreview() {
    PencilLoader(
        modifier = Modifier
            .size(200.dp)
            .background(Color.White)
    )
}