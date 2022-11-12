package com.example.aula11_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aula11_11.Adapters.LivroAdapter;
import com.example.aula11_11.Entities.Livro;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    public static LivroAdapter adapter;
    public static ArrayList<Livro> listaLivros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaLivros.add(new Livro(1, "O livro", "Livro Bom", "A", "2020"));
        setRecyclerView();
    }

    private void setRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.listaLivros);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new LivroAdapter(listaLivros);
        recyclerView.setAdapter(adapter);
    }

    public void cadastrar(View view) {
        Intent switchActivityIntent = new Intent(this, CadastroActivity.class);
        startActivity(switchActivityIntent);
    }
}