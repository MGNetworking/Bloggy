### préambule 
Ce projet et un blog codé en Java EE sans frameWork 

Il a était développer avec les technologie suivant :
* HTML, CSS, Javascript pour la manipulation du DOM
* JDBC pour le développement des objets d’accès au données
* la JSTL et les "EL" expression langage de Java pour gestion du coté Front.   

### Configuration de Tomcat 
Pour ce projet le conteneur Tomcat a etait configurer avec un
multipart a 150MB.
La configuration ce trouve dans le repertoire :
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

goal utiliser pour maven
```bash
mvn clean package cargo:deploy
```


