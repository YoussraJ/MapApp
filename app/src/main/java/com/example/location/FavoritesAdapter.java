package com.example.location;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {

    private List<Position> favoritePositions;

    public FavoritesAdapter(List<Position> favoritePositions) {
        this.favoritePositions = favoritePositions;
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_2, parent, false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        Position currentPosition = favoritePositions.get(position);
        holder.nameTextView.setText(currentPosition.getName());
        holder.coordinatesTextView.setText(
                String.format("Lat: %.2f, Lon: %.2f", currentPosition.getLatitude(), currentPosition.getLongitude()));
    }

    @Override
    public int getItemCount() {
        return favoritePositions.size();
    }

    public static class FavoritesViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView coordinatesTextView;

        public FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(android.R.id.text1);
            coordinatesTextView = itemView.findViewById(android.R.id.text2);
        }
    }
}

