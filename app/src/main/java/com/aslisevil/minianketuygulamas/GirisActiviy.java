package com.aslisevil.minianketuygulamas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GirisActiviy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_activiy);

        SharedPreferences prefs = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String display = prefs.getString("display", "");
        TextView info = (TextView)findViewById(R.id.messageTxt);
        info.setText(display);
    }
    public void AnketDoldurTikla(View v)
    {
        Intent intent = new Intent(this,AnketSy1Activity.class);
        startActivity(intent);
    }
}
