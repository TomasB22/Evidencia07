package servicio;

import interfaz.CRUD;
import modelo.Trabajador;

import java.io.*;
import java.util.ArrayList;

public class ServicioTrabajador implements CRUD {

    private Trabajador trabajador;
    private final File archivo;

    public ServicioTrabajador(String ruta) {
        this.trabajador = new Trabajador();
        this.archivo = new File(ruta);
    }

    @Override
    public boolean crear() {

        if (!archivo.exists()) {
            try {
                return archivo.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public String leer() {

        var informacion = new ArrayList<String>();
        String[] lineas;
        String cadena;

        try {
            if (!archivo.exists()) {
                throw new FileNotFoundException();
            }

            var lector = new BufferedReader(new FileReader(archivo));

            while ((cadena = lector.readLine()) != null) {
                lineas = cadena.split("\n");
                informacion.add(lineas[0]);
            }

            lector.close();

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo: " + e.getMessage());
            return null;
        } catch (IOException e) {
            System.err.println("Fallo al leer el archivo: " + e.getMessage());
        }

        return informacion.toString();
    }

    @Override
    public boolean actualizar(String nuevaData) {

        if(!archivo.exists()){
            return false;
        }
        FileWriter escritor = null;
        try {
            escritor = new FileWriter(archivo);
            escritor.write(nuevaData);
            escritor.close();
        } catch (IOException e) {
            System.err.println("Fallo al leer el archivo: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean borrar() {

        if (archivo.exists()) {
            return archivo.delete();
        }
        return false;
    }

    public boolean verificarsiTrabajadorExiste(Trabajador trabajadorBuscado) {

        return Trabajador.getTrabajadores()
                .contains(trabajadorBuscado);
    }
}


