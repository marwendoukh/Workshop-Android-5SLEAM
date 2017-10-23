package tn.sleam.five.marwen.a5sleam.sqlite.entity;

/**
 * Created by marwen on 23/10/17.
 */

public class Candidate {

    Integer id;
    String nom, poste;

    public Candidate() {

    }

    public Candidate(Integer id, String nom, String poste) {
        this.id = id;
        this.nom = nom;
        this.poste = poste;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
}
