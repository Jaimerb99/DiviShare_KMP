package com.jrb.divishare.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.jrb.divishare.ui.AppTheme
import com.jrb.divishare.ui.data.ItemBottomNav
import org.jetbrains.compose.resources.painterResource

@Composable
fun BottomBar(
    list: List<ItemBottomNav>,
    currentRoute: String?,
    onNavigate: () -> Unit){
    NavigationBar(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .padding(bottom = 5.dp)
            .background(Color.Transparent, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
        ,
        containerColor = AppTheme.colors.primaryVariant,
        contentColor = AppTheme.colors.onPrimary,
        tonalElevation = 0.dp
    ) {
        list.forEach { navigationItem ->
            NavigationBarItem(
                selected = navigationItem.route == currentRoute,
                onClick = onNavigate,
                icon = {
                    Icon(
                        painter = painterResource(navigationItem.icon),
                        contentDescription = navigationItem.title,
                        tint = AppTheme.colors.onPrimary
                    )
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AppTheme.colors.onPrimary,
                    indicatorColor = AppTheme.colors.primary,
                )
            )
        }
    }
}

@Composable
fun NavigationSideBar(
    items: List<ItemBottomNav>,
    currentRoute: String?,
    onItemClick: () -> Unit
) {
    NavigationRail(
        modifier = Modifier
            .padding(5.dp)
            .background(Color.Transparent, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
        ,
        containerColor = AppTheme.colors.primaryVariant,
        contentColor = AppTheme.colors.onPrimary
    ) {
        items.forEach { navigationItem ->
            NavigationRailItem(
                selected = navigationItem.route == currentRoute,
                onClick = onItemClick,
                icon = {
                    Icon(
                        painter = painterResource(navigationItem.icon),
                        contentDescription = navigationItem.title,
                        tint = AppTheme.colors.onPrimary
                    )
                },
                modifier = Modifier.padding(vertical = 12.dp).weight(1f),
                colors = NavigationRailItemColors(
                    selectedIconColor = AppTheme.colors.onPrimary,
                    selectedIndicatorColor = AppTheme.colors.primary,
                    selectedTextColor = AppTheme.colors.onPrimary,
                    unselectedIconColor = AppTheme.colors.onPrimary,
                    unselectedTextColor = AppTheme.colors.onPrimary,
                    disabledIconColor = AppTheme.colors.placeholder,
                    disabledTextColor = AppTheme.colors.placeholder,
                ),
                label = {
                    Text(
                        text = navigationItem.title,
                        style = if (navigationItem.route == currentRoute) MaterialTheme.typography.labelLarge
                        else MaterialTheme.typography.labelMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
            )
        }
    }
}



/*@Composable
fun BottomBar(list: List<ItemBottomNav>, onNavigate: () -> Unit){
    BottomAppBar(
        modifier = Modifier
            //.fillMaxWidth()
            .padding(horizontal = 5.dp)
            .padding(bottom = 5.dp)
            .clip(RoundedCornerShape(12.dp))
        ,
            //.background(AppTheme.colors.primary, RoundedCornerShape(12.dp)),
        contentColor = AppTheme.colors.onPrimary,
        elevation = 0.dp,
        backgroundColor = AppTheme.colors.primary,
        cutoutShape = RoundedCornerShape(12.dp),
    ) {
        list.forEach { item ->
            BottomNavigationItem(
                selected = item.route == "home",
                onClick = onNavigate,
                icon = {
                    Icon(painter = painterResource(item.icon) , contentDescription = item.title)
                },
                label = null,
                alwaysShowLabel = false,


            )
        }
    }
}*/

