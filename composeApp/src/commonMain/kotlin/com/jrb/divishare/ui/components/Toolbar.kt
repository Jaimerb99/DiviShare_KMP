package com.jrb.divishare.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jrb.divishare.ui.AppTheme
import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.ic_add_project
import divishare_kmm.composeapp.generated.resources.ic_logo
import divishare_kmm.composeapp.generated.resources.ic_users
import org.jetbrains.compose.resources.painterResource

@Composable
fun ToolBar(
    onAddNewProject: () -> Unit,
    onProfileClick: () -> Unit
){
    /*Column {
        //Spacer(modifier = Modifier.height(40.dp))

    }*/
    Row(verticalAlignment = Alignment.CenterVertically,) {
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            painter = painterResource(Res.drawable.ic_add_project)
            , contentDescription = "Add project button",
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .clickable {
                    onAddNewProject() })
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(Res.drawable.ic_logo)
            , contentDescription = "Logo header",
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(Res.drawable.ic_users)
            , contentDescription = "User profile",
            colorFilter = ColorFilter.tint(Color.Black),
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .clickable { onProfileClick() }
        )
        Spacer(modifier = Modifier.width(20.dp))
    }
}

@Composable
fun LoginToolbar(){
    Row(modifier = Modifier.fillMaxWidth().background(AppTheme.colors.background)) {
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Image(
                painter = painterResource(Res.drawable.ic_logo)
                , contentDescription = "Logo header",
            )
            Text(
                "Log in",
                color = AppTheme.colors.primary,
                fontWeight = FontWeight.Bold,

            )
        }
        Spacer(modifier = Modifier.weight(1f)) }

}

@Composable
fun BackToolbar(
    title: String,
    onBack: () -> Unit
) {
    TopAppBar(
        backgroundColor = Color.Transparent,
        contentColor = AppTheme.colors.primary,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth().padding(end = 40.dp),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = AppTheme.colors.onSecondary
                )
            }
        },
        elevation = 0.dp
    )
}

