package org.poo_exercices.personne;

public class Travailleur extends Personne{

    protected String nomEntreprise;
    protected String adresseEntreprise;
    protected String telephonePro;

    public Travailleur(
            String nom,
            String prenom,
            String telephone,
            String nomEntreprise,
            String adresseEntreprise ,
            String telephonePro
    ) {
        super(nom, prenom, telephone);
        this.nomEntreprise = nomEntreprise;
        this.adresseEntreprise = adresseEntreprise;
        this.telephonePro = telephonePro;
    }

    public Travailleur(String[] infos) {
        this(infos[0], infos[1], infos[2], infos[3], infos[4], infos[5]);
    }

    @Override
    public String toString() {
        return super.toString()
                + "Entreprise: " + nomEntreprise
                + ", Adresse entreprise: " + adresseEntreprise
                + ", Telephone professionnel: " + telephonePro + "\n"
                + getClass().getSimpleName() + "\n";
    }

//    public String getNomEntreprise() {
//        return nomEntreprise;
//    }
//
//    public void setNomEntreprise(String nomEntreprise) {
//        this.nomEntreprise = nomEntreprise;
//    }
//
//    public String getAdresseEntreprise() {
//        return adresseEntreprise;
//    }
//
//    public void setAdresseEntreprise(String adresseEntreprise) {
//        this.adresseEntreprise = adresseEntreprise;
//    }
//
//    public String getTelephonePro() {
//        return telephonePro;
//    }
//
//    public void setTelephonePro(String telephonePro) {
//        this.telephonePro = telephonePro;
//    }

}
