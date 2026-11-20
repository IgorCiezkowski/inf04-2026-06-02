package com.example.inf0420260602;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText tytul, tresc;
    Button btn;
    ListView lista;
    List<String> items = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            tytul = findViewById(R.id.tytul);
            tresc = findViewById(R.id.tresc);
            lista = findViewById(R.id.lista);
            btn = findViewById(R.id.btn);

            items.add("tenis \nGra z Ewą w poniedziałek");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    items
            );

            lista.setAdapter(adapter);

            btn.setOnClickListener(view -> {
                items.add(tytul.getText().toString() + " \n" + tresc.getText().toString());
                lista.setAdapter(adapter);
            });

            return insets;
        });
    }
}