package com.reyesmicaela.rickandmorty.ui.components


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.reyesmicaela.rickandmorty.R
import com.reyesmicaela.rickandmorty.model.Character

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    character: Character,
    onCharacterClick: (Character) -> Unit
) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        onClick = {onCharacterClick(character)}
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(character.image)
                .crossfade(2000)
                .build(),
            contentDescription = null,
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(id = R.drawable.loading_img),
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )
        Text(
            text = character.name,
            modifier = modifier.padding(horizontal = 8.dp), lineHeight = 1.em, fontSize = 26.sp
        )
    }
}

