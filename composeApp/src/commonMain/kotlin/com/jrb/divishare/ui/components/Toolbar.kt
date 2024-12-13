package com.jrb.divishare.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.unit.dp
import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.ic_add_project
import divishare_kmm.composeapp.generated.resources.ic_contacts
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
    Row {
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