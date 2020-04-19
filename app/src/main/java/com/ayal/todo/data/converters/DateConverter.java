package com.ayal.todo.data.converters;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static long dateToLong(Date date){
        return date.getTime();
    }

    @TypeConverter
    public static Date longToDate(long longDate){
        return new Date(longDate);
    }
}
