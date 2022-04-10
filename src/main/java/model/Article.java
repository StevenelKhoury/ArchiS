package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    UUID idArticle;
    String libelle;
    String marque;
    double prix;
    @OneToOne
    Ccategory category;
    @OneToOne
    Photo photo;

    public UUID getIdArticle() {
        return idArticle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setCategory(Ccategory category) {
        this.category = category;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getMarque() {
        return marque;
    }

    public Ccategory getCategory() {
        return category;
    }

    public Photo getPhoto() {
        return photo;
    }

    public double getPrix() {
        return prix;
    }
}


