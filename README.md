### préambule 
Ce projet et un ECF : évaluation en cours de formation
Le sujet libre, j’ai donc choisi de créer un site web de type blog 
en Java EE. 

Il a était développer avec les technologie suivant :
* JDBC pour le développement des objets d’accès au données
* la JSTL et EL pour gestion du coté Front

Il ne contient aucun Framework et permet de voir le fonctionnement des bases 
en programmation. Ce projet n’a pas pour but de d’être mis en production dans l’état.    

### Configuration de Tomcat 
Pour ce projet il faut configurer Tomcat le multipart a 150MB
Pour changer la config se rendre dans :
```bash
Program Files\Apache Software Foundation\Tomcat 9.0\webapps\manager\WEB-INF
```

Puis modifier :

```xml
    <multipart-config>
      <!-- 50MB max avant modification : 52428800 -->
      <!-- 50MB * 3 max après modification : 157 286 400 donc 150MB -->
      <max-file-size>157286400</max-file-size>
      <max-request-size>157286400</max-request-size>
      <file-size-threshold>0</file-size-threshold>
    </multipart-config>
```

Ce projet fonctionne avec une base de donnes postgres.
Vous trouverez un backup dans le repertoire 
* db => Backup-Webblog-postgreSQL

goal utiliser pour maven
```bash
mvn clean package cargo:deploy
```

Mot de passe Teste
* Nom : fabien
* Prenom : fabienFirstName
* Password : 123456

