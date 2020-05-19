package com.example.notificationchannels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText title,message;
    private Button btn1,btn2;
    private NotificationHelper mNotificationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.txt_title);
        message=findViewById(R.id.txt_message);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        mNotificationHelper= new NotificationHelper(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendonChannel1(title.getText().toString(),message.getText().toString());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendonChannel2(title.getText().toString(),message.getText().toString());
            }
        });
    }
    public  void sendonChannel1(String title,String message){
        NotificationCompat.Builder nb= mNotificationHelper.getChannel1Notification(title,message);
        mNotificationHelper.getManager().notify(1,nb.build()); // this will push notification
    }


    public  void sendonChannel2(String title,String message){
        NotificationCompat.Builder nb= mNotificationHelper.getChannel2Notification(title,message);
        mNotificationHelper.getManager().notify(2,nb.build()); // this will push notification
    }
}
