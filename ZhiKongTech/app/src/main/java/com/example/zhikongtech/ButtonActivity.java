package com.example.zhikongtech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private Button mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        mBtn2 = findViewById(R.id.btn_2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this, "btn2被点击了",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showToast(View view) {
        Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show();
    }
}