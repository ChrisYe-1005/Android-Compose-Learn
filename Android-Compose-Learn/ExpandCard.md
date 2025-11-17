```kotlin
package com.example.learn_day01

/**
 * @Description: Compose学习
 * @Author: ChrisYe
 * @Date: 2025-11-18-11:51
 */

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 可展开/折叠的卡片组件
 * 该组件实现了Material Design风格的可展开卡片，包含标题和可展开的详细内容区域
 *
 * @param title 卡片标题文本
 * @param titleSize 标题字体大小，默认为32.sp
 * @param content 卡片展开时显示的详细内容文本
 */
@Composable
fun ExpandCard(
    title: String,
    titleSize: TextUnit = 32.sp,
    content: String,
) {
    // 使用remember记录展开状态，确保重组时状态不被重置
    var expandedState by remember { mutableStateOf(false) }

    // 箭头图标旋转动画状态，根据展开状态计算旋转角度
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f  // 展开时旋转180度，折叠时0度
    )

    // 主卡片容器，使用Material3的Card组件
    Card(
        modifier = Modifier
            .fillMaxWidth()  // 横向占满父容器
            .animateContentSize(  // 添加内容大小变化的动画效果
                animationSpec = tween(
                    durationMillis = 1500,  // 动画持续时间1.5秒
                    easing = LinearOutSlowInEasing  // 先线性后缓入的缓动函数
                )
            )
            .background(Color.White)  // 设置白色背景
            .padding(20.dp),  // 外部边距20dp
        shape = RoundedCornerShape(4.dp),  // 设置4dp圆角
        onClick = {
            // 卡片点击事件：切换展开/折叠状态
            expandedState = !expandedState
        }
    ) {
        // 垂直布局容器，用于排列标题行和内容区域
        Column(
            modifier = Modifier
                .fillMaxWidth()  // 横向占满卡片宽度
                .padding(10.dp),  // 内部边距10dp
        ) {
            // 水平布局行，包含标题文本和展开按钮
            Row(verticalAlignment = Alignment.CenterVertically) {
                // 标题文本，使用较大的权重占据大部分空间
                Text(
                    modifier = Modifier.weight(6f),  // 权重6，占据6/7的空间
                    text = title,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold  // 粗体显示
                )
                // 展开/折叠按钮
                IconButton(
                    modifier = Modifier
                        .alpha(0.5f)  // 设置半透明效果
                        .weight(1f)  // 权重1，占据1/7的空间
                        .rotate(rotationState),  // 应用旋转动画
                    onClick = {
                        // 按钮点击事件：切换展开/折叠状态
                        expandedState = !expandedState
                    }) {
                    // 下拉箭头图标
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = "下拉按钮",  // 无障碍访问描述
                    )
                }
            }

            // 条件渲染：仅在展开状态下显示详细内容
            if (expandedState) {
                Text(
                    text = "This is My First Project\n".repeat(5),  // 重复5次示例文本
                    fontSize = 18.sp  // 内容文本使用18.sp字体
                )
            }
        }
    }
}

/**
 * 预览函数，用于Android Studio的预览面板显示组件效果
 * 该函数不会被编译到正式APK中，仅用于开发时预览
 */
@Composable
@Preview
fun ExpandableCardPreview() {
    // 调用ExpandCard组件并传入示例参数
    ExpandCard(
        title = "Hello Word!",  // 示例标题
        content = "\"This is my first project, you are so great\\n\".repeat(5)"  // 示例内容
    )
}

```

