package com.khrystynahryb.recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String name[];
    private String adress[];
    private String description[];
    private int image[] = {R.drawable.pharmacy_a, R.drawable.pharmacy_b, R.drawable.pharmacy_c, R.drawable.pharmacy_d, R.drawable.pharmacy_e, R.drawable.pharmacy_f, R.drawable.pharmacy_g, R.drawable.pharmacy_h};
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRv();
        setAdapter();
    }

    private void initRv() {
        name = getResources().getStringArray(R.array.name_pharmacy);
        adress = getResources().getStringArray(R.array.adress_pharmacy);
        description = getResources().getStringArray(R.array.description_pharmacy);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void setAdapter() {
        AdapterPharmacy myAdapter = new AdapterPharmacy(this, name, adress, description, image);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
