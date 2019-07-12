package com.aslisevil.minianketuygulamas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AnketSy1Activity extends AppCompatActivity {

    String[] cevaplar_ulke = {"İtalya", "Fransa", "Almanya", "Japonya"};
    String[] cevaplar_italya ={"Venedik", "Roma", "Floransa", "Milano"};
    String[] cevaplar_fransa = {"Paris", "Marsilya", "Nice", "Cannes"};
    String[] cevaplar_almanya = {"Berlin", "Münih", "Hamburg", "Köln"};
    String[] cevaplar_japonya = {"Tokyo", "Osaka", "Kyoto", "Yokohama"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anket_sy1);
        final TextView soru = (TextView)findViewById(R.id.soruTxt);
        final Intent i = new Intent(this, SonSayfa.class);

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cevaplar_ulke);
        final ArrayAdapter<String> italya_adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cevaplar_italya);
        final ArrayAdapter<String> almanya_adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cevaplar_almanya);
        final ArrayAdapter<String> fransa_adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cevaplar_fransa);
        final ArrayAdapter<String> japonya_adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cevaplar_japonya);

        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);

        SharedPreferences prefs = getSharedPreferences("ANKET", MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();

        //İLK SORUNUN ŞIKLARINA TIKLANIRSA:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                final String selected = listView.getItemAtPosition(position).toString();


                //İKİNCİ SORUNUN ŞIKLARINA TIKLANIRSA
                if(selected == "İtalya")
                {
                    listView.setAdapter(italya_adapter);
                    soru.setText("İtalya'nın hangi şehrini gezmek isterdiniz?");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> a, View v, int position,
                                                long id) {
                            String selected2 = listView.getItemAtPosition(position).toString();
                            editor.putString("deve",  selected+ " 'nın "+ selected2 + " şehrinde iyi eğlenceler!");
                            editor.commit();
                            startActivity(i);
                        }
                         });

                }
                else if(selected == "Almanya")
                {
                    listView.setAdapter(almanya_adapter);
                    soru.setText("Almanya'nın hangi şehrini gezmek isterdiniz?");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> a, View v, int position,
                                                long id) {
                            String selected2 = listView.getItemAtPosition(position).toString();
                            editor.putString("deve",  selected+ " 'nın "+ selected2 + " şehrinde iyi eğlenceler!");
                            editor.commit();
                            startActivity(i);
                        }
                    });
                }
                else if(selected == "Japonya")
                {
                    listView.setAdapter(japonya_adapter);
                    soru.setText("Japonya'nın hangi şehrini gezmek isterdiniz?");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> a, View v, int position,
                                                long id) {
                            String selected2 = listView.getItemAtPosition(position).toString();
                            editor.putString("deve",  selected+ " 'nın "+ selected2 + " şehrinde iyi eğlenceler!");
                            editor.commit();
                            startActivity(i);
                        }
                    });
                }
                else if(selected == "Fransa")
                {
                    listView.setAdapter(fransa_adapter);
                    soru.setText("Fransa'nın hangi şehrini gezmek isterdiniz?");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> a, View v, int position,
                                                long id) {
                            String selected2 = listView.getItemAtPosition(position).toString();
                            editor.putString("deve",  selected+ " 'nın "+ selected2 + " şehrinde iyi eğlenceler!");
                            editor.commit();
                            startActivity(i);
                        }
                    });
                }
            }
        });
    }
}
