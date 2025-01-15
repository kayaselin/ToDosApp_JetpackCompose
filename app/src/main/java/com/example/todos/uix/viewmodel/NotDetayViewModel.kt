package com.example.todos.uix.viewmodel


import androidx.lifecycle.ViewModel
import com.example.todos.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotDetayViewModel @Inject constructor(var trepo: ToDoRepository) : ViewModel() {

    fun guncelle(not_id:Int,baslik:String,aciklama:String) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.guncelle(not_id, baslik, aciklama)
        }
    }
}