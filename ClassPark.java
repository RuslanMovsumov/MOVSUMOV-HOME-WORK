package org.example;

import java.util.ArrayList;
import java.util.List;

public class Park.java {
    private List<Attraction> attractions;

    public Park.java() {
        attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String workingTime, double price) {
        Attraction attraction = new Attraction(name, workingTime, price);
        attractions.add(attraction);
    }

    public void showAttractions() {
        if (attractions.isEmpty()) {
            System.out.println("В парке нет аттракционов.");
            return;
        }
        
        System.out.println("Аттракционы в парке:");
        for (Attraction attraction : attractions) {
            System.out.println(attraction);
        }
    }

    public static void main(String[] args) {
        Park park = new Park();
        park.addAttraction("Американские горки", "10:00 - 20:00", 500);
        park.addAttraction("Колесо обозрения", "10:00 - 22:00", 300);
        park.showAttractions();
    }
} 

