package com.example.todos.uix.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todos.data.entity.Notlar
import com.example.todos.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var trepo: ToDoRepository) : ViewModel() {
    var notlarListesi = MutableLiveData<List<Notlar>>()

    init {
        notlariYukle()
    }

    fun sil(not_id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.sil(not_id)
            notlariYukle()
        }
    }

    fun notlariYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            notlarListesi.value = trepo.notlariYukle()
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            notlarListesi.value = trepo.ara(aramaKelimesi)
        }
    }
}