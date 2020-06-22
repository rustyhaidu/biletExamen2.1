package com.home.biletexamen21.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.home.biletexamen21.R;
import com.home.biletexamen21.model.Revizie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button adaugaRevizie;
    private Button listaRevizii;
    private Button sincronizareRetea;
    private Button grafic;

    public static List<Revizie> revizieList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Toast.makeText(this, "Rares Dobrot: " + dtf.format(now), Toast.LENGTH_LONG).show();

        adaugaRevizie = findViewById(R.id.adaugaRevizieBtn);
        adaugaRevizie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AdaugaRevizieActivity.class);
                startActivity(i);
            }
        });

        listaRevizii = findViewById(R.id.listaReviziiBtn);
        listaRevizii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListaRevizii.class);
                startActivity(i);
            }
        });

        grafic = findViewById(R.id.graficBtn);
        grafic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (revizieList.isEmpty()) {
                    Toast.makeText(MainActivity.this, "No Graph to Show", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent i = new Intent(MainActivity.this, Grafic.class);
                startActivity(i);
            }
        });

    }
}