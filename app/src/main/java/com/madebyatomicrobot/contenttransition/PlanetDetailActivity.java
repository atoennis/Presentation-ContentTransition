package com.madebyatomicrobot.contenttransition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.madebyatomicrobot.contenttransition.model.Planet;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class PlanetDetailActivity extends Activity {

    public static final String EXTRA_PLANET = "EXTRA_PLANET";

    public static Intent getIntent(Context context, Planet planet) {
        Intent i = new Intent(context, PlanetDetailActivity.class);
        Bundle args = new Bundle();
        args.putParcelable(EXTRA_PLANET, Parcels.wrap(planet));
        i.putExtras(args);

        return i;
    }

    private Planet planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//        getWindow().setAllowEnterTransitionOverlap(true);
//        getWindow().setEnterTransition(new Explode().);

        setContentView(R.layout.activity_planet_detail);


        planet = Parcels.unwrap(getIntent().getExtras().getParcelable(EXTRA_PLANET));

        ImageView image = (ImageView) findViewById(R.id.image);

        Picasso.with(this)
                .load(planet.url)
                .fit()
                .centerCrop()
                .into(image);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_planets, menu);
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
