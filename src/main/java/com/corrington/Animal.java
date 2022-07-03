package com.corrington;

public abstract class Animal {
    abstract void makeSound();
    public void displayInfo() {
        System.out.println("Animal");
    } // displayInfo()

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + this.weight +
                '}';
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private double weight;

} // class Animal