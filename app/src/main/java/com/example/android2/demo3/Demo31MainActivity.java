package com.example.android2.demo3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android2.R;

public class Demo31MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4;
    Context context = this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo31_main);
        btn1 = findViewById(R.id.demo31btn1);
        btn2 = findViewById(R.id.demo31btn2);
        btn3 = findViewById(R.id.demo31btn3);
        btn4 = findViewById(R.id.demo31btn4);

        // alert
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1.1 tao builder
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                // 1.2 them cac thanh phan cho builder
                builder.setTitle("Thong bao");
                builder.setMessage("Noi dung can thong bao");
                // 1.3 them button ok , cancel
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Ban dong y",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Ban khong dong y",Toast.LENGTH_SHORT).show();
                    }
                });
                //1.4 tao dialog
                AlertDialog alertDialog = builder.create();
                //1.5 hien thi dialog
                alertDialog.show();
            }
        });

        // -------
        //single choie
        btn2.setOnClickListener(v -> {
            // 1 lay nguon du lieu
            String[] arr = {"Xanh","Do","Tim","Vang"};
            // 2 tao builder
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            // 3 tao cac thanh phan cho builder
            builder.setTitle("Tieu De");
            // 4 set single choie cho alert
            builder.setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Ban chon :" + arr[which],Toast.LENGTH_LONG ).show();
                }
            });
            // 5 tao dialog tu builder
            AlertDialog alertDialog = builder.create();
            // 6 hien thi builder
            alertDialog.show();
        });

        btn3.setOnClickListener(v -> {
            // 1 lay nguon du lieu
            String[] arr = {"Xanh","Do","Tim","Vang"};
            // 2 tao builder
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            // 3 tao cac thanh phan cho builder
            builder.setTitle("Tieu De");
            // 4 set single choie cho alert
            builder.setMultiChoiceItems(arr, null, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    Toast.makeText(getApplicationContext(),"Ban chon : " + arr[which],Toast.LENGTH_SHORT).show();
                }
            });
            // 5 tao dialog tu builder
            AlertDialog alertDialog = builder.create();
            // 6 hien thi builder
            alertDialog.show();
        });
        // dang nhap bang dialog
        btn4.setOnClickListener(v -> {
            // 1 tao builder
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            // 2 gan layout
            LayoutInflater inflater = getLayoutInflater();
            View view1 = inflater.inflate(R.layout.demo31_loginfrom,null);
            builder.setView(view1); // dua view vao builder
            // anh xa cac thanh phan
            final EditText txtUser = (EditText) view1.findViewById(R.id.demo31_loginform_txtU);
            final  EditText txtPass = (EditText) view1.findViewById(R.id.demo31_loginform_txtP);
            // them cac thanh phan khac cho form
            builder.setTitle("Login Form");
            builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Xin chao " + txtUser.getText().toString(),Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Ban chon Cancel",Toast.LENGTH_LONG).show();
                }
            });
            // 5 tao dialog tu builder
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }

}