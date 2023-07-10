package com.trivia.ui.screens.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trivia.R
import com.trivia.navigation.navigateToDifficultyScreen
import com.trivia.ui.composable.FillButton
import com.trivia.ui.composable.MainScaffold
import com.trivia.ui.composable.ScreenWithHeaderAndFooterImages
import com.trivia.ui.composable.SpacerVertical12
import com.trivia.ui.composable.TextHeader
import com.trivia.ui.screens.category.composable.composable.CategoryChoices
import com.trivia.ui.theme.radius_80
import com.trivia.ui.theme.space_48

@Composable
fun CategoryScreen(
    navController: NavHostController, viewModel: CategoryViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    fun navigateToDifficultyScreen() {
        navController.navigateToDifficultyScreen(state.selectedCategory)
    }
    CategoryContent(state, viewModel, ::navigateToDifficultyScreen)
}


@Composable
fun CategoryContent(
    state: CategoryUIState, viewModel: CategoryScreenInteractions, onNavigate: () -> Unit
) {
    MainScaffold(
        header = {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(radius = radius_80.dp),
                painter = painterResource(id = R.drawable.group_astrounat),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        },


        content = {
            ScreenWithHeaderAndFooterImages(
                header = painterResource(id = R.drawable.group_astrounat), footer = painterResource(
                    id = R.drawable.group_space
                )
            )

            Column(
                modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextHeader(stringResource(R.string.choose_the_game_category))

                SpacerVertical12()

                CategoryChoices(state, viewModel)

                FillButton(
                    state.isButtonNextVisible,
                    modifier = Modifier.padding(top = space_48),
                    text = stringResource(R.string.next),
                    onClick = onNavigate
                )
            }

        },


        footer = {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(radius = radius_80.dp),
                painter = painterResource(id = R.drawable.group_space),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        }

    )

}


@Preview
@Composable
fun CategoryScreenPreview() {
    CategoryScreen(rememberNavController())
}