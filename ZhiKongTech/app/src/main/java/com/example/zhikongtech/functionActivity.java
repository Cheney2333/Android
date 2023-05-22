package com.example.zhikongtech;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class functionActivity extends AppCompatActivity {

    private BluetoothSocket bluetoothSocket;
    private BluetoothDevice bluetoothDevice;
    private Button connectButton;
    private Button sendButton;

    // Replace with your HC-05 device's UUID
    private static final UUID DEVICE_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        connectButton = findViewById(R.id.connectButton);
        sendButton = findViewById(R.id.sendButton);

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        String deviceAddress = getIntent().getStringExtra("98:D3:02:96:AB:53");
        bluetoothDevice = bluetoothAdapter.getRemoteDevice(deviceAddress);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectToDevice();
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData("Your command");
            }
        });
    }

    private void connectToDevice() {
        try {
            bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(DEVICE_UUID);
            bluetoothSocket.connect();
            Toast.makeText(this, "Connected to device", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendData(String data) {
        if (bluetoothSocket != null && bluetoothSocket.isConnected()) {
            try {
                OutputStream outputStream = bluetoothSocket.getOutputStream();
                outputStream.write(data.getBytes());
                Toast.makeText(this, "Data sent", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Not connected to a device", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bluetoothSocket != null) {
            try {
                bluetoothSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

