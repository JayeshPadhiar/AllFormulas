package com.softwera.jayesh.allformulas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    Context formulaContext;
    ArrayList<String> formulaName;
    ArrayList<String> formula;

    public RecyclerViewAdapter(Context formulaContext, ArrayList<String> formulaName, ArrayList<String> formula) {
        this.formulaContext = formulaContext;
        this.formulaName = formulaName;
        this.formula = formula;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_formula, viewGroup, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewViewHolder, int i) {
        recyclerViewViewHolder.formulaName.setText(formulaName.get(i));
        recyclerViewViewHolder.formula.setText(formula.get(i));
    }

    @Override
    public int getItemCount() {
        return formulaName.size();
    }
}
