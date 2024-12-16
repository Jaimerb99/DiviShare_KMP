package com.jrb.divishare.ui.screens.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.ic_home
import divishare_kmm.composeapp.generated.resources.ic_selected
import org.jetbrains.compose.resources.painterResource

object HomeTab : Tab{
    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(Res.drawable.ic_home)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Home",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}