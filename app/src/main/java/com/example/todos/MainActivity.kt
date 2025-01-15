package com.example.todos


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.todos.ui.theme.ToDosTheme
import com.example.todos.uix.viewmodel.AnasayfaViewModel
import com.example.todos.uix.viewmodel.NotDetayViewModel
import com.example.todos.uix.viewmodel.NotKayitViewModel
import com.example.todos.uix.views.SayfaGecisleri
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val anasayfaViewModel:AnasayfaViewModel by viewModels()
    val notKayitViewModel: NotKayitViewModel by viewModels()
    val notDetayViewModel: NotDetayViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDosTheme {
                SayfaGecisleri(anasayfaViewModel,notKayitViewModel,notDetayViewModel)
            }
        }
    }
}
