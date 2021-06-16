package com.chat.deuchat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StartActivity extends AppCompatActivity {

    //private EditText user_chat;
    private TextView user_start;
    //private Button user_next;
    private Button user_chat0;
    private Button user_chat1;
    private Button user_chat2;
    private Button user_chat3;
    private ListView chat_list;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final String nickname;
        final String startpoint;

        //user_chat = (EditText) findViewById(R.id.user_chat);

        user_start = (TextView) findViewById(R.id.user_start);
        //user_next = (Button) findViewById(R.id.user_next);
        user_chat0 = (Button) findViewById(R.id.user_chat0);
        user_chat1 = (Button) findViewById(R.id.user_chat1);
        user_chat2 = (Button) findViewById(R.id.user_chat2);
        user_chat3 = (Button) findViewById(R.id.user_chat3);
        chat_list = (ListView) findViewById(R.id.chat_list);

        Intent intent = getIntent();
        nickname = intent.getStringExtra("nickname");
        startpoint = intent.getStringExtra("chatName1");
        user_start.setText(startpoint);

        user_chat0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startpoint.equals("동의대역 5번출구")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "동의대역 5번출구 - 본관");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
                if(startpoint.equals("동의대역 7번출구")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "동의대역 7번출구 - 본관");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
                if(startpoint.equals("가야 1치안")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "가야 1치안 - 본관");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
            }
        });
        user_chat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startpoint.equals("동의대역 5번출구")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "동의대역 5번출구 - 자연대");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
                if(startpoint.equals("동의대역 7번출구")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "동의대역 7번출구 - 자연대");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
                if(startpoint.equals("가야 1치안")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "가야 1치안 - 자연대");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
            }
        });
        user_chat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startpoint.equals("동의대역 5번출구")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "동의대역 5번출구 - 공대");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
                if(startpoint.equals("동의대역 7번출구")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "동의대역 7번출구 - 공대");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
                if(startpoint.equals("가야 1치안")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "가야 1치안 - 공대");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
            }
        });
        user_chat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startpoint.equals("동의대역 5번출구")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "동의대역 5번출구 - 상경대");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
                if(startpoint.equals("동의대역 7번출구")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "동의대역 7번출구 - 상경대");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
                if(startpoint.equals("가야 1치안")){
                    Intent intent = new Intent(StartActivity.this, ChatActivity.class);
                    intent.putExtra("chatName", "가야 1치안 - 상경대");
                    intent.putExtra("userName", nickname);
                    startActivity(intent);
                }
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

        showChatList();

    }

    private void showChatList() {
        // 리스트 어댑터 생성 및 세팅
        final ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        chat_list.setAdapter(adapter);

        // 데이터 받아오기 및 어댑터 데이터 추가 및 삭제 등..리스너 관리
        databaseReference.child("chat").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.e("LOG", "dataSnapshot.getKey() : " + dataSnapshot.getKey());
                adapter.add(dataSnapshot.getKey());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}