package com.corrington;

public class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("woof woof");
    } // makeSound()

    @Override
    public String toString() {
        return "Dog{" +
                "weight=" + getWeight() +
                '}';
    } // toString()
} // class Dog
