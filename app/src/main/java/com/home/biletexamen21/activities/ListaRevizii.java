package com.home.biletexamen21.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.home.biletexamen21.R;
import com.home.biletexamen21.RevizieAdaptor;
import com.home.biletexamen21.model.Revizie;

import java.util.ArrayList;
import java.util.List;

import static com.home.biletexamen21.activities.MainActivity.revizieList;

public class ListaRevizii extends AppCompatActivity {
    private ListView mListView;
    private RevizieAdaptor mRevizieAdaptor;

    private List<Revizie> listaFiltrata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_revizii);

        mListView = findViewById(R.id.listViewRevizii);

        listaFiltrata = revizieList;
        if (!revizieList.isEmpty()) {
            setAdaptor();
            attachSelectRevizieFromList();
        }



    }

    private void attachSelectRevizieFromList(){
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Revizie revizie = mRevizieAdaptor.getItem(position);

                Intent i = new Intent(ListaRevizii.this, AdaugaRevizieActivity.class);
                i.putExtra("revizia_selectata", revizie);
                i.putExtra("pozitie", position);
                startActivity(i);
                finish();
            }
        });
    }

    private void setAdaptor() {
        mRevizieAdaptor = new RevizieAdaptor(getApplicationContext(), R.layout.item_revizie);
        mRevizieAdaptor.addAll(listaFiltrata);
        mListView.setAdapter(mRevizieAdaptor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.toateMeniu:
                listaFiltrata = revizieList;
                setAdaptor();
                break;
            case R.id.normalaMeniu:
                listaFiltrata = new ArrayList<>();
                for(Revizie revizie : revizieList){
                    if(revizie.getTip().equals("normal")){
                        listaFiltrata.add(revizie);
                    }
                }
                setAdaptor();
                //mRevizieAdaptor.notifyDataSetChanged();
                break;
            case R.id.complexaMeniu:
                listaFiltrata = new ArrayList<>();
                for(Revizie revizie : revizieList){
                    if(revizie.getTip().equals("complex")){
                        listaFiltrata.add(revizie);
                    }
                }
                setAdaptor();
                //mRevizieAdaptor.notifyDataSetChanged();
                break;
            case R.id.medieMeniu:
                listaFiltrata = new ArrayList<>();
                for(Revizie revizie : revizieList){
                    if(revizie.getTip().equals("medie")){
                        listaFiltrata.add(revizie);
                    }
                }
                setAdaptor();
                //mRevizieAdaptor.notifyDataSetChanged();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}