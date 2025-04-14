/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakemodel;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author roger
 */

public class Oven {
    private Queue<Cake> cakeQueue;
    private final int MAX_CAPACITY = 5;

    public Oven() {
        cakeQueue = new LinkedList<>();
    }

    // Add cake to oven (if not full)
    public boolean addCake(Cake cake) {
        if (cakeQueue.size() < MAX_CAPACITY) {
            cakeQueue.add(cake);
            return true;
        }
        return false; // Oven full
    }

    // Remove cake (FIFO)
    public Cake removeCake() {
        return cakeQueue.poll(); // Returns null if empty
    }

    // Get all cakes in oven
    public String getAllCakes() {
        if (cakeQueue.isEmpty()) return "Oven is empty!";
        
        StringBuilder sb = new StringBuilder();
        for (Cake cake : cakeQueue) {
            sb.append(cake.toString()).append("\n");
        }
        return sb.toString();
    }

    // Check if oven is full
    public boolean isFull() {
        return cakeQueue.size() >= MAX_CAPACITY;
    }
}
