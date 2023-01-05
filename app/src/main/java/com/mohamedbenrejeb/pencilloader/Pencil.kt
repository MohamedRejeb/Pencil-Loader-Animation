package com.mohamedbenrejeb.pencilloader

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Pencil(
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val pencilWidth = size.width / 7

        // The Triangle Will take 1/10 of the height and will start from height 0
        // So now we used 1/10 of the total height
        val trianglePath = Path().apply {
            moveTo(size.width / 2, 0f)
            lineTo((size.width / 2) - pencilWidth / 4f, size.height * (1f / 10f))
            lineTo((size.width / 2) + pencilWidth / 4f, size.height * (1f / 10f))
        }
        drawPath(
            path = trianglePath,
            color = Color(0xff192c55),
        )

        // The Pencil Upper Wood Will take 1/10 of the height and will start from height 1/10 of the height
        // So now we used 2/10 of the total height
        val pencilUpperWoodPath = Path().apply {
            moveTo((size.width / 2) - pencilWidth / 4f, size.height * (1f / 10f))
            lineTo((size.width / 2) + pencilWidth / 4f, size.height * (1f / 10f))
            lineTo((size.width / 2) + pencilWidth / 2f, size.height * (2f / 10f))
            lineTo((size.width / 2) - pencilWidth / 2f, size.height * (2f / 10f))
        }
        drawPath(
            path = pencilUpperWoodPath,
            color = Color(0xffffd526)
        )

        // The Pencil Body Rect Will take 7/10 of the height and will start from height 2/10 of the height
        // So now we used 9/10 of the total height
        drawRect(
            color = Color(0xff116dff),
            topLeft = Offset((size.width / 2) - pencilWidth / 2f, size.height * (2f / 10f)),
            size = Size(pencilWidth, size.height * (7f / 10f))
        )

        // The Pencil Tail Rect Will take 1/10 of the height and will start from height 9/10 of the height
        // So now we used 10/10 of the total height
        drawRect(
            color = Color(0xff28bf9b),
            topLeft = Offset((size.width / 2) - pencilWidth / 2f, size.height * (9f / 10f)),
            size = Size(pencilWidth, size.height * (1f / 10f))
        )
    }
}

@Preview
@Composable
fun PencilPreview() {
    Pencil(
        modifier = Modifier
            .size(200.dp)
            .background(Color.White)
    )
}