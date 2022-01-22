package com.sixoutoften.recepier.temp.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {

    @TypeConverter
    fun fromString(value: String?): List<String?>? {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<String?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToStringMap(value: String): Map<String, String>? {
        return mapStringToAnyMap(value)
    }

    @TypeConverter
    fun stringMapToString(value: Map<String, String>?): String {
        return mapAnyMapToString(value)
    }

    @TypeConverter
    fun mapWithStringListToString(value: Map<String, List<String>>?): String {
        return mapAnyMapToString(value)
    }

    @TypeConverter
    fun stringToMapWithStringList(value: String): Map<String, List<String>>? {
        return mapStringToAnyMap(value)
    }

    private fun <K, V> mapStringToAnyMap(value: String): Map<K, V>? {
        return Gson().fromJson(value, object : TypeToken<Map<K, V>>() {}.type)
    }

    private fun <K, V> mapAnyMapToString(value: Map<K, V>?): String {
        return if (value == null) {
            ""
        } else {
            Gson().toJson(value)
        }
    }
}