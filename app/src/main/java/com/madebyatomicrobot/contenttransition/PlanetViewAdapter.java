package com.madebyatomicrobot.contenttransition;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.os.Build;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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

    private final OnPlanetClickedListener listener;

    public PlanetViewAdapter() {
        this.listener = null;
    }

    public PlanetViewAdapter(OnPlanetClickedListener listener) {
        this.listener = listener;
    }

    @Override
    public PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_planet, parent, false);

        return new PlanetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PlanetViewHolder holder, final int position) {
        Planet planet = planets.get(position);

        holder.name.setText(planet.name);

        Picasso.with(holder.image.getContext())
                .load(planet.url)
                .fit()
                .into(holder.image);

        // Raise the elevation when clicked, 21+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StateListAnimator stateListAnimator = AnimatorInflater.loadStateListAnimator(holder.itemView.getContext(),
                    R.anim.lift_up);
            holder.itemView.setStateListAnimator(stateListAnimator);
        }

        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPlanetClicked(holder.image, planets.get(position));
            }
        });
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

    public interface OnPlanetClickedListener {
        void onPlanetClicked(ImageView sharedImage, Planet planet);
    }
}
