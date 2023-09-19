package com.reyesmicaela.rickandmorty.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.reyesmicaela.rickandmorty.R
import com.reyesmicaela.rickandmorty.ui.components.ErrorScreen


@Composable
fun DetailScreen(modifier: Modifier = Modifier, viewModel: DetailViewModel = hiltViewModel()) {
    when (val state = viewModel.state) {
        DetailState.Error -> ErrorScreen(
            retryAction = { viewModel.getCharacterDetail(viewModel.characterId) },
            modifier = modifier.fillMaxSize()
        )

        DetailState.Loading -> Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }

        is DetailState.Success -> {
            state.character?.let {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ConstraintLayout {
                        val (image, asyncImage, text) = createRefs()
                        Image(
                            painter = painterResource(id = R.drawable.rick_and_morty_background),
                            contentDescription = null,
                            modifier = Modifier.constrainAs(image) {
                                top.linkTo(parent.top)
                            }
                        )
                        AsyncImage(
                            model = ImageRequest.Builder(context = LocalContext.current)
                                .data(state.character.image)
                                .crossfade(2000)
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .constrainAs(asyncImage) {
                                    start.linkTo(parent.start, margin = 16.dp)
                                    top.linkTo(image.bottom, margin = (-55).dp)
                                }
                                .size(100.dp)
                                .clip(CircleShape),
                            error = painterResource(id = R.drawable.ic_broken_image),
                            placeholder = painterResource(id = R.drawable.loading_img),
                        )

                        Text(
                            text = state.character.name,
                            modifier = modifier
                                .constrainAs(text) {
                                    top.linkTo(image.bottom)
                                    start.linkTo(asyncImage.end, margin = 4.dp)
                                    end.linkTo(image.end)
                                    width = Dimension.fillToConstraints
                                },
                            lineHeight = 1.em,
                            fontSize = 26.sp,
                        )
                    }
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Gender: ${state.character.gender}",
                            fontSize = 26.sp,
                            letterSpacing = 2.sp,

                            )
                        Text(
                            text = "Species: ${state.character.species}",
                            fontSize = 26.sp,
                            letterSpacing = 2.sp
                        )
                        Text(
                            text = "Status:${state.character.status}",
                            fontSize = 26.sp,
                            letterSpacing = 2.sp
                        )
                        Text(
                            text = "Origin: ${state.character.origin.name}",
                            fontSize = 26.sp,
                            letterSpacing = 2.sp
                        )
                        Text(
                            text = "Location: ${state.character.location.name}",
                            fontSize = 26.sp,
                            letterSpacing = 2.sp
                        )
                    }
                }
            }
        }
    }
}

