package com.jrb.divishare.ui.data


import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.ic_calculator
import divishare_kmm.composeapp.generated.resources.ic_home
import divishare_kmm.composeapp.generated.resources.ic_settings_gear
import org.jetbrains.compose.resources.DrawableResource

sealed class ItemBottomNav(
    val route: String,
    val icon: DrawableResource,
    val title: String) {
    data object Home : ItemBottomNav("home", Res.drawable.ic_home,  "Home")
    data object Calculator : ItemBottomNav("calculator", Res.drawable.ic_calculator,  "Calculator")
    data object Settings : ItemBottomNav("settings", Res.drawable.ic_settings_gear,  "Settings")
}
