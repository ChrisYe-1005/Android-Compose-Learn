package com.notepad.enjoy.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @Description: $
 * @Author: ChrisYe
 * @Date: 2025-11-30-14:15
 */
@Composable
fun ImageIcon(
    imageResource: Int,
    modifier: Modifier = Modifier,
    modifierSize: Int,
    description: String,
    onNavigateToDetail: (String) -> Unit,
    route: String,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = imageResource),
            modifier = Modifier
                .clickable {
                    onNavigateToDetail(route)
                }
                .size(modifierSize.dp)
                .clip(shape = CircleShape)
                .border(width = (1.dp), color = Color.Gray, shape = CircleShape)
                .padding(5.dp),
            contentDescription = description
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = description, fontSize = 12.sp)
    }
}

@Composable
@Preview
fun ImageIconPreview() {

}