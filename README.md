## Configuration de Tomcat

Ce projet tomact de configurer le multipart a 150MB
pour changer la config se rendre dans :
```bash
Program Files\Apache Software Foundation\Tomcat 9.0\webapps\manager\WEB-INF
```

Puis modifier :

```xml
    <multipart-config>
      <!-- 50MB max avant modif : 52428800 -->
      <!-- 50MB * 3 max apres modif : 157 286 400 donc 150MB -->
      <max-file-size>157286400</max-file-size>
      <max-request-size>157286400</max-request-size>
      <file-size-threshold>0</file-size-threshold>
    </multipart-config>
```