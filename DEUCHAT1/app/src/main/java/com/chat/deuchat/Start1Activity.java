package com.chat.deuchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Start1Activity extends AppCompatActivity {

    private Button user_start0;
    private Button user_start1;
    private Button user_start2;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start1);

        final String nickname;


        user_start0 = (Button) findViewById(R.id.user_start0);
        user_start1 = (Button) findViewById(R.id.user_start1);
        user_start2 = (Button) findViewById(R.id.user_start2);

        Intent intent = getIntent();
        nickname = intent.getStringExtra("nickname");

        user_start0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                intent.putExtra("chatName1", "동의대역 5번출구");
                intent.putExtra("nickname", nickname);
                startActivity(intent);
            }
        });
        user_start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                intent.putExtra("chatName1", "동의대역 7번출구");
                intent.putExtra("nickname", nickname);
                startActivity(intent);
            }
        });
        user_start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                intent.putExtra("chatName1", "가야 1치안");
                intent.putExtra("nickname", nickname);
                startActivity(intent);
            }
        });
        /*user_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_edit.getText().toString().equals("") || user_chat.getText().toString().equals(""))
                    return;

                Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                intent.putExtra("chatName", user_chat.getText().toString());
                intent.putExtra("userName", user_edit.getText().toString());
                startActivity(intent);
            }
        });*/
    }
}
