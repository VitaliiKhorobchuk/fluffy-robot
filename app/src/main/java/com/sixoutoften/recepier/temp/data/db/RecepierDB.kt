package com.sixoutoften.recepier.temp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sixoutoften.recepier.temp.data.db.document.DocumentDao
import com.sixoutoften.recepier.temp.data.db.document.DocumentEntity

@Database(
    entities = [DocumentEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RecepierDB : RoomDatabase() {

    abstract fun documentDao(): DocumentDao

}