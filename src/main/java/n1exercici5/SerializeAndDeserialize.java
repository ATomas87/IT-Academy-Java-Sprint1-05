package n1exercici5;

import java.io.*;

public class SerializeAndDeserialize {
    public static void main(String[] args) {

        if (args.length == 3) {
            String name = args[0];
            String department = args[1];
            double salary = Double.parseDouble(args[2]);
            Employee newEmployee = new Employee(name, department, salary);

            try {
                writeObjectsToFile(newEmployee);
            } catch (IOException e) {
                System.out.println("Error en la escritura del archivo.");
            }
        } else if (args.length == 1 && args[0].contains(".ser")) {
            try {
                readObjectsFromFile(args[0]);
            } catch (IOException e) {
                System.out.println("El archivo introducido no es válido.");
            }
        } else {
            System.out.println("Introduce el nombre, el departamento y el salario del empleado o la ruta del archivo .ser que quieres leer.");
        }
    }

    private static void readObjectsFromFile(String arg) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(arg);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Employee readEmployee = (Employee) ois.readObject();
            System.out.println(readEmployee.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeObjectsToFile(Employee newEmployee) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + File.separator + "employee.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(newEmployee);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
