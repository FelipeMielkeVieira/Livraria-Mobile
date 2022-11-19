package com.example.aula11_11;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aula11_11.Entities.Livro;

public class DetalhesLivro extends AppCompatActivity {

    private Livro livro;
    public static Drawable imagemLivro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_livro);
        this.livro = (Livro) getIntent().getSerializableExtra("Livro");
        atualizarDetalhes();
    }

    private void atualizarDetalhes() {
        TextView tituloLivro = (TextView) findViewById(R.id.tituloDetalhesLivro);
        TextView editoraLivro = (TextView) findViewById(R.id.editoraDetalhesLivro);
        TextView anoLivro = (TextView) findViewById(R.id.anoDetalhesLivro);
        TextView sinopseLivro = (TextView) findViewById(R.id.sinopseDetalhesLivro);
        ImageView imageView = (ImageView) findViewById(R.id.imagemLivroDetalhes);
        tituloLivro.setText(livro.getNome());
        editoraLivro.setText(livro.getEditora());
        anoLivro.setText(livro.getAno());
        sinopseLivro.setText(livro.getSinopse());
        imageView.setImageDrawable(imagemLivro);
    }
}
