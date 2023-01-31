package com.example.aula11_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.example.aula11_11.Adapters.LivroAdapter;
import com.example.aula11_11.Entities.Livro;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static RecyclerView recyclerView;
    public static LivroAdapter adapter;
    public static ArrayList<Livro> listaLivros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerView();
    }

    private void setRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.listaLivros);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new LivroAdapter(listaLivros, recyclerView, this);
        recyclerView.setAdapter(adapter);
    }

    public void cadastrar(View view) {
        Intent switchActivityIntent = new Intent(this, CadastroActivity.class);
        startActivity(switchActivityIntent);
    }

    public void detalhesLivro(Livro livro) {
        Intent switchActivityIntent = new Intent(this, DetalhesLivro.class);
        Livro livroNovo = new Livro(livro.getId(), livro.getNome(), livro.getSinopse(), livro.getEditora(), livro.getAno());
        DetalhesLivro.imagemLivro = livro.getImagem();
        switchActivityIntent.putExtra("Livro", livroNovo);
        startActivity(switchActivityIntent);
    }
}