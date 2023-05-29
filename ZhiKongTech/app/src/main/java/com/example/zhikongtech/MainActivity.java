package com.example.zhikongtech;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonRegister;

    private String[] validUsernames = {"21009101835"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.edit_text_username);
        editTextPassword = findViewById(R.id.edit_text_password);
        buttonLogin = findViewById(R.id.button_login);
        buttonRegister = findViewById(R.id.button_register);
        mediaPlayer = MediaPlayer.create(this, R.raw.welcome);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (isValidUsername(username)) {
                    // 登录成功，跳转到 FunctionActivity
                    Intent intent = new Intent(MainActivity.this, functionActivity.class);
                    startActivity(intent);
                } else {
                    // 登录失败，显示提示
                    Toast.makeText(MainActivity.this, "用户名不存在", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取用户输入的用户名和密码
                String newUsername = editTextUsername.getText().toString();
                String newPassword = editTextPassword.getText().toString();

                // 将新用户名添加到有效用户名数组
                addValidUsername(newUsername);

                // 显示注册成功提示
                Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }
        });

        playSound();
    }

    private boolean isValidUsername(String username) {
        for (String validUsername : validUsernames) {
            if (validUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }

    private void playSound() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }


    private void addValidUsername(String username) {
        // 创建一个新的数组，长度比原数组多1
        String[] newValidUsernames = new String[validUsernames.length + 1];

        // 复制原数组的元素到新数组
        System.arraycopy(validUsernames, 0, newValidUsernames, 0, validUsernames.length);

        // 将新的用户名添加到新数组的末尾
        newValidUsernames[newValidUsernames.length - 1] = username;

        // 更新 validUsernames 引用，指向新数组
        validUsernames = newValidUsernames;
    }

}