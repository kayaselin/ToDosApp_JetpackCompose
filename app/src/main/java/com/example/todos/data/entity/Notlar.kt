package com.example.todos.data.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "notlar")
data class Notlar(@PrimaryKey(autoGenerate = true)
                  @ColumnInfo(name = "not_id") @NotNull var not_id:Int,
                  @ColumnInfo(name = "baslik") @NotNull var baslik:String,
                  @ColumnInfo(name = "aciklama") @NotNull var aciklama:String){
}