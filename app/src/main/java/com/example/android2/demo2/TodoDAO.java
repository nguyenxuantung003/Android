package com.example.android2.demo2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
    private SQLiteDatabase db;
    public TodoDAO(Context context){
        TodoDatabaseHelper dbHelper = new TodoDatabaseHelper(context); // goi ham tao csdl
        db = dbHelper.getWritableDatabase(); // gi data vao db
    }
    public long addTodo(Todo todo){
        ContentValues values = new ContentValues();
        values.put("titel",todo.getTitel());
        values.put("content",todo.getContent());
        values.put("date",todo.getDate());
        values.put("type",todo.getType());
        values.put("status",todo.getStatus());
        // insert data
        return db.insert("todos",null,values);
    }

    public List<Todo> getAllTodo(){
        List<Todo> todos = new ArrayList<>();
        Cursor cursor = db.query("todos",null,null,null,null,null,"id ASC");
        if (cursor.moveToFirst()){
            do {
                @SuppressLint("Range")
                 Todo todo = new Todo(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("titel")),
                        cursor.getString(cursor.getColumnIndex("content")),
                        cursor.getString(cursor.getColumnIndex("date")),
                        cursor.getString(cursor.getColumnIndex("type")),
                        cursor.getInt(cursor.getColumnIndex("status"))
                );
                todos.add(todo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return todos;
    }
    public void updateTodoStatus(int id , int status){
        ContentValues values = new ContentValues();
        values.put("status",status);
        db.update("todos",values,"id=?",new String[]{String.valueOf(id)});
    }
    public void updateTodo(Todo todo){
        ContentValues values = new ContentValues();
        values.put("titel",todo.getTitel());
        values.put("content",todo.getContent());
        values.put("date",todo.getDate());
        values.put("type",todo.getType());
        values.put("status",todo.getStatus());
        db.update("todos",values,"id=?",new String[]{String.valueOf(todo.getId())});
    }
    public void deleteTodo(int id){
        db.delete("todos","id=?",new String[]{String.valueOf(id)});
    }
}
