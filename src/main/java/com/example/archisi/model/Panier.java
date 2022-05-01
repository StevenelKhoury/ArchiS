package com.example.archisi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Panier {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @OneToOne
    private Utilisateur user ;
    @OneToMany
    private List<Article> articles = new ArrayList<>();
    private Double prixTotal(){return this.articles.stream().mapToDouble(a -> a.getPrix()).reduce(0, Double::sum);}

}
