package com.aslisevil.minianketuygulamas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    KayitBilgileri users = new KayitBilgileri();
    EditText textView;
    String newUser, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void girisYapTikla(View v)
    {
        textView = (EditText) findViewById(R.id.nicknameTxt);
        newUser = textView.getText().toString();
        textView = (EditText) findViewById(R.id.passwordTxt);
        password = textView.getText().toString();

        SharedPreferences prefs = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        String userDetail=prefs.getString(newUser+password+"data","Kullanıcı adı ya da şifre hatalı.");
        SharedPreferences.Editor editor=prefs.edit();
        editor.putString("display", userDetail);
        editor.apply();
        Intent displaylogin = new Intent(this,GirisActiviy.class);
        startActivity(displaylogin);
    }

    public void kayitOlTikla(View v)
    {
        Intent i = new Intent(this,KayitOlActivity.class);
        startActivity(i);
    }
}
