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

-  #### Les stratégies de Mapping de I'héritage
	- **Une table par hiérarchie `SINGLE_TABLE` :**
	
	| Id |  Type  | Nom | Matiere | Note |  				
	|-----|---------|--------|----------|------|  			
	|  1  | Etudiant| Alice | Math |  90  | 						  
	 |  2  | Professeur | Bob | Physics |  85  |
 ______________________
- **Une table pour chaque classe concréte `TABLE_PER_CLASS`**
	
	| Id | NomEtudiant | Note |
	 |-----|--------|------|
	 | 1 | Alice | 90 | | 2 | Bob | 85 |

	
	| Id | NomProfesseur | Matiere | 
	|-----|--------|----------|
	 | 1 | Alice | Math |
	 | 2 | Bob | Physics |
  
  
  
Une table pour la classe parente et une table pour chaque classe fille `JOINED_TABLE`


<!--stackedit_data:
eyJoaXN0b3J5IjpbMTM4MDM5Njg5NCwtMzA4NjA0OTE4LC0xMT
AzODg5NDM1LDE4MTcwMDI5MzYsMzY1MzIyMDA2XX0=
-->