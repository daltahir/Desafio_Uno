# DesafioPrevired
<h2>Tecnología: </h2>
<ul><li>Java Enterprise</li>
  <li>Spring boot 2.5.6</li></ul>
  <h2>Prerequisitos</h2>
    <ul><li>java jdk 1.8 u OpenJdk8</li>
  <li>docker (Opcional)</li>
  <li>Maven 3</li>
  </ul>
  
<h2>Instalación</h2>
<li>Compilar proyecto</li>
<code>mvn package</code>
<li>Probar con Docker (alpine + openjre8):</li>
<code>docker build -t desafio1 .</code>
<li>Ejecutar imagen:</li>
<code>docker run -d -p8090:8090 desafio1</code>
<li>Probar con java directamente:</li>
<code>cd "rutadeproyecto"/target<br>
java -jar desafiouno-0.0.1-SNAPSHOT.jar
</code>


<h2>invocación</h2>
<b>/api/v1/faltantes</b>
<code>
curl --location --request GET 'http://127.0.0.1:8090/api/v1/faltantes' \
--header 'Content-Type: application/json' \
--data-raw '{"url": "http://ip-de-servicio-gdd:8080/periodos/api"}'</code>
<i>en el body debe enviarse la url del servicio de generación de datos<i>

<b>documentación</b>
<code>
http://localhost:8090/swagger-ui/index.html
</code>
