# Aplicación Spring Boot con protección JWT
El usuario puede registrar una nueva cuenta o iniciar sesión con nombre de usuario y contraseña.<br>
Por rol del Usuario puede ser administrador, manager y usuario . De acuerdo a su rol podrá acceder a diferentes recursos.<br>
Al loguearse se creará un Jason Web Token y se almacenará en una cookie, así en cada request que se haga verificará que tiene acceso al recurso o no.Sino tiene permiso te mostrará un error. <br>
También nos podemos encontrar protección contra usuarios no autenticados que soliciten un recurso HTTP.<hr>
**Herramientas utilizadas:**<br>
-JDK Java 8<br>
-MySQL Workbench v8.0.26.0<br>
-Spring Framework
