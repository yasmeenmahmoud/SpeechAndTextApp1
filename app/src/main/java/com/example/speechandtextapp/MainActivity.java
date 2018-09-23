package com.example.speechandtextapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button speechtotext , texttospeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speechtotext=findViewById(R.id.speechtotext_btn);
        texttospeech=findViewById(R.id.texttospeech_btn);
        speechtotext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent speech=new Intent(MainActivity.this,SpeechToText.class);
                startActivity(speech);
            }
        });
        texttospeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent text=new Intent(MainActivity.this,textToSpeech.class);
                startActivity(text);
            }
        });

    }
}
