# Alkemy Challenge - Mundo Disney

Hola! Esta es mi resolucion al challenge propuesto por Alkemy para la pre-aceleracion del curso de backend con JAVA Spring boot.

### ¿Cual es el objetivo de este challenge?

Desarrollar una API para explorar el mundo de Disney, la cual permitirá conocer y modificar los personajes que lo componen y entender en qué películas estos participaron. Por otro lado, deberá
exponer la información para que cualquier frontend pueda consumirla.

### ¿Que necesito para correr este proyecto?

- Este proyecto esta configurado para correr en JAVA 8 y Maven.
- Tener instalada alguna base de datos. Por default, el proyecto va a buscar una base de datos MariaDB, que es la que yo uso. Pero podes cambiar esto modificando el archivo application.properties e instalando el driver para la base de datos que desees en Maven.
- Para testear los endpoints, recomiendo usar Postman.

### IMPORTANTE:
  
  - Para correr este proyecto, necesitas copiar algunas variables de entorno.
  ¿Como se hace?
  ```shell
  
  - Dirigite a la carpeta /src/main/resources.
  - Alli, ejecuta el comando
    En Linux: cp .env.example .env
    En windows: simplemente podes copiar el archivo .env.example en otro llamado .env
  - Una vez que las copiaste, podes cambiar el valor de la clave JWT_SECRET por el que vos desees.
  ```
  
  - En caso de que uses otro tipo de base de datos. En el archivo application.properties anteriormente mencionado, podes cambiar la configuracion del acceso a la base de datos. Algunos tips:
  
  ```shell
    spring.datasource.url=jdbc:mariadb://localhost:3306/disney --> Aca podes configurar el puerto y la base de datos a la que queres acceder. En este caso es puerto 3306 y base de datos disney.
    spring.datasource.username=root --> Aca indicas el username que configuraste a tu base de datos.
    spring.datasource.password=root --> Aca indicas el password que configuraste a tu base de datos.
  
  Estas son properties basicas para hacer correr el proyecto, para profundizar mas podes consultar la documentacion oficial de Spring Boot.
  ```
  
  - Para probar los endpoints.
  
    En Postman, podes importar la coleccion de request que genere cuando desarrollaba el proyecto. Para hacer esto, podes consultar en la documentacion oficial de postman
    [acá.](https://learning.postman.com/docs/getting-started/importing-and-exporting-data/#importing-data-into-postman)
    El archivo que buscas para importar dicha coleccion se encuentra en la carpeta /src/main/resources.
  
  
  





