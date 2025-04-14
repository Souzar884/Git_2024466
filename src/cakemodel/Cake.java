/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakemodel;

/**
 *
 * @author roger
 */
public class Cake {
    private String name;
    private int weight; // in grams
    private String bestBeforeDate; // format: "dd/MM/yyyy"
    private String entryTime; // format: "HH:mm:ss"

    // Constructor
    public Cake(String name, int weight, String bestBeforeDate, String entryTime) {
        this.name = name;
        this.weight = weight;
        this.bestBeforeDate = bestBeforeDate;
        this.entryTime = entryTime;
    }

    // Getters
    public String getName() { return name; }
    public int getWeight() { return weight; }
    public String getBestBeforeDate() { return bestBeforeDate; }
    public String getEntryTime() { return entryTime; }

    
    public String toString() {
        return "Cake: " + name + 
               ", Weight: " + weight + "g" +
               ", Best Before: " + bestBeforeDate +
               ", Added at: " + entryTime;
    }
}
