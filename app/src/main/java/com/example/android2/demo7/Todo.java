package com.example.android2.demo7;

import java.util.HashMap;

public class Todo {
    private String id,tittel,content;

    public Todo() {
    }

    public Todo(String id, String tittel, String content) {
        this.id = id;
        this.tittel = tittel;
        this.content = content;
    }

    public HashMap<String,Object> convertHashMap(){
        HashMap<String,Object> work = new HashMap<>();
        work.put("id",id);
        work.put("tittel",tittel);
        work.put("content",content);
        return work;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
