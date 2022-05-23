El programa ya está compilado, por lo que para poder usarlo sólo hay que dirigirse a la carpeta src/main/java en el terminal y,
desde allí, ejecutar el comando "java n3exercici1.Main".

Hay que tener en cuenta que la variable de entorno PATH debe incluir los binarios Java. En caso de no ser así hay que ejecutar el programa
introduciendo toda la ruta del binario Java junto con la ruta del archivo n3exercici1.Main.

En el archivo config.properties se pueden editar las rutas de los directorios de origen y destino, así como los nombres de los ficheros:
    -El parámetro readFileName del archivo config.properties hace referencia al archivo que se quiere encriptar.
    -El parámetro encryptedFileName hace referencia al nombre del archivo encriptado resultante de la encriptación.
    -El parámetro decruptedFileName hace referencia al nombre del arvhico desencriptado resultante de la desencriptación.

El archivo config.properties se ha añadido en el mismo paquete en lugar de en la carpeta resources porque desde el terminal la JVM no encontraba
correctamente el archivo.