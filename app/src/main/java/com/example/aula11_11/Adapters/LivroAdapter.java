package com.example.aula11_11.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula11_11.Entities.Livro;
import com.example.aula11_11.R;
import com.example.aula11_11.utils.ItemClick;

import java.util.ArrayList;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.ViewHolder> {

    private ArrayList<Livro> listaLivros;
    private RecyclerView recyclerView;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nomeLivro;
        private final TextView anoLivro;
        private final TextView editoraLivro;

        public ViewHolder(View view) {
            super(view);
            nomeLivro = (TextView) view.findViewById(R.id.nomeLivro);
            anoLivro = (TextView) view.findViewById(R.id.anoLivro);
            editoraLivro = (TextView) view.findViewById(R.id.editoraLivro);
        }

        public TextView getNomeLivro() {
            return nomeLivro;
        }
        public TextView getAnoLivro() {
            return anoLivro;
        }
        public TextView getEditoraLivro() {
            return editoraLivro;
        }
    }

    public LivroAdapter(ArrayList<Livro> dataSet, RecyclerView recyclerView) {
        listaLivros = dataSet; this.recyclerView = recyclerView;
    }
    public LivroAdapter() {
        listaLivros = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.livro_lista, viewGroup, false);
        view.setOnClickListener(new ItemClick(recyclerView, listaLivros));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.getNomeLivro().setText(listaLivros.get(position).getNome());
        viewHolder.getEditoraLivro().setText(listaLivros.get(position).getEditora());
        viewHolder.getAnoLivro().setText(listaLivros.get(position).getAno());
    }

    @Override
    public int getItemCount() {
        return listaLivros.size();
    }
}
