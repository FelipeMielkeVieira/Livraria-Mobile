package com.example.aula11_11.utils;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aula11_11.Entities.Livro;

import java.util.ArrayList;

public class ItemClick implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<Livro> list;

    public ItemClick(RecyclerView recyclerView, ArrayList<Livro> list) {
        this.recyclerView = recyclerView;
        this.list = list;
    }

    @Override
    public void onClick(View view) {
        int itemPosition = recyclerView.getChildLayoutPosition(view);
        Livro livro = list.get(itemPosition);
    }
}
