package fr.digi_m052024.entities;

import jakarta.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class AssuranceVie extends Compte {
    private Date dateFin;
    private double taux;

    public AssuranceVie(String numero, double solde, List<Client> clients, Date dateFin, double taux) {
        super(numero, solde, clients);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public AssuranceVie(String numero, double solde, List<Banque.Client> clients) {
        super(numero, solde, clients);
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}