El programa ya está compilado, por lo que para poder usarlo sólo hay que dirigirse a la carpeta src/main/java en el terminal y,
desde allí, ejecutar el comando "java n2exercici1.JavaPropertiesReader".

Hay que tener en cuenta que la variable de entorno PATH debe incluir los binarios Java. En caso de no ser así hay que ejecutar el programa
introduciendo toda la ruta del binario Java junto con la ruta del archivo n2exercici1.JavaPropertiesReader.

En el archivo config.properties se pueden editar las rutas de los directorios de origen y destino, así como el nombre del fichero resultante.
El archivo config.properties se ha añadido en el mismo paquete en lugar de en la carpeta resources porque desde el terminal la JVM no encontraba
correctamente el archivo.