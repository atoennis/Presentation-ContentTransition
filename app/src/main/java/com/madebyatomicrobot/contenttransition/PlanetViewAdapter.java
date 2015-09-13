package com.madebyatomicrobot.contenttransition;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.madebyatomicrobot.contenttransition.PlanetViewAdapter.PlanetViewHolder;
import com.madebyatomicrobot.contenttransition.model.Planet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PlanetViewAdapter extends Adapter<PlanetViewHolder> {

    private List<Planet> planets = new ArrayList<>();

    @Override
    public PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_planet, parent, false);

        return new PlanetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlanetViewHolder holder, int position) {
        Planet planet = planets.get(position);

        holder.name.setText(planet.name);

        Picasso.with(holder.image.getContext())
                .load(planet.url)
                .fit()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public class PlanetViewHolder extends ViewHolder {

        private final TextView name;
        private final ImageView image;

        public PlanetViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}