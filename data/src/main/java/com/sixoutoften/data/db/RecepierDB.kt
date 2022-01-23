package com.sixoutoften.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sixoutoften.data.db.document.DocumentDao
import com.sixoutoften.data.db.document.DocumentEntity

@Database(
    entities = [DocumentEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RecepierDB : RoomDatabase() {

    abstract fun documentDao(): DocumentDao

    companion object {

        fun build(appContext: Context): RecepierDB {
           return Room.databaseBuilder(
                appContext,
                RecepierDB::class.java,
                "Recepier_DB"
            ).build()
        }
    }

}