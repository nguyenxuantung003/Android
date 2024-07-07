package com.example.android2.demo2;

public class Todo {
    private int id;
    private String titel;
    private String content;
    private String date;
    private String type;
    private int status;

    public Todo(int id, String titel, String content, String date, String type, int status) {
        this.id = id;
        this.titel = titel;
        this.content = content;
        this.date = date;
        this.type = type;
        this.status = status;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
