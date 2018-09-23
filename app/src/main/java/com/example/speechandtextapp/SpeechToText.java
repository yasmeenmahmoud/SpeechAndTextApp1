package com.example.speechandtextapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class SpeechToText extends AppCompatActivity {
TextView textspeechinput;
    ImageView intermic;
    private  final int REQ_CODE_SPEECH_INPUT=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);
        textspeechinput=findViewById(R.id.txtspeechinput);
        intermic=findViewById(R.id.mic_img);
        intermic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "say something");
                try {
                    startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
                }catch (ActivityNotFoundException a)
                {
                    Toast.makeText(getApplicationContext(),"sorry!your device doest suport",Toast.LENGTH_LONG).show();}
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQ_CODE_SPEECH_INPUT:
            {if (requestCode==RESULT_OK &&null!=data);
                ArrayList<String>result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
           textspeechinput.setText(result.get(0));}
break;
        }
    }
}
