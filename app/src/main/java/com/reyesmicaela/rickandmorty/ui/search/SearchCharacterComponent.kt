package com.reyesmicaela.rickandmorty.ui.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.reyesmicaela.rickandmorty.model.Character
import com.reyesmicaela.rickandmorty.ui.components.CharacterListScreen
import com.reyesmicaela.rickandmorty.ui.components.ShimmerScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchCharacterComponent(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel(),
    onCharacterClick: (Character) -> Unit
) {

    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }
    val historyItems = rememberSaveable {
        mutableListOf<String>()
    }
    val focusManager = LocalFocusManager.current
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        query = if (active) {
            text
        } else {
            text = ""
            text
        },
        onQueryChange = {
            text = it
            viewModel.filterCharacterByName(text)
        },
        onSearch = {
            if (text.isNotEmpty()) {
                viewModel.filterCharacterByName(text)
                focusManager.clearFocus()
                historyItems.add(text)
            }
        },
        active = active,
        onActiveChange = {
            active = it
            if (!active) {
                focusManager.clearFocus()
            }
        },
        trailingIcon = {
            if (active) {
                IconButton(onClick = {
                    if (text.isNotEmpty()) {
                        text = ""
                    } else {
                        active = false
                        focusManager.clearFocus()
                    }
                }) {
                    Icon(Icons.Default.Close, contentDescription = null)
                }
            }
        }
    ) {
        if (text.isEmpty()) {
            historyItems.forEach { historyItem ->
                Row(modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
                    .clickable {
                        text = historyItem
                        focusManager.clearFocus()
                        viewModel.filterCharacterByName(historyItem)
                    }
                ) {
                    Icon(
                        modifier = Modifier.padding(end = 12.dp),
                        imageVector = Icons.Default.History, contentDescription = null
                    )
                    Text(
                        text = historyItem, modifier = Modifier
                    )
                }
            }
        } else {
            when (val state = viewModel.state) {
                SearchCharacterState.NotFound -> SearchErrorScreen(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(0.dp, 50.dp)
                )
                SearchCharacterState.Loading -> ShimmerScreen(count = 20)
                is SearchCharacterState.Success ->
                    CharacterListScreen(
                        characterList = state.characterList,
                        onCharacterClick = { character ->
                            onCharacterClick(character)
                        }
                    )
            }
        }
    }
}
