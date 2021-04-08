package fr.epsi.topaidi.viewmodel;

import fr.epsi.topaidi.entite.Utilisateur;

public class UtilisateurBrainVM {
    private String libelle;

    private long nbIdees;

    public UtilisateurBrainVM(Utilisateur utilisateur) {
        this.libelle = utilisateur.getPrenom() + " " + utilisateur.getNom();
        this.nbIdees = utilisateur.getIdees().stream().count();
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public long getNbIdees() {
        return nbIdees;
    }

    public void setNbIdees(long nbIdees) {
        this.nbIdees = nbIdees;
    }
}
