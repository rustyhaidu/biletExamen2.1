package com.home.biletexamen21.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.home.biletexamen21.R;
import com.home.biletexamen21.model.Revizie;

import static com.home.biletexamen21.activities.MainActivity.revizieList;

public class AdaugaRevizieActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner tip;
    private EditText numarKm;
    private EditText numarAuto;
    private EditText data;
    private EditText cost;
    private Button adaugaRevizieLaLista;
    private Button stergeRevizieLaLista;
    private Button meniuPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_revizie);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        tip = findViewById(R.id.tipSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipValori, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        tip.setAdapter(adapter);
        tip.setOnItemSelectedListener(this);

        numarAuto = findViewById(R.id.numarAutoEdt);
        numarKm = findViewById(R.id.numarKmEdt);
        data = findViewById(R.id.dataEdt);
        cost = findViewById(R.id.costEdt);

        Revizie revizie = (Revizie) getIntent().getSerializableExtra("revizia_selectata");

        adaugaRevizieLaLista = findViewById(R.id.adaugaLaListaRevizii);
        if (revizie != null) {
            numarAuto.setText(String.valueOf(revizie.getNumarAuto()));
            numarKm.setText(String.valueOf(revizie.getNumarKm()));
            data.setText(revizie.getData());
            cost.setText(String.valueOf(revizie.getCost()));

            if (revizie.getTip() != null) {
                int spinnerPosition = adapter.getPosition(revizie.getTip());
                tip.setSelection(spinnerPosition);
            }

            adaugaRevizieLaLista.setText("Editare Revizie");
            adaugaRevizieLaLista.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Revizie revizieCurenta = getRevizieFromViews();
                    int pozitiaSelectata = getIntent().getIntExtra("pozitie", 0);

                    revizieList.set(pozitiaSelectata, revizieCurenta);
                    Toast.makeText(AdaugaRevizieActivity.this, "Revizie modificata", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            adaugaRevizieLaLista.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Revizie revizie = getRevizieFromViews();

                    revizieList.add(revizie);

                    Intent i = new Intent(AdaugaRevizieActivity.this, ListaRevizii.class);
                    startActivity(i);
                    finish();
                }
            });
        }

        stergeRevizieLaLista = findViewById(R.id.stergeRevizie);
        stergeRevizieLaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Revizie revizieDePeViewuri = getRevizieFromViews();

                revizieDePeViewuri.setNumarAuto(Integer.parseInt(numarAuto.getText().toString()));
                for (Revizie revizieCurenta : revizieList) {
                    if (revizieDePeViewuri.equals(revizieCurenta)) {
                        revizieList.remove(revizieCurenta);
                        Toast.makeText(AdaugaRevizieActivity.this, "Revizia a fost stearsa", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        meniuPrincipal = findViewById(R.id.meniuPrincipalBtn);
        meniuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdaugaRevizieActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    private Revizie getRevizieFromViews() {
        Revizie revizie = new Revizie();
        revizie.setNumarAuto(Integer.parseInt(numarAuto.getText().toString()));
        revizie.setNumarKm(Integer.parseInt(numarKm.getText().toString()));
        revizie.setData(data.getText().toString());
        revizie.setCost(Integer.parseInt(cost.getText().toString()));
        revizie.setTip(tip.getSelectedItem().toString());
        return revizie;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getApplicationContext(), tip.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(getApplicationContext(), "Nothing selected", Toast.LENGTH_LONG).show();
    }
}