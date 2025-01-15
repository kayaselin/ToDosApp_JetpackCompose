package com.example.todos.data.datasource

import android.util.Log
import com.example.todos.data.entity.Notlar
import com.example.todos.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var tdao : ToDoDao) {
    suspend fun kaydet(baslik:String,aciklama:String){
        val yeninot = Notlar(0,baslik,aciklama)
        tdao.kaydet(yeninot)
    }

    suspend fun guncelle(not_id:Int,baslik:String,aciklama:String){
        val guncelleneNot = Notlar(not_id,baslik,aciklama)
        tdao.guncelle(guncelleneNot)
    }

    suspend fun sil(not_id:Int){
        val silinenNot = Notlar(not_id,"","")
        tdao.sil(silinenNot)
    }

    suspend fun notlariYukle() : List<Notlar> = withContext(Dispatchers.IO){

        return@withContext tdao.notlariYukle()
    }

    suspend fun ara(aramaKelimesi:String) : List<Notlar> = withContext(Dispatchers.IO){

        return@withContext tdao.ara(aramaKelimesi)
    }

}