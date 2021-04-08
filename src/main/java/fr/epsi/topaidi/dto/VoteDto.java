package fr.epsi.topaidi.dto;

import fr.epsi.topaidi.entite.Idee;
import fr.epsi.topaidi.entite.Utilisateur;

public class VoteDto {
    private Idee idee;

    private Utilisateur utilisateur;

    private boolean top;

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

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }
}
