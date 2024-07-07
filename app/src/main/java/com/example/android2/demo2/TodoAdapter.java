package com.example.android2.demo2;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android2.R;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private List<Todo> todoList;
    private OnItemClickListener listener;
    public interface OnItemClickListener {
        void onDeleteClick(int position);
        void onEditClick(int position);
        void onStatusChange(int position,boolean isDone);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    public TodoAdapter(List<Todo> todoList){
        this.todoList = todoList;
    }
    @NonNull
    @Override
    public TodoAdapter.TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // anh xa 1 view voi itemview
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.demo21_item_view,parent,false);
        return new TodoViewHolder(view,listener);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.TodoViewHolder holder, int position) {
        Todo currentTodo = todoList.get(position); // lay ve vij tri hien tai
        holder.tvTodoname.setText("Titel :" + currentTodo.getTitel()); // dien du lieu vao titel
        holder.tvTodoContent.setText("Content :" + currentTodo.getContent());
        holder.tvTodoDate.setText("Date :" + currentTodo.getDate());
        holder.tvTodotype.setText("Type :" +currentTodo.getType());
        holder.checkBox.setChecked(currentTodo.getStatus()==1);// dien du lieu vao checkbox
        // su ly su kien checkbox
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(listener != null){
                    listener.onStatusChange(position,isChecked);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
    public static class TodoViewHolder extends RecyclerView.ViewHolder{
        TextView tvTodoname,tvTodoContent,tvTodoDate,tvTodotype;
        CheckBox checkBox;
        Button btnEdit,btnDelete;

        public TodoViewHolder(@NonNull View itemView,final OnItemClickListener listener) {
            super(itemView);
            // anh xa
            tvTodoname = itemView.findViewById(R.id.demo21_item_tvToDoName);
            tvTodoContent = itemView.findViewById(R.id.demo21_item_tvToDoContent);
            tvTodoDate = itemView.findViewById(R.id.demo21_item_tvTodoDate);
            tvTodotype = itemView.findViewById(R.id.demo21_item_tvToDoType);
            btnEdit = itemView.findViewById(R.id.demo21_item_btnEdit);
            btnDelete = itemView.findViewById(R.id.demo21_item_btnDelete);
            checkBox = itemView.findViewById(R.id.demo21_item_checkbox);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int pos = getAdapterPosition(); // lay ve vi tri can xoa
                        if(pos != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(pos);
                        }
                    }
                }
            });
            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            listener.onEditClick(pos);
                        }
                    }
                }
            });

        }
    }

}
