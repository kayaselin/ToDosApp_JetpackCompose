package com.example.todos.uix.views


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todos.data.entity.Notlar
import com.example.todos.uix.viewmodel.AnasayfaViewModel
import com.example.todos.uix.viewmodel.NotDetayViewModel
import com.example.todos.uix.viewmodel.NotKayitViewModel
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(anasayfaViewModel: AnasayfaViewModel,
                   notKayitViewModel: NotKayitViewModel,
                   notDetayViewModel: NotDetayViewModel
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            Anasayfa(navController,anasayfaViewModel)
        }
        composable("notKayitSayfa"){
            NotKayitSayfa(notKayitViewModel)
        }
        composable(
            "notDetaySayfa/{not}",
            arguments = listOf(
                navArgument("not") { type = NavType.StringType }
            )
        ){
            val json = it.arguments?.getString("not")
            val nesne = Gson().fromJson(json,Notlar::class.java)
            NotDetaySayfa(nesne,notDetayViewModel)
        }
    }
}