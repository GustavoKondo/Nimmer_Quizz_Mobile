package com.example.nimmer_quizz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nimmer_quizz.R;
import com.example.nimmer_quizz.model.Quizzz;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
            LayoutInflater inflater;
            List<Quizzz> quizzs;

            public Adapter(Context ctx, List<Quizzz> quizzs){
                this.inflater = LayoutInflater.from(ctx);
                this.quizzs = quizzs;
            }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_list_for_quizz,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                holder.songTitle.setText(quizzs.get(position).getTitle());
                holder.songArtists.setText(quizzs.get(position).getArtists());
                Picasso.get().load(quizzs.get(position).getCoverImage()).into(holder.songCoverImage);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
                TextView songTitle,songArtists;
                ImageView songCoverImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songTitle = itemView.findViewById(R.id.quizz_text_view);
            songArtists = itemView.findViewById(R.id.quizz_description_view);
            songCoverImage = itemView.findViewById(R.id.cover_image);
        }
    }
}
