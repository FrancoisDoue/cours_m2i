package org.poo_exercices.personne;

public class Scientifique extends Travailleur{
    private String discipline;
    private String type;

    public Scientifique(
            String nom,
            String prenom,
            String telephone,
            String nomEntreprise,
            String adresseEntreprise,
            String telephonePro,
            String discipline,
            String type
    ) {
        super(nom, prenom, telephone, nomEntreprise, adresseEntreprise, telephonePro);
        this.discipline = discipline;
        this.type = type;
    }

    public Scientifique(String[] infos) {
        this(infos[0], infos[1], infos[2], infos[3], infos[4], infos[5], infos[6], infos[7]);
    }

    @Override
    public String toString() {
        return super.toString()
                + "discipline: " + discipline + " " + type + "\n";
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getDiscipline() {
//        return discipline;
//    }
//
//    public void setDiscipline(String discipline) {
//        this.discipline = discipline;
//    }

}
