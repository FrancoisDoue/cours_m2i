package org.poo_exercices.bases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Film {
    private String titre;
    private String realisateur;
    private LocalDate dateSortie;
    private String genre;

    public Film(String titre, String realisateur, LocalDate dateSortie, String genre) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.dateSortie = dateSortie;
        this.genre = genre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public String toString() {
        return getClass().getSimpleName() +
                "{titre=" + titre +
                ", realisateur=" + realisateur +
                /*", dateSortie=" + getDateSortie() +*/
                ", dateSortie=" + dateSortie.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) +
                ", " + "genre=" + genre + "}";
    }
}
