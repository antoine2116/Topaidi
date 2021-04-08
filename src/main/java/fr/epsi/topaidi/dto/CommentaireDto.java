package fr.epsi.topaidi.dto;

import fr.epsi.topaidi.entite.Idee;
import fr.epsi.topaidi.entite.Utilisateur;

public class CommentaireDto {
    private Idee idee;
    private Utilisateur utilisateur;
    private String texte;

    public Idee getIdee() {
        return idee;
    }

    public void setIdee(Idee idee) {
        this.idee = idee;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
