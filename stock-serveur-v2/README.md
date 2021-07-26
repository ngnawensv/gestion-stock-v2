## Gestion de stock avec Java 11/Hibernate/Spring Boot version 2.4.3
###1.**Généralités**

Back-end d'une application web de gestion de stock basée sur Spring MVC. 
Elle est structurée en couches. La **Couche entities**: Contient des objets représentant des tables 
de notre base de donnée(ici MySQL 5.7.34).Dans la couche entite de 
cette version de l'application nous avons opté d'eclater 
manuellement les relations @ManyToMany en deux relations 
@OneToMany-@ManyToOne.
**Couche repository**; **Couche service**; **Couche controller**:

### 2.**Taches à faire**
#### Commande client:
* Modifier la quantité 
* Modifier le client 
* Ajouter un etat de commande client 
    * En cours de preparation
    * Commande validée
    * Commande livrée
 * Modifier un article
 * Suprimer un article
 * Chercher les lignes de commande client par commande
 
#### Commande fournisseur:
* Modifier la quantité 
* Modifier le fournisseur 
* Ajouter un etat de commande fournisseur 
    * En cours de preparation
    * Commande validée
    * Commande livrée
 * Modifier un article
 * Suprimer un article
 * Chercher les lignes de commande client par commande