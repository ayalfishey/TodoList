package com.ayal.todo.data.converters;
import com.ayal.todo.data.Progress;

import androidx.room.TypeConverter;


public class ProgressConverter {
    @TypeConverter
    public static int progressToInt(Progress progress){
        return progress.id;
    }
    @TypeConverter
    public static Progress intToProgress(int id){
        return Progress.getProgressById(id);
    }
}
