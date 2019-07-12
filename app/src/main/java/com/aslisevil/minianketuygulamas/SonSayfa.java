package com.aslisevil.minianketuygulamas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SonSayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son_sayfa);
        TextView message = (TextView)findViewById(R.id.messageTxt);

        SharedPreferences prefs = getSharedPreferences("ANKET",MODE_PRIVATE);
        String userDetail=prefs.getString("deve","");
        message.setText(userDetail);
    }
    public void girisSayfasiDon(View v)
    {
        Intent i = new Intent(this,GirisActiviy.class);
        startActivity(i);
    }
}
