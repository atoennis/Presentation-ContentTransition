package com.madebyatomicrobot.contenttransition.model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Planet {
    public final String name;

    public final String url;

    @ParcelConstructor
    public Planet(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
