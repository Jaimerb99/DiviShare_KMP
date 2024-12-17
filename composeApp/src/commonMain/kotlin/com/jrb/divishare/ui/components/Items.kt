package com.jrb.divishare.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrb.divishare.ui.AppTheme
import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.ic_arrow
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProjectItem(
    projectName: String,
    icon: DrawableResource,
    onProjectClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppTheme.colors.primary, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .clickable { onProjectClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .background(AppTheme.colors.background, RoundedCornerShape(12.dp))
                .size(55.dp)
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = "Project Icon",
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                colorFilter = ColorFilter.tint(AppTheme.colors.primary)
            )
        }

        Text(
            text = projectName,
            style = MaterialTheme.typography.h6.copy(
                color = AppTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold
            )
        )

        Image(
            painter = painterResource(Res.drawable.ic_arrow),
            contentDescription = "Forward Arrow",
            alignment = Alignment.Center,
            colorFilter = ColorFilter.tint(AppTheme.colors.onPrimary)
        )
    }
}

@Composable
fun EmptyScreen(title: String, description: String, image: DrawableResource){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Image(painter = painterResource(image), contentDescription = "Empty Screen Image")
        Spacer(modifier = Modifier.weight(1f))
        Text(title, style = TextStyle(
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.primary
        ))
        Spacer(modifier = Modifier.weight(1f))
        Text(
            description,
            modifier = Modifier.padding(horizontal = 40.dp),
            style = TextStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.weight(6f))
    }
}