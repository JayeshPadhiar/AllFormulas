package com.softwera.jayesh.allformulas;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import io.github.kexanie.library.MathView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView formulaName;
    public MathView formula;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        formulaName = (TextView) itemView.findViewById(R.id.formulaName);
        formula = (MathView) itemView.findViewById(R.id.MathView);
    }
}