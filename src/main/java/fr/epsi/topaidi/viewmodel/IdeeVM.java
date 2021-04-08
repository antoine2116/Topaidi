package fr.epsi.topaidi.viewmodel;

import fr.epsi.topaidi.entite.Idee;
import fr.epsi.topaidi.entite.Utilisateur;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;

public class IdeeVM {
    private int id;
    private String titre;
    private String description;
    private String imageBase64;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String libelleCategorie;
    private String strDateCreation;
    private long nbVotesTop;
    private long nbVotesFlop;
    private long nbVotesTotal;
    private long nbCommentaires;
    private boolean votableByUtilisateur;

    public IdeeVM(Idee idee) {
        this.id = idee.getId();
        this.titre = idee.getTitre();
        this.description = idee.getDescription();
        this.imageBase64 = Base64.getEncoder().encodeToString(idee.getImage());
        this.nomUtilisateur = idee.getUtilisateur().getNom();
        this.prenomUtilisateur = idee.getUtilisateur().getPrenom();
        this.libelleCategorie = idee.getCategorie().getLibelle();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy à hh:mm");
        this.strDateCreation = formatter.format(idee.getDateCreation());

        this.nbVotesTop = idee.getVotes().stream().filter(v -> v.isTop()).count();
        this.nbVotesFlop = idee.getVotes().stream().filter(v -> !v.isTop()).count();
        this.nbVotesTotal = this.nbVotesTop + this.nbVotesFlop;

        this.nbCommentaires = idee.getCommentaires().stream().count();
    }

    public IdeeVM(Idee idee, Utilisateur currentUser) {
        this(idee);

        LocalDate dateCreationLocal = idee.getDateCreation().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.votableByUtilisateur = currentUser != null &&
                                    !idee.getVotes().stream().anyMatch(v -> v.getUtilisateur().getId() == currentUser.getId()) &&
                                    idee.getUtilisateur().getId() != currentUser.getId() &&
                                    dateCreationLocal.isAfter(LocalDate.now().minusDays(7));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public String getStrDateCreation() {
        return strDateCreation;
    }

    public void setStrDateCreation(String strDateCreation) {
        this.strDateCreation = strDateCreation;
    }

    public long getNbVotesTop() {
        return nbVotesTop;
    }

    public void setNbVotesTop(long nbVotesTop) {
        this.nbVotesTop = nbVotesTop;
    }

    public long getNbVotesFlop() {
        return nbVotesFlop;
    }

    public void setNbVotesFlop(long nbVotesFlop) {
        this.nbVotesFlop = nbVotesFlop;
    }

    public long getNbVotesTotal() {
        return nbVotesTotal;
    }

    public void setNbVotesTotal(long nbVotesTotal) {
        this.nbVotesTotal = nbVotesTotal;
    }

    public boolean isVotableByUtilisateur() {
        return votableByUtilisateur;
    }

    public void setVotableByUtilisateur(boolean votableByUtilisateur) {
        this.votableByUtilisateur = votableByUtilisateur;
    }

    public long getNbCommentaires() {
        return nbCommentaires;
    }

    public void setNbCommentaires(long nbCommentaires) {
        this.nbCommentaires = nbCommentaires;
    }
}
