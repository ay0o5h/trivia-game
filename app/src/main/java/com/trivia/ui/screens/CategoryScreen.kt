package com.trivia.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.trivia.R
import com.trivia.ui.composable.ButtonNext
import com.trivia.ui.composable.PrimaryButton
import com.trivia.ui.theme.Typography
import com.trivia.ui.theme.White_87
import com.trivia.ui.theme.space_24
import com.trivia.viewmodel.CategoryScreenInteractions
import com.trivia.viewmodel.CategoryViewModel
import com.trivia.viewmodel.state.CategoryUIState

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    CategoryContent(state, viewModel)
}


@Composable
fun CategoryContent(state: CategoryUIState, viewModel: CategoryScreenInteractions) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .blur(40.dp),
            painter = painterResource(id = R.drawable.background),
            contentScale = ContentScale.FillBounds,
            contentDescription = "background image"
        )

        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(end = 20.dp, start = 20.dp, top = 100.dp),
                text = "Choose the game category",
                style = Typography.titleLarge,
                color = White_87
            )

            LazyColumn(
                modifier = Modifier.padding(top = space_24),
                contentPadding = PaddingValues(horizontal = 20.dp)
            ) {
                items(state.categories) {
                    PrimaryButton(text = it.title) {
                        viewModel.onSelectCategory(it.type)
                    }
                }
            }

            ButtonNext(
                state.isButtonNextVisible,
                modifier = Modifier.padding(top = 48.dp)
            )

        }


    }
}


@Preview
@Composable
fun CategoryScreenPreview() {
    CategoryScreen()
}