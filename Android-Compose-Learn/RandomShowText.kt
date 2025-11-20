package com.example.learn_day01

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.collections.plus
import kotlin.random.Random

/**
 * @Description: 随机显示字体
 * @Author: ChrisYe
 * @Date: 2025-11-21-12:12
 */
class RandomShowText {
    @Composable
    fun StartShowText() {
        // 存储所有显示的文本状态
        var textItems by remember {
            mutableStateOf<List<TextState>>(emptyList())
        }

        // 使用LaunchedEffect管理定时器
        LaunchedEffect(Unit) {
            while (true) {
                delay(300)
                // 添加新的文本项，保持之前的文本不消失
                textItems = textItems + TextState(
                    id = System.currentTimeMillis(),
                    width = Random.nextInt(0, 600),
                    height = Random.nextInt(0, 800),
                    color = Color(
                        red = Random.nextInt(0, 256),
                        green = Random.nextInt(0, 256),
                        blue = Random.nextInt(0, 256)
                    ),
                    size = 18.sp
                )
            }
        }

        Box(
            modifier = Modifier.fillMaxSize().padding(20.dp)
        ) {
            // 渲染所有文本项
            textItems.forEach { textState ->
                FloatingText(
                    textState = textState,
                    modifier = Modifier
                )
            }
        }
    }

    @Composable
    fun FloatingText(
        textState: TextState,
        modifier: Modifier = Modifier
    ) {
        Text(
            text = "Miss",
            fontSize = textState.size,
            color = Color.White,
            modifier = modifier
                .offset(
                    x = textState.width.dp,
                    y = textState.height.dp
                )
                .background(textState.color, shape = RoundedCornerShape(30))
                .padding(5.dp)  // 先设置内边距
                .border(width = 1.dp, color = textState.color, RoundedCornerShape(30))
        )
    }
}