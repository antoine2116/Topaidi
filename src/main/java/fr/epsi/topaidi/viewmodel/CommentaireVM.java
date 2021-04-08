package fr.epsi.topaidi.viewmodel;

import fr.epsi.topaidi.entite.Commentaire;

import java.text.SimpleDateFormat;

public class CommentaireVM {
    private String libelleUtilisateur;
    private String texte;
    private String date;

    public CommentaireVM(Commentaire commentaire) {
        this.libelleUtilisateur = commentaire.getUtilisateur().getPrenom() + " " + commentaire.getUtilisateur().getNom();
        this.texte = commentaire.getTexte();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy à hh:mm");
        this.date = formatter.format(commentaire.getDateCreation());
    }

    public String getLibelleUtilisateur() {
        return libelleUtilisateur;
    }

    public void setLibelleUtilisateur(String libelleUtilisateur) {
        this.libelleUtilisateur = libelleUtilisateur;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
