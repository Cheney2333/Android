package com.example.zhikongtech;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button managementModeBtn;
    private MediaPlayer mediaPlayer;
    private Button languageButton;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonRegister;

    private String[] validUsernames = {"21009101835", "21009102230", "21009100608", "2004920085", "21009101512", "21009101685"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.edit_text_username);
        editTextPassword = findViewById(R.id.edit_text_password);
        buttonLogin = findViewById(R.id.button_login);
        buttonRegister = findViewById(R.id.button_register);
        managementModeBtn = findViewById(R.id.button_manage);
        mediaPlayer = MediaPlayer.create(this, R.raw.welcome2);

        languageButton = findViewById(R.id.languageButton);
        languageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchLanguage();
            }
        });

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

        managementModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String admin = editTextUsername.getText().toString();

                if (admin.equals("admin")) {
                    // 登录成功，跳出弹窗
                    showAlertDialog();
                } else {
                    // 登录失败，显示提示
                    Toast.makeText(MainActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
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

    private void showAlertDialog() {
        // 创建弹窗
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // 创建 ImageView 对象并设置图片资源
        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setImageResource(R.drawable.deviceqrcode); // 设置图片资源

        // 添加 ImageView 到弹窗布局
        builder.setView(imageView);

        // 设置弹窗的标题和消息
        builder.setTitle("管理模式使用说明");
        builder.setMessage("请使用腾讯连连小程序扫描二维码添加本设备，之后在手机上进行操作");

        // 设置弹窗的按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 点击确定按钮后的操作
                // 关闭弹窗
                dialog.dismiss();
            }
        });

        // 显示弹窗
        AlertDialog dialog = builder.create();
        dialog.show();
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

    // 创建一个方法来切换语言
    private void switchLanguage() {
        Locale currentLocale = getResources().getConfiguration().locale;
        Locale newLocale;
        if (currentLocale.getLanguage().equals("zh")) {
            newLocale = Locale.ENGLISH;
        } else {
            newLocale = Locale.CHINESE;
        }

        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(newLocale);
        resources.updateConfiguration(configuration, displayMetrics);

        // 重新启动 MainActivity 以应用新的语言设置
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}