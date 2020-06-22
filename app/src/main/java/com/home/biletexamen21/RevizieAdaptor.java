package com.home.biletexamen21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.home.biletexamen21.model.Revizie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RevizieAdaptor extends ArrayAdapter<Revizie> {

    class TaburiRevizie {
        TextView tvNumarAuto, tvNumarKm, tvData, tvCost, tvTip;
    }

    //private List<Revizie> list = new ArrayList<>();

    public RevizieAdaptor(@NonNull Context context, int resource) {
        super(context, resource);
    }

 /*   @Override
    public void add(@Nullable Revizie revizie) {
        super.add(revizie);
        list.add(revizie);
    }*/

    /*@Override
    public void remove(@Nullable Revizie revizie) {
        super.remove(revizie);
        list.remove(revizie);
    }

    @Override
    public void addAll(@NonNull Collection collection) {
        super.addAll(collection);
        list.addAll(collection);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Nullable
    @Override
    public Revizie getItem(int position) {
        return list.get(position);
    }*/

    @NonNull
    @Override
    public View getView(int position, @Nullable View currentView, @NonNull ViewGroup parent) {
        View randulCurent = currentView;
        TaburiRevizie taburiRevizie;

        if (randulCurent == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            randulCurent = layoutInflater.inflate(R.layout.item_revizie, parent, false);

            taburiRevizie = new TaburiRevizie();
            taburiRevizie.tvNumarAuto = randulCurent.findViewById(R.id.numarAutoTv);
            taburiRevizie.tvNumarKm = randulCurent.findViewById(R.id.numarKmTv);
            taburiRevizie.tvData = randulCurent.findViewById(R.id.dataTv);
            taburiRevizie.tvCost = randulCurent.findViewById(R.id.costTv);
            taburiRevizie.tvTip = randulCurent.findViewById(R.id.tipTv);

            randulCurent.setTag(taburiRevizie);
        } else {
            taburiRevizie = (TaburiRevizie) randulCurent.getTag();
        }

        Revizie revizie = this.getItem(position);

        assert revizie != null;
        taburiRevizie.tvNumarAuto.setText(String.valueOf(revizie.getNumarAuto()));
        taburiRevizie.tvNumarKm.setText(String.valueOf(revizie.getNumarKm()));
        taburiRevizie.tvData.setText(revizie.getData());
        taburiRevizie.tvCost.setText(String.valueOf(revizie.getCost()));
        taburiRevizie.tvTip.setText(revizie.getTip());


        return randulCurent;
    }
}
