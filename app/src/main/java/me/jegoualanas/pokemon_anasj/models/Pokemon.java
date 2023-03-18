package me.jegoualanas.pokemon_anasj.models;

import java.util.ArrayList;

public class Pokemon {
    private int id;
    private String num;
    private String name;
    private String img;
    private String height;
    private String weight;
    private String candy;
    private int candy_count;
    private String egg;
    private double spawn_chance;
    private double avg_spawns;
    private String spawn_time;
    private ArrayList<Double> multipliers;
    private ArrayList<String> weaknesses;
    private ArrayList<NextEvolution> next_evolution;
    private ArrayList<PrevEvolution> prev_evolution;
    public Pokemon() {

    }

    public Pokemon(int id, String num, String name, String img, String height, String weight, String candy, int candy_count, String egg, double spawn_chance, double avg_spawns, String spawn_time, ArrayList<Double> multipliers, ArrayList<String> weaknesses, ArrayList<NextEvolution> next_evolution, ArrayList<PrevEvolution> prev_evolution) {
        this.id = id;
        this.num = num;
        this.name = name;
        this.img = img;
        this.height = height;
        this.weight = weight;
        this.candy = candy;
        this.candy_count = candy_count;
        this.egg = egg;
        this.spawn_chance = spawn_chance;
        this.avg_spawns = avg_spawns;
        this.spawn_time = spawn_time;
        this.multipliers = multipliers;
        this.weaknesses = weaknesses;
        this.next_evolution = next_evolution;
        this.prev_evolution = prev_evolution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCandy() {
        return candy;
    }

    public void setCandy(String candy) {
        this.candy = candy;
    }

    public int getCandy_count() {
        return candy_count;
    }

    public void setCandy_count(int candy_count) {
        this.candy_count = candy_count;
    }

    public String getEgg() {
        return egg;
    }

    public void setEgg(String egg) {
        this.egg = egg;
    }

    public double getSpawn_chance() {
        return spawn_chance;
    }

    public void setSpawn_chance(double spawn_chance) {
        this.spawn_chance = spawn_chance;
    }

    public double getAvg_spawns() {
        return avg_spawns;
    }

    public void setAvg_spawns(double avg_spawns) {
        this.avg_spawns = avg_spawns;
    }

    public String getSpawn_time() {
        return spawn_time;
    }

    public void setSpawn_time(String spawn_time) {
        this.spawn_time = spawn_time;
    }

    public ArrayList<Double> getMultipliers() {
        return multipliers;
    }

    public void setMultipliers(ArrayList<Double> multipliers) {
        this.multipliers = multipliers;
    }

    public ArrayList<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(ArrayList<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public ArrayList<NextEvolution> getNext_evolution() {
        return next_evolution;
    }

    public void setNext_evolution(ArrayList<NextEvolution> next_evolution) {
        this.next_evolution = next_evolution;
    }

    public ArrayList<PrevEvolution> getPrev_evolution() {
        return prev_evolution;
    }

    public void setPrev_evolution(ArrayList<PrevEvolution> prev_evolution) {
        this.prev_evolution = prev_evolution;
    }
}
