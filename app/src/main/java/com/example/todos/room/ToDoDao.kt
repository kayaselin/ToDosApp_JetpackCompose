package com.example.todos.room


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todos.data.entity.Notlar

@Dao
interface ToDoDao { //Database Access Object

    @Query("SELECT * FROM notlar")
    suspend fun notlariYukle() : List<Notlar>

    @Insert
    suspend fun kaydet(kisi:Notlar)

    @Update
    suspend fun guncelle(kisi: Notlar)

    @Delete
    suspend fun sil(kisi: Notlar)

    @Query("SELECT * FROM notlar WHERE baslik like '%' || :aramaKelimesi ||  '%'")
    suspend fun ara(aramaKelimesi: String) : List<Notlar>

}