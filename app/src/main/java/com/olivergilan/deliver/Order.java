package com.olivergilan.deliver;

import android.location.Location;

import com.google.android.gms.location.places.Place;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class Order {

    private String customer;
    private double customerLat;
    private double customerLng;
    private ArrayList<Product> items;
    private String pickupLocation;
    private int itemCount;
    private int totalCost = 0;
    private double longitude;
    private double latitude;
    private String countryCode;


    public Order(ArrayList<Product> products, Place pickup, Place dropOff, String user, String country){
        items = products;
        itemCount = items.size();
        for (Product item: items) {
            totalCost += item.getCost();
        }
        pickupLocation = pickup.getName().toString();
        longitude = pickup.getLatLng().longitude;
        latitude = pickup.getLatLng().latitude;
        customer = user;
        countryCode = country;
        customerLat = dropOff.getLatLng().latitude;
        customerLng = dropOff.getLatLng().longitude;
    }

    public Order(ArrayList<Product> products, double mlong, double mlat, String user){
        items = products;
        itemCount = items.size();
        for (Product item: items) {
            totalCost += item.getCost();
        }
        longitude = mlong;
        latitude = mlat;
        customer = user;
    }

    public Order(){
        itemCount = 0;
        longitude=0;
        latitude=0;
        totalCost=0;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public String getCustomer() {
        return customer;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public double getCustomerLat() {
        return customerLat;
    }

    public double getCustomerLng() {
        return customerLng;
    }
}
