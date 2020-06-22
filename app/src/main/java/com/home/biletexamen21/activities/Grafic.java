package com.home.biletexamen21.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.home.biletexamen21.R;
import com.home.biletexamen21.model.Revizie;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static com.home.biletexamen21.activities.MainActivity.revizieList;

public class Grafic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafic);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        int sumNormal = 0;
        int sumMedie = 0;
        int sumComplex = 0;

        for (Revizie revizie : revizieList) {
            switch (revizie.getTip()) {
                case "normal":
                    sumNormal = sumNormal + revizie.getCost();
                    break;
                case "complex":
                    sumComplex = sumComplex + revizie.getCost();
                    break;
                case "medie":
                    sumMedie = sumMedie + revizie.getCost();
                    break;

            }

            BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[] {
                    new DataPoint(0, sumNormal),
                    new DataPoint(1, sumMedie),
                    new DataPoint(2, sumComplex)
            });
            graph.addSeries(series);
        }
    }
}