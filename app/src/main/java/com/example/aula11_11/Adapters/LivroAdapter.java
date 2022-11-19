package com.example.aula11_11.Adapters;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula11_11.Entities.Livro;
import com.example.aula11_11.MainActivity;
import com.example.aula11_11.R;

import java.util.ArrayList;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.ViewHolder> {

    private final ArrayList<Livro> listaLivros;
    private final MainActivity mainActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nomeLivro;
        private final TextView anoLivro;
        private final TextView editoraLivro;
        private final ImageView imagemLivro;

        public ViewHolder(View view, MainActivity mainActivity, LivroAdapter livroAdapter) {
            super(view);
            nomeLivro = (TextView) view.findViewById(R.id.nomeLivro);
            anoLivro = (TextView) view.findViewById(R.id.anoLivro);
            editoraLivro = (TextView) view.findViewById(R.id.editoraLivro);
            imagemLivro = (ImageView) view.findViewById(R.id.imagemLivro);

            view.findViewById(R.id.layoutClick).setOnClickListener(v -> {
                int itemPosition = MainActivity.recyclerView.getChildLayoutPosition(view);
                Livro livro = livroAdapter.listaLivros.get(itemPosition);
                mainActivity.detalhesLivro(livro);
            });

            view.findViewById(R.id.imagemDeletar).setOnClickListener(v -> new AlertDialog.Builder(mainActivity)
                    .setTitle("Excluir Livro")
                    .setMessage("tem certeza que deseja excluir o livro?")
                    .setPositiveButton("Sim", (dialog, which) -> {
                        livroAdapter.listaLivros.remove(getAdapterPosition());
                        livroAdapter.notifyItemRemoved(getAdapterPosition());
                    })
                    .setNegativeButton("Não", null)
                    .show());
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

        public ImageView getImagemLivro() {
            return imagemLivro;
        }
    }

    public LivroAdapter(ArrayList<Livro> dataSet, RecyclerView recyclerView, MainActivity mainActivity) {
        listaLivros = dataSet;
        MainActivity.recyclerView = recyclerView;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.livro_lista, viewGroup, false);
        return new ViewHolder(view, this.mainActivity, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.getNomeLivro().setText(listaLivros.get(position).getNome());
        viewHolder.getEditoraLivro().setText(listaLivros.get(position).getEditora());
        viewHolder.getAnoLivro().setText(listaLivros.get(position).getAno());
        viewHolder.getImagemLivro().setImageDrawable(listaLivros.get(position).getImagem());
    }

    @Override
    public int getItemCount() {
        return listaLivros.size();
    }
}
