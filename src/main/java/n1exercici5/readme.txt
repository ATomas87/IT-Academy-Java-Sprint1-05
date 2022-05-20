El programa ya está compilado, por lo que para poder usarlo sólo hay que dirigirse a la carpeta src/main/java en el terminal y,
desde allí, ejecutar el comando "java n1exercici5.SerializeAndDeserialize <nombre> <departamento> <salario> | <Ruta del archivo .ser a leer>".

Hay que tener en cuenta que la variable de entorno PATH debe incluir los binarios Java. En caso de no ser así hay que ejecutar el programa
introduciendo toda la ruta del binario Java junto con la ruta del archivo niexercici4.ListDirectoryRecursiveToFileAndTxtReader.

El archivo con los resultados se guarda en el directorio del usuario con el nombre "employee.ser".

Ejemplos:

java n1exercici5.SerializeAndDeserialize Antonio Desarrollo 1700

java n1exercici5.SerializeAndDeserialize C:\Users\Antonio\employee.ser