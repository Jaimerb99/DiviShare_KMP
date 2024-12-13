package com.jrb.divishare.ui.screens.access

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrb.divishare.ui.AppTheme
import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.onboarding1
import divishare_kmm.composeapp.generated.resources.onboarding2
import divishare_kmm.composeapp.generated.resources.onboarding3
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

data class OnboardingContent(
    val image: DrawableResource,
    val title: String,
    val description: String
)

@Composable
fun OnboardingScreen(
    onNavigateToLogin: () -> Unit
){

    val scope = rememberCoroutineScope()

    val onboardingScreens = listOf(
        OnboardingContent(
            image = Res.drawable.onboarding1,
            title = "Save money",
            description = "Save time and money by clearly showing how much each person owes"
        ),
        OnboardingContent(
            image = Res.drawable.onboarding2,
            title = "Meet your contacts",
            description = "Easily share expenses with your contacts for any situation"
        ),
        OnboardingContent(
            image = Res.drawable.onboarding3,
            title = "Share your expenses ",
            description = "Effortlessly split payments with others"
        )
    )

    val pagerState = rememberPagerState{ onboardingScreens.size }

    Scaffold(
        modifier = Modifier.padding(
            WindowInsets.systemBars.asPaddingValues()
        ).background(color = AppTheme.colors.background),
        topBar = {
            TopAppBar(
                title = {},
                backgroundColor = AppTheme.colors.background,
                elevation = 0.dp,
                actions = {
                    TextButton(
                        onClick = onNavigateToLogin,
                        colors = ButtonDefaults.buttonColors(contentColor  = AppTheme.colors.onSecondary, backgroundColor = Color.Transparent)
                    ){
                        Text(
                            "Skip",
                            style = MaterialTheme.typography.body2.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            )
        },
        bottomBar = {
            OnboardingScreenBottomBar(
                pagerState = pagerState,
                onNext = {
                    scope.launch {
                        if (pagerState.currentPage == 2){
                            onNavigateToLogin()
                            return@launch
                        }
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                },
                onBack = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(
                        //horizontal = 24.dp,
                        vertical = 30.dp
                    )
            ){index ->
                val content = onboardingScreens[index]
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        Image(
                            painter = painterResource(resource = content.image),
                            contentDescription = "Onboarding Image",
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop,
                        )

                        /*Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                                .padding(horizontal = 10.dp)
                                .background(
                                    color = Color(0xFFA8E6CF),
                                    shape = RoundedCornerShape(12.dp)
                                )
                        ){
                            *//*Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(10.dp)
                                    //.padding(start = 20.dp)
                                    .background(
                                        color = Color.White,
                                        shape = RoundedCornerShape(bottomStart = 360.dp)
                                    )
                            )*//*
                        }*/
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        content.title,
                        color = AppTheme.colors.primary,
                        style = MaterialTheme.typography.h5.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        content.description,
                        style = MaterialTheme.typography.body2.copy(
                            color = MaterialTheme.colors.onBackground.copy(
                                alpha = 0.6f
                            )
                        ),
                        modifier = Modifier.padding(horizontal = 40.dp),
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }
}

@Composable
fun OnboardingScreenPagerIndicator(
    modifier: Modifier = Modifier,
    pageCount: Int,
    currentPage: Int
){
    Row(
        modifier = modifier
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        (0..<pageCount).forEach {
            Box(
                modifier = Modifier
                    .width(if (currentPage == it) 24.dp else 12.dp)
                    .height(6.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        color = if (it == currentPage) AppTheme.colors.primary else AppTheme.colors.primaryVariant
                    )
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}


@Composable
fun OnboardingScreenBottomBar(
    modifier: Modifier = Modifier,
    onNext: () -> Unit,
    onBack: () -> Unit,
    pagerState: PagerState
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 10.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        /*if (pagerState.currentPage != 0){
            TextButton(
                onClick = onBack
            ){
                Text(
                    "Back",
                    style = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.primary.copy(
                            alpha = 0.6f
                        ),
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }*/
        Spacer(modifier = Modifier.width(20.dp))
        OnboardingScreenPagerIndicator(
            modifier = Modifier.weight(1f),
            pageCount = pagerState.pageCount,
            currentPage = pagerState.currentPage
        )
        Button(
            onClick = onNext,
            modifier = Modifier.width(180.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.primary, contentColor = AppTheme.colors.onPrimary)

        ){
            Text(
                if (pagerState.currentPage == 2) "Get started" else "Next",
                style = MaterialTheme.typography.button.copy(
                    fontWeight = FontWeight.Bold
                ),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}
