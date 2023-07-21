# <p align="center"> Java-Enterprise-Edition </p>
**_Description :_** Java Enterprise Edition : ORM JDBC JPA Hibrnate Spring Data

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

###  pilote ou driver JDBC : 
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
### Association OneToMany, ManyToOne, OneToOne : 
## Exemple Rendez-Vous Médecins , Patients
- Cahier de charge : 
  - On souhaite gérer les rendez-vous des consultations des patients effectuées par des médecins.
      Chaque Rendez-vous concerne un patient et un médecin.
  - Pour chaque rendez-vous on associe une seule consultation issue de rendez-vous.
  - Un Patient peut prendre plusieurs rendez-vous

- Conception : 
<img src="https://github.com/Mo-bar/Java-Enterprise-Edition/assets/98557431/a8029147-4834-4739-a9fc-ef178965c789">

- Presentation SQL :
<img src="https://github.com/Mo-bar/Java-Enterprise-Edition/assets/98557431/2428039c-3e60-4295-bc1e-8b4a03223dd2" >

- [Presentation Java ](https://github.com/Mo-bar/Java-Enterprise-Edition/tree/main/Mapping-des-associations/src/main/java/org/barkouch/hopital)
