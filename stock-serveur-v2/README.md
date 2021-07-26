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

Data auditing feature to the application
-
In this feature the main is auditing DataBase. For this we using Spring Data JPA/ Spring Data JPA Envers  
(Top layer of Hibernate Envers with different methods to get versioning information belongs to the entity class. ) 
auditing means that we track and log every change in all business objects, i.e, track each insert, update and delete operations.
Basically it involves tracking three thing. Auditing helps us in maintaining history records, which can later help us in tracking user activities.  
1. [Spring Data JPA : Auditing database ](https://www.callicoder.com/spring-boot-spring-security-jwt-mysql-react-app-part-3/)    
2. [Adding Spring Data JPA Envers](https://medium.com/@denuwanhimangahettiarachchi/maintain-the-data-versioning-info-with-spring-data-envers-42b6dfc19e27#id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6ImQ5NDZiMTM3NzM3Yjk3MzczOGU1Mjg2YzIwOGI2NmU3YTM5ZWU3YzEiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJuYmYiOjE2MDU2OTc3NDIsImF1ZCI6IjIxNjI5NjAzNTgzNC1rMWs2cWUwNjBzMnRwMmEyamFtNGxqZGNtczAwc3R0Zy5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsInN1YiI6IjEwNDg3OTE0MzI2MDk2NTAzODEyOCIsImVtYWlsIjoibmduYXdlbnNAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF6cCI6IjIxNjI5NjAzNTgzNC1rMWs2cWUwNjBzMnRwMmEyamFtNGxqZGNtczAwc3R0Zy5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsIm5hbWUiOiJTLiBWZXJtb24gTmduYXdlbiIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQU9oMTRHaFN5UlZSTlBGb2R0Tlplcl94NzlXM2dmVnRhbnRxYWJ3Xy1TV25xdz1zOTYtYyIsImdpdmVuX25hbWUiOiJTLiBWZXJtb24iLCJmYW1pbHlfbmFtZSI6Ik5nbmF3ZW4iLCJpYXQiOjE2MDU2OTgwNDIsImV4cCI6MTYwNTcwMTY0MiwianRpIjoiNWExMDI5Y2RlZWE4Y2QxMDU2NWVlZDAxNzRkMTg4NGJhM2NlODczMyJ9.aYVz8ryDWoY-foQzHuvTYEyS_q97WpluQspX-8QyLbCcQDX9hHyxPR-NOIOxdKaC9q9x62m1dFNK812zvEy4Yr0E2RDcPNKKK3bPOzCOg25YJjOGYfhjisSAjh7CPCTcmACWrjqjG_Y5gAiod_Kdn_P8T32Yx3NpGnG04BSelzuS8yVliR_vmQdctwioJgYx9QwC7KtSwGlYnHwWP8-AWU173qAb3IS5rtaasIvM0wrOPMGHEIEICP5a5ML_zSbU922m81eQJboyslopATr0ftygFS--vCAI_c0F0f5H2ThFpkaf79BEvSayGeT3r2gnXH3KtEWyZ7mNUMCVwqTIQA)
