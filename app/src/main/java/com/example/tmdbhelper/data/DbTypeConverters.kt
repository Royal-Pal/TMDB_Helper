package com.example.tmdbhelper.data

import androidx.room.TypeConverter
import java.util.*

class DbTypeConverters {

    @TypeConverter
    fun fromTimeStampToDate(value: Long?): Date? {
        return if (value == null) {
            null
        } else {
            Date(value)
        }
    }

    @TypeConverter
    fun fromDateToTimeStamp(date: Date?): Long? {
        return date?.time
    }
}