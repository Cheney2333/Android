package com.example.zhikongtech;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private Button sendButton;
    private EditText commandEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.sendButton);
        commandEditText = findViewById(R.id.commandEditText);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String command = commandEditText.getText().toString();
                SendMessageTask sendMessageTask = new SendMessageTask();
                sendMessageTask.execute(command);
            }
        });

    }

    private class SendMessageTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            try {
                // 服务器的IP和端口号
                String serverIP = "8.140.26.4";
                int serverPort = 3389;

                // 创建Socket连接
                Socket socket = new Socket(serverIP, serverPort);

                // 获取输出流
                OutputStream outputStream = socket.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

                // 发送指令给服务器
                String message = params[0];
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                // 关闭连接
                bufferedWriter.close();
                outputStream.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}