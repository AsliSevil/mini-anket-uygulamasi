package com.aslisevil.minianketuygulamas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class KayitOlActivity extends AppCompatActivity {

    //KayitBilgileri movie = (KayitBilgileri) getIntent().getParcelableExtra("users_name");
    //EditText textView;

    CheckBox sozlesmeCheck;
    EditText nametext;
    EditText pswTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);

        //TextView errorTxt = (TextView)findViewById(R.id.errorTxt);
        sozlesmeCheck = (CheckBox)findViewById(R.id.sozlesmeCheck);
        nametext = (EditText)findViewById(R.id.nameTxt);
        pswTxt = (EditText)findViewById(R.id.pswTxt);

        Button button = (Button) findViewById(R.id.kayitOlBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                String newUser = nametext.getText().toString();
                String password = pswTxt.getText().toString();
                SharedPreferences prefs = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(newUser+password+"data", "Merhaba " + newUser+" Hoşgeldin");
                editor.apply();
                // if(sozlesmeCheck.isSelected())
                {
                    Intent login = new Intent(KayitOlActivity.this,MainActivity.class);
                    startActivity(login);
                }
            }
        });
    }
}
