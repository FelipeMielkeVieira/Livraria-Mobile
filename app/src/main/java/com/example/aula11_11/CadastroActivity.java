package com.example.aula11_11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aula11_11.Entities.Livro;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrarImagem(View view) {
        Intent switchActivityIntent = new Intent(this, SelectImageActivity.class);
        startActivity(switchActivityIntent);
    }

    public void cadastrarLivro(View view) {
        String nomeLivro = ((EditText) findViewById(R.id.nomeLivroInput)).getText().toString();
        String sinopseLivro = ((EditText) findViewById(R.id.sinopseLivroInput)).getText().toString();
        String editoraLivro = ((EditText) findViewById(R.id.editoraLivroInput)).getText().toString();
        String anoLivro =  ((EditText) findViewById(R.id.anoLivroInput)).getText().toString();

        Livro livro = new Livro(MainActivity.listaLivros.size() + 1, nomeLivro, sinopseLivro, editoraLivro, anoLivro);
        MainActivity.listaLivros.add(livro);
        MainActivity.adapter.notifyDataSetChanged();

        finish();
    }
}
