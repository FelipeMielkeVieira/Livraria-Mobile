package com.example.aula11_11;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SelectImageActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imagemSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_foto);

        this.imagemSelecionada = findViewById(R.id.imagemSelecionada);
        findViewById(R.id.imagem1).setOnClickListener(this);
        findViewById(R.id.imagem2).setOnClickListener(this);
        findViewById(R.id.imagem3).setOnClickListener(this);
        findViewById(R.id.imagem4).setOnClickListener(this);
    }

    public void salvarImagem(View view) {
        CadastroActivity.imagemLivro = imagemSelecionada.getDrawable();
        finish();
    }

    @Override
    public void onClick(View v) {
        imagemSelecionada.setImageDrawable(((ImageView) v).getDrawable());
    }
}
