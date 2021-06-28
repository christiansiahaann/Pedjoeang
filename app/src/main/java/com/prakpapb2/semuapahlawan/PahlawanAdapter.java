package com.prakpapb2.semuapahlawan;

import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prakpapb2.database.PahlawanHelper;
import com.prakpapb2.intro1.Biografi;
import com.prakpapb2.intro1.R;
import com.prakpapb2.utils.Pahlawan;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PahlawanAdapter extends RecyclerView.Adapter<PahlawanAdapter.ViewHolder> {
    private final List<Pahlawan> listCourses = new ArrayList<>();

    public void setCourses(List<Pahlawan> listCourses) {
        if (listCourses == null) return;
        this.listCourses.clear();
        this.listCourses.addAll(listCourses);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pahlawan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Pahlawan course = listCourses.get(position);
        holder.bind(course);
    }

    @Override
    public int getItemCount() {
        return listCourses.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        ImageView imgDestinasi;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textView1);
            imgDestinasi = itemView.findViewById(R.id.gambarpahlawan1);
        }

        void bind(Pahlawan pahlawan) {
            tvTitle.setText(pahlawan.getNamaPahlawan());
            Picasso.get()
                    .load(pahlawan.getPhotoPahlawan())
                    .resize(450, 450)
                    .into(imgDestinasi);
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), Biografi.class);
                intent.putExtra(Biografi.EXTRA_PAHLAWAN, pahlawan);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}