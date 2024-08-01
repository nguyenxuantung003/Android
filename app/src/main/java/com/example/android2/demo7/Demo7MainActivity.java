package com.example.android2.demo7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class Demo7MainActivity extends AppCompatActivity {
    FirebaseFirestore firestore;
    Button btninsert,btnupdate,btndelete;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo7_main);
        firestore = FirebaseFirestore.getInstance(); // khoi tao database
        textView = findViewById(R.id.demo71tv1);
        btninsert = findViewById(R.id.demo71btninsert);
        btnupdate = findViewById(R.id.demo71btnupdate);
        btndelete = findViewById(R.id.demo71btnxoa);
        slectedatafromFB(textView);
        btndelete.setOnClickListener(v -> {
            deleteFB(textView);
        });
        btnupdate.setOnClickListener(v -> {
            updateFB(textView);
        });
        btninsert.setOnClickListener(v -> {
            insertFB(textView);
        });
    }



    String id="";
    Todo todo = null;

    String strRe = "";
    public ArrayList<Todo> slectedatafromFB(TextView textView){
        ArrayList<Todo> list = new ArrayList<>();
        firestore.collection("Todo").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if(task.isSuccessful()){ // sau khi lay du lieu thanh cong
                            strRe = "";
                            // doc thep tung dong
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                // chuyen du lieu sang doi tuong
                                Todo todo1 = documentSnapshot.toObject(Todo.class);
                                list.add(todo1); // them vao list
                                strRe += "Id : " + todo1.getId() + "\n";
                                // chuyen list thanh chuoi
                            }
                            textView.setText(strRe);
                        }else {
                            textView.setText("Doc du lieu that bai");
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        textView.setText(e.getMessage());
                    }
                })
                ;
        return list;
    }

    public void deleteFB(TextView textView) {
        id = "11376b85-e6f4-45f0-bbac-4fe6bc059ff2";
        firestore.collection("Todo").document(id).delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        textView.setText("Xoa thanh cong");
                        Toast.makeText(Demo7MainActivity.this,"Xoa thanh cong",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        textView.setText("Xoa that bai");
                        Toast.makeText(Demo7MainActivity.this,"Xoa that bai",Toast.LENGTH_SHORT).show();
                    }
                })
        ;
    }

    public void insertFB(TextView textView){
        id = UUID.randomUUID().toString();
        // tao doi duoc de inert
        todo = new Todo(id,"tittel2","content2");
        // chuyen doi sang doi tuong co the tuong tac voi FB
        HashMap<String, Object> mapTodo = todo.convertHashMap();
        // insert vao database
        firestore.collection("Todo").document(id)
                .set(mapTodo)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        textView.setText("Them thanh cong");
                        Toast.makeText(Demo7MainActivity.this,"Them thanh cong",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        textView.setText("Them that bai");
                        Toast.makeText(Demo7MainActivity.this,"Them that bai",Toast.LENGTH_SHORT).show();
                    }
                })
                ; // doi tuong can insert



    }
    public  void updateFB(TextView textView){
        id = "7d98cdce-28ce-40e9-bf82-14451862ee1f";
        todo = new Todo(id,"sua tittel1","sua content1");
        firestore.collection("Todo").document(todo.getId()).update(todo.convertHashMap())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        textView.setText("Sua thanh cong");
                        Toast.makeText(Demo7MainActivity.this,"Sua thanh cong",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        textView.setText("Sua that bai");
                        Toast.makeText(Demo7MainActivity.this,"Sua that bai",Toast.LENGTH_SHORT).show();
                    }
                })
        ;

    }
}