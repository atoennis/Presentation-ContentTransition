package com.madebyatomicrobot.contenttransition;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.madebyatomicrobot.contenttransition.model.Planet;

import java.util.Arrays;
import java.util.List;

public class PlanetActivity extends Activity {

    private List<Planet> planets = Arrays.asList(
            new Planet("Mercury", "https://upload.wikimedia.org/wikipedia/commons/e/ee/Mercury_transit_1.jpg"),
            new Planet("Venus", "https://upload.wikimedia.org/wikipedia/commons/8/85/Venus_globe.jpg"),
            new Planet("Earth", "https://upload.wikimedia.org/wikipedia/commons/9/97/The_Earth_seen_from_Apollo_17.jpg"),
            new Planet("Mars", "https://upload.wikimedia.org/wikipedia/commons/5/58/Mars_23_aug_2003_hubble.jpg"),
            new Planet("Jupiter", "https://upload.wikimedia.org/wikipedia/commons/e/e2/Jupiter.jpg"),
            new Planet("Saturn", "https://upload.wikimedia.org/wikipedia/commons/b/b4/Saturn_(planet)_large.jpg"),
            new Planet("Uranus", "https://upload.wikimedia.org/wikipedia/commons/3/3d/Uranus2.jpg"),
            new Planet("Neptune", "https://upload.wikimedia.org/wikipedia/commons/5/56/Neptune_Full.jpg"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlanetViewAdapter planetViewAdapter = new PlanetViewAdapter();
        planetViewAdapter.setPlanets(planets);

        RecyclerView planetsView = (RecyclerView) findViewById(R.id.planets_view);
        planetsView.setHasFixedSize(true);
        planetsView.setLayoutManager(new LinearLayoutManager(this));
        planetsView.setAdapter(planetViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}