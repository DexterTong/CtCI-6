package com.dexter.tong.chapter03;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Question06 {

    /**
     * 3.6
     * An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
     * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
     * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
     * that type). They cannot select which specific animal they would like. Create the data structures to
     * maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
     * and dequeueCat. You may use the built-in Linked List data structure.
     */

    public class AnimalShelter{

        private LinkedList<ShelterEntry> dogs;
        private LinkedList<ShelterEntry> cats;
        // Let's pretend that time will never overflow
        private int time;

        public AnimalShelter() {
            this.dogs = new LinkedList<>();
            this.cats = new LinkedList<>();
            this.time = Integer.MIN_VALUE;
        }

        public void enqueue(Animal animal) {
            if(animal instanceof Dog) {
                dogs.add(new ShelterEntry(animal, time));
                time++;
                return;
            }
            if(animal instanceof Cat) {
                cats.add(new ShelterEntry(animal, time));
                time++;
            }
            // If a different type of animal has been encountered, handle it here
        }

        public Animal dequeueAny() {
            ShelterEntry oldestDogEntry = dogs.peek();
            ShelterEntry oldestCatEntry = cats.peek();
            ShelterEntry oldestEntry;

            if(oldestDogEntry == null && oldestCatEntry == null)
                throw new NoSuchElementException();
            if(oldestDogEntry == null)
                return dequeueCat();
            else if(oldestCatEntry == null)
                return dequeueDog();

            if(oldestDogEntry.admissionTime < oldestCatEntry.admissionTime)
                return dequeueDog();
            return dequeueCat();
        }

        public Dog dequeueDog() {
            ShelterEntry shelterEntry = dogs.remove();
            if(shelterEntry == null)
                throw new NoSuchElementException();
            return (Dog) shelterEntry.animal;
        }

        public Cat dequeueCat() {
            ShelterEntry shelterEntry = cats.remove();
            if(shelterEntry == null)
                throw new NoSuchElementException();
            return (Cat) shelterEntry.animal;
        }

        public Animal peekAny() {
            ShelterEntry oldestDogEntry = dogs.peek();
            ShelterEntry oldestCatEntry = cats.peek();
            ShelterEntry oldestEntry;

            if(oldestDogEntry == null && oldestCatEntry == null)
                throw new NoSuchElementException();
            if(oldestDogEntry == null)
                return oldestCatEntry.animal;
            else if(oldestCatEntry == null)
                return oldestDogEntry.animal;

            if(oldestDogEntry.admissionTime < oldestCatEntry.admissionTime)
                return oldestDogEntry.animal;
            return oldestCatEntry.animal;
        }

        public Dog peekDog() {
            ShelterEntry shelterEntry = dogs.peek();
            if(shelterEntry == null)
                throw new NoSuchElementException();
            return (Dog) shelterEntry.animal;
        }

        public Cat peekCat() {
            ShelterEntry shelterEntry = cats.peek();
            if(shelterEntry == null)
                throw new NoSuchElementException();
            return (Cat) shelterEntry.animal;
        }
    }

    public class ShelterEntry{

        public Animal animal;
        public int admissionTime;

        public ShelterEntry(Animal animal, int admissionTime) {
            this.animal = animal;
            this.admissionTime = admissionTime;
        }
    }

    abstract public class Animal{
        public String name;

        abstract public String makeSound();
    }

    public class Dog extends Animal{

        public Dog(){
            this("Doglas");
        }

        public Dog(String name) {
            this.name = name;
        }

        public String makeSound(){
            return "woof!";
        }
    }

    public class Cat extends Animal{

        public Cat(){
            this("Cathy");
        }

        public Cat(String name) {
            this.name = name;
        }

        public String makeSound() {
            return "meow!";
        }
    }
}
