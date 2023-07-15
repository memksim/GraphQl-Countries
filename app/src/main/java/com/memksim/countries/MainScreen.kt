package com.memksim.countries

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val countries = mutableListOf<Any>()
    Scaffold() {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {

        }
    }
}

@Composable
@Preview
private fun MainScreenPreview() {
    MainScreen()
}