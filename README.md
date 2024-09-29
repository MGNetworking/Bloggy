# Blog en Java EE

## Présentation du projet

Ce projet consiste en la création d'un blog développé en Java EE sans l'utilisation de frameworks tiers. L'objectif est
de proposer une solution légère et robuste en utilisant les technologies standards de Java EE.

## Technologies utilisées

Le projet repose sur les technologies suivantes :

* **HTML, CSS, JavaScript** : pour la gestion et la manipulation du DOM côté client.
* **JDBC (Java Database Connectivity)** : pour la gestion de la persistance des données à travers des objets d'accès aux
  données (DAO).
* **JSTL (JavaServer Pages Standard Tag Library)** : pour simplifier le développement de pages JSP grâce à des balises
  personnalisées standard.
* **EL (Expression Language)** : un langage d'expressions utilisé pour intégrer des données dynamiques directement dans
  les
  pages JSP, réduisant ainsi l'usage direct de code Java.
* **JSP (JavaServer Pages)** : une technologie Java permettant la génération de contenu web dynamique côté serveur.

## Configuration du serveur Tomcat

Le serveur d'applications Apache Tomcat a été configuré pour permettre la gestion de fichiers volumineux, avec une
limite de taille pour les requêtes multipart fixée à 150 MB. Cette configuration se trouve dans le fichier suivant :

```bash
Program Files\Apache Software Foundation\Tomcat 9.0\webapps\manager\WEB-INF
```

Le fichier de configuration XML a été ajusté de la manière suivante :

```xml

<multipart-config>
    <!-- 50MB max avant modification : 52428800 -->
    <!-- 50MB * 3 max après modification : 157 286 400 donc 150MB -->
    <max-file-size>157286400</max-file-size>
    <max-request-size>157286400</max-request-size>
    <file-size-threshold>0</file-size-threshold>
</multipart-config>
```

## Base de données

Le projet utilise PostgreSQL comme système de gestion de base de données relationnel, offrant une solution fiable pour
le stockage et la gestion des données du blog.

## Déploiement avec Maven

Le déploiement du projet peut être effectué via Maven, en utilisant le plugin Cargo pour déployer directement sur
Tomcat. La commande suivante permet de compiler et de déployer le projet :

```bash
mvn clean package cargo:deploy
```


