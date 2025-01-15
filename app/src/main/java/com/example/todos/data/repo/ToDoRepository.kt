package com.example.todos.data.repo


import com.example.todos.data.datasource.ToDoDataSource
import com.example.todos.data.entity.Notlar

class ToDoRepository(var tds:ToDoDataSource) {

    suspend fun kaydet(baslik:String,aciklama:String) = tds.kaydet(baslik, aciklama)

    suspend fun guncelle(not_id:Int,baslik:String,aciklama:String) = tds.guncelle(not_id, baslik, aciklama)

    suspend fun sil(not_id:Int) = tds.sil(not_id)

    suspend fun notlariYukle() : List<Notlar> = tds.notlariYukle()

    suspend fun ara(aramaKelimesi:String) : List<Notlar> = tds.ara(aramaKelimesi)
}