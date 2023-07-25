# <p align="center"> Java-Enterprise-Edition </p>

## Architecture d'une application :

<img src="https://github.com/Mo-bar/Java-Enterprise-Edition/assets/98557431/ea1aee5c-3edc-4628-bdb1-d8096468e27b">

## _La technique de mapping objet-relationnel :_

```
se fait généralement dans la couche de l'accès aux données, également appelée "Data Access Layer" (DAL). 
Le DAL est responsable de l'interaction avec la base de données et de la conversion des données entre 
les structures d'objets de l'application et les structures relationnelles de la base de données.
```

### Java Data Base Connectivity :

```
Une application java qui permettent de communiquer avec n'importe quel systeme de gestion de base donnees relationnelles
```

### pilote ou driver JDBC :

```
C'est une classe java chargée en mémoire qui établit la connexion entre
une application java et un système de gestion de base de données
par exemple si on utilise MySql comme SGBD , il faut charge en memoire le driver "com.mysql.jdbc.Driver"
```

### La sérialisation

```
consiste à prendre un objet en mémoire et à le convertir en une représentation binaire,
généralement sous forme d'un tableau d'octets. Cette représentation binaire peut ensuite être envoyée à une autre application,
généralement via un réseau, où elle sera désérialisée pour reconstituer l'objet d'origine.
```

### La désérialisation

```
est l'opération inverse de la sérialisation. Une fois que les données sérialisées sont
reçues par l'application de destination, elles sont analysées et les octets sont utilisés pour reconstituer l'objet d'origine.
```

### Java Bean :

```
est une classe contient les auttributs prive , des méthodes d'accès, une construction par défaut et
Implémentation de l'interface Serializable (facultatif) :  Cela permet à l'objet d'être sérialisé,
c'est-à-dire converti en une représentation binaire pour être stocké ou transféré.
```

### Une entité JPA

```
Est une classe Java annotée avec des annotations JPA pour représenter une entité persistante dans une base de données
```

## MAPPING DES ASSOCIATIONS:

### 1. HOPITAL : Rendez-Vous Médecins , Patients

Mapping les assiciation OneToMany, ManyToOne et OneToOne.

- #### CACHIER DE CHARGE :

```
  - On souhaite gérer les rendez-vous des consultations des patients effectuées par des médecins.
      Chaque Rendez-vous concerne un patient et un médecin.
  - Pour chaque rendez-vous on associe une seule consultation issue de rendez-vous.
  - Un Patient peut prendre plusieurs rendez-vous
```

- #### CONCEPTION :

<img src="https://github.com/Mo-bar/Java-Enterprise-Edition/assets/98557431/391d7e95-942b-48e9-854f-66df4bfa5dee">

- #### PRESENTATION SQL :

<img src="https://github.com/Mo-bar/Java-Enterprise-Edition/assets/98557431/2428039c-3e60-4295-bc1e-8b4a03223dd2" >

- [**PRESENTATION JAVA** ](https://github.com/Mo-bar/Java-Enterprise-Edition/tree/main/Hopital)

### 2. Ecole : `Cours`, `Inscriptions`, `Etudiant`

- #### CACHIER DE CHARGE :

```
Un `Etudiant` peut s‘inscrire dans plusieurs `Cours` a une `date` donnée avec un `score` obtenu.
Un `cours` concerne plusieurs `Inscriptions`. ( Plusieurs a Plusieurs avec Classe d’association `Inscription` )
Equivalent à : Un Etudiant peut effectuer Plusieurs Inscription. Chaque Inscription Concerne un Cours
Deux Associations : Un à Plusieurs + Plusieurs à 1
```

- #### CONCEPTION :

<img src="https://github.com/Mo-bar/Java-Enterprise-Edition/assets/98557431/160de169-d47b-412c-a99f-8ea5a29438aa">

- #### PRESENTATION SQL :

<img src="https://github.com/Mo-bar/Java-Enterprise-Edition/assets/98557431/d4046108-67d5-4a48-b5b7-4257e4a64543" >

- [**PRESENTATION JAVA** ](https://github.com/Mo-bar/Java-Enterprise-Edition/tree/main/Ecole)

### 2. Mapping d'heritahe: `Etudiant`, `Gestionnaire`, `Personne`

-   #### CONCEPTION:
<img src="https://github.com/Mo-bar/Java-Enterprise-Edition/assets/98557431/ac3e5f9b-0c81-49cd-aea9-ac2fd087676a">

 ### -- Les stratégies de Mapping de I'héritage :
 **1. Une table par hiérarchie `SINGLE_TABLE` : `Personne`**
	
| id | type   | nom        | dateNaiss  | matiere   | note |
|----|--------|------------|------------|-----------|------|
| 1  | Student| John Smith | 1995-08-15 | Math      | 85   |
| 2  | Student| Jane Doe   | 1998-03-22 | null      | 90   |
| 3  | Teacher| Mark Brown | 1980-11-02 | Physics   | null |
| 4  | Student| Emily Rose | 2000-06-10 | English   | 78   |

- Commantaire : 
```
  
La stratégie `SINGLE_TABLE` regroupe toutes les entités dans une seule table de la base de données, 
avec une colonne de discrimination pour identifier le type d'entité de chaque enregistrement.

Avantages de `SINGLE_TABLE`:
	- Recherche de Données Rapide.
Désavantages de `SINGLE_TABLE` : 
	- Colonnes Redondantes.
	- Certaines colonnes peuvent rester null.
```
	
**2. Une table pour chaque classe concréte `TABLE_PER_CLASS`**
- Etudiant : 

| id | nom         | dateNaiss  | note |
|----|-------------|------------|------|
| 1  | John Smith  | 1995-08-15 | 85   |
| 2  | Jane Doe    | 1998-03-22 | 90   |
| 3  | Emily Rose  | 2000-06-10 | 78   |
- Ensignant : 


| id | nom         | dateNaiss  | matiere   |
|----|-------------|------------|-----------|
| 1  | Mark Brown  | 1980-11-02 | Physics   |
| 2  | Laura Green | 1975-05-18 | Math      |
| 3  | James White | 1985-09-30 | English   |

  
  
  
**3. Une table pour la classe parente et une table pour chaque classe fille `JOINED_TABLE`:**

- Personne : 

| id | nom         | dateNaiss  |
|----|-------------|------------|
| 1  | John Smith  | 1995-08-15 |
| 2  | Jane Doe    | 1998-03-22 |
| 3  | Emily Rose  | 2000-06-10 |


- Etudiant : 

| #Id | note |
|-----|------|
| 1   | 85   |
| 2   | 90   |
| 3   | 78   |
- Ensignant : 

| #Id | matiere   |
|-----|-----------|
| 1   | Physics   |
| 2   | Math      |
| 3   | English   |

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTQ1NzM5MDMzMywzNDA4NzM1NDksLTEyNT
M4MTAxOTQsMTk2NjU0MDIyOSwxNzEwMzc5NjgwLC0zMzA5Mzc1
MTgsNTY2Mzc2NDY1LC0xNzc0NjU2MDUzLDE0NzUzMTg4MjUsND
Q5ODcyMjk0LC0zMDg2MDQ5MTgsLTExMDM4ODk0MzUsMTgxNzAw
MjkzNiwzNjUzMjIwMDZdfQ==
-->