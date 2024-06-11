package org.exercices.entity;

import java.time.LocalDate;

public class Cat {

    private String name;
    private String race;
    private String favouriteMeat;
    private LocalDate birthday;

    public Cat(String name, String race, String favouriteMeat, LocalDate birthday) {
        this.name = name;
        this.race = race;
        this.favouriteMeat = favouriteMeat;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getFavouriteMeat() {
        return favouriteMeat;
    }

    public void setFavouriteMeat(String favouriteMeat) {
        this.favouriteMeat = favouriteMeat;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
