package building;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Room {
    private static final int MAXLIGHT = 4000;
    private static final int WINDOWLIGHT = 700;
    private LinkedHashSet<Lightbulb> lightbulbs;
    private ArrayList<Furniture> furnitures;
    private String name;
    private double square;
    private double averageSquare;
    private int light;
    private int windowAmount;

    Room(String name, double square, int windowAmount){
        this.name = name;
        if(square > 0) {
            this.square = square;
        }
        else{
            this.square = 1;
        }
        if(windowAmount > 5){
            this.windowAmount = 5;
        }
        else if(windowAmount < 0){
            this.windowAmount = 0;
        }
        else {
            this.windowAmount = windowAmount;
        }
        this.light = windowAmount*WINDOWLIGHT;
        this.averageSquare = 0;
        lightbulbs = new LinkedHashSet<>();
        furnitures = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    double getSquare() {
        return square;
    }

    double getAverageSquare() {
        return averageSquare;
    }

    int getLight() {
        return light;
    }

    int getWindowAmount() {
        return windowAmount;
    }

    ArrayList<Furniture> getFurnitures(){
        return furnitures;
    }

    LinkedHashSet<Lightbulb> getLightbulbs(){
        return lightbulbs;
    }

    public void add(Lightbulb lightbulb){
        if(light + lightbulb.getLk() < MAXLIGHT){
            lightbulbs.add(lightbulb);
            light += lightbulb.getLk();
        }
    }

    public void add(String name, double size){
        Furniture furniture = new Furniture(name,size);
        if((averageSquare / square * 100) <= 70) {
            furnitures.add(furniture);
            averageSquare += furniture.getSize();
        }
    }
}
