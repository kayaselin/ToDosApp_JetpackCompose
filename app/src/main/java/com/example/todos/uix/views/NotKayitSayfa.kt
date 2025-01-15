package com.example.todos.uix.views


import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todos.uix.viewmodel.NotKayitViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotKayitSayfa(notKayitViewModel: NotKayitViewModel){
    val tfNotBaslik = remember { mutableStateOf("") }
    val tfNotAciklama = remember { mutableStateOf("") }

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Not Ekle") }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            TextField(
                value = tfNotBaslik.value,
                onValueChange = { tfNotBaslik.value = it },
                label = { Text(text = "Başlık") }
            )

            TextField(
                value = tfNotAciklama.value,
                onValueChange = { tfNotAciklama.value = it },
                label = { Text(text = "Açıklama") }
            )

            Button(
                modifier = Modifier.size(250.dp,50.dp),
                onClick = {
                    notKayitViewModel.kaydet(tfNotBaslik.value,tfNotAciklama.value)
                }) { Text(text = "KAYDET") }
        }
    }
}