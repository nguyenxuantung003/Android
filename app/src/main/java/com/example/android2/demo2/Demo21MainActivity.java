package com.example.android2.demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Handler;
import android.os.Looper;

import com.example.android2.R;

import java.util.List;

public class Demo21MainActivity extends AppCompatActivity {
    private EditText txtTitel,txtContent,txtDate,txtType;
    private Button btnAdd;
    private RecyclerView recyclerView;
    private TodoAdapter adapter;
    private TodoDAO todoDAO;
    private List<Todo> todoList;
    // vi tri hien tai
    private Todo currentEditingTodo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo21_main);
        txtTitel = findViewById(R.id.demo21txtTitel);
        txtContent = findViewById(R.id.demo21txtContent);
        txtDate = findViewById(R.id.demo21txtDate);
        txtType = findViewById(R.id.demo21txtType);
        btnAdd = findViewById(R.id.demo21btnAdd);
        recyclerView = findViewById(R.id.demo21RecyclerView);

        todoDAO = new TodoDAO(this);
        todoList = todoDAO.getAllTodo();
        adapter = new TodoAdapter(todoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(Demo21MainActivity.this));
        recyclerView.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentEditingTodo == null) {
                    addTodo();
                } else {
                    updateTodo();
                }
            }
        });
        adapter.setOnItemClickListener(
                new TodoAdapter.OnItemClickListener() {
                    @Override
                    public void onDeleteClick(int position) {
                        deleteTodo(position);
                    }

                    @Override
                    public void onEditClick(int position) {
                        editTodo(position);
                    }

                    @Override
                    public void onStatusChange(int position, boolean isDone) {
                        updateTodoStatus(position, isDone);
                    }
                });
    }
    private void clearFields() {
        txtTitel.setText("");
        txtContent.setText("");
        txtDate.setText("");
        txtType.setText("");
    }
    private void addTodo() {
        String title = txtTitel.getText().toString();
        String content = txtContent.getText().toString();
        String date = txtDate.getText().toString();
        String type = txtDate.getText().toString();

        Todo todo = new Todo(0, title, content, date,
                type, 0);
        todoDAO.addTodo(todo);
        todoList.add(0, todo);
        adapter.notifyItemInserted(0);
        recyclerView.scrollToPosition(0);
        clearFields();
    }
    private void updateTodo() {
        String title = txtTitel.getText().toString();
        String content = txtContent.getText().toString();
        String date = txtDate.getText().toString();
        String type = txtType.getText().toString();
        currentEditingTodo.setTitel(title);
        currentEditingTodo.setContent(content);
        currentEditingTodo.setDate(date);
        currentEditingTodo.setType(type);
        todoDAO.updateTodo(currentEditingTodo);
        int position = todoList.indexOf(currentEditingTodo);
        adapter.notifyItemChanged(position);

        currentEditingTodo = null; // Reset biến theo dõi
        btnAdd.setText("Add"); // Đổi text button thành Add
        clearFields();
    }
    private void editTodo(int position) {
        currentEditingTodo = todoList.get(position);

        txtTitel.setText(currentEditingTodo.getTitel());
        txtContent.setText(currentEditingTodo.getContent());
        txtDate.setText(currentEditingTodo.getDate());
        txtType.setText(currentEditingTodo.getType());

        btnAdd.setText("Update"); // Đổi text button thành Update
    }
    private void deleteTodo(int position) {
        Todo todo = todoList.get(position);
        todoDAO.deleteTodo(todo.getId());
        todoList.remove(position);
        adapter.notifyItemRemoved(position);
    }
    private void updateTodoStatus(int position, boolean isDone) {
        Todo todo = todoList.get(position);
        todo.setStatus(isDone ? 1 : 0);
        todoDAO.updateTodoStatus(todo.getId(), todo.getStatus());
        // Sử dụng Handler để thực hiện notifyItemChanged bên ngoài vòng đời của RecyclerView
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                adapter.notifyItemChanged(position);
            }
        });
        //adapter.notifyItemChanged(position);
        Toast.makeText(this, "Đã update status thành công", Toast.LENGTH_SHORT).show();
    }
}