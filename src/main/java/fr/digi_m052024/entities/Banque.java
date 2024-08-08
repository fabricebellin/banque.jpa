package fr.digi_m052024.entities;

import fr.digi_m052024.entities.

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,nullable = false)
    private Long id;

    @Column(name = "nom" ,nullable = false)
    private String nom;

    @OneToMany(mappedBy = "banque")
    private List<Client> clients;


    public Banque() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<Client> getClients() {
        return clients;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }


    @Entity
    public static class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name = "nom", nullable = false)
        private String nom;

        @Column(name = "prenom", nullable = false)
        private String prenom;

        @Embedded
        private Adresse adresse;

        @ManyToOne
        @JoinColumn(name = "banque_id")
        private Banque banque;

        @ManyToMany(mappedBy = "clients")
        private List<Compte> comptes = new ArrayList<>();

        public Client(String nom, String prenom, Adresse adresse, Banque banque) {
            this.nom = nom;
            this.prenom = prenom;
            this.adresse = adresse;
            this.banque = banque;
        }

        public Client() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public Adresse getAdresse() {
            return adresse;
        }

        public void setAdresse(Adresse adresse) {
            this.adresse = adresse;
        }

        public Banque getBanque() {
            return banque;
        }

        public void setBanque(Banque banque) {
            this.banque = banque;
        }

        public List<Compte> getComptes() {
            return comptes;
        }

        public void setComptes(List<Compte> comptes) {
            this.comptes = comptes;
        }
    }
}