package gestor_datos;

import modelo.Trabajador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;

public class GestorCSV {

    private String file=("trabajadores.csv"); //SET FILE PATH
    private ArrayList<Trabajador> trabajadores = new ArrayList<>();


    public void addTrabajador(Trabajador trabajador){
        String line=(trabajador.getNombre()+";"+trabajador.getApellido()+";"+trabajador.getRut()+";"+trabajador.getIsapre().getNombre()+";"+trabajador.getAfp().getNombre());
        tryWrite(line);
    }


    /**
     * GestorCSV, clase encargada de acceder directamente al archivo CSV y parsear los datos a un Arreglo
     */
    public GestorCSV(){
        tryRead();
    }

    private void tryWrite(String line){
        String text="null";
        try {
            text=new String(Files.readAllBytes(Path.of(file)));
            text =text+ "\n" + line;
            Files.write(Path.of(file), text.getBytes(), new OpenOption[0]);
        } catch (Exception ex) {
            System.out.println("Error, no se pudo agregar la nueva línea.");
        }
    }

    private String tryRead(){
        String text="null";
        try {
            reader(new BufferedReader(new FileReader(file)));
        } catch (Exception ex) {
            System.out.println("Error, no se pudo leer el archivo.");
            System.out.println(ex.getMessage());
        }
        return text;
    }

    private void reader(BufferedReader csvReader) throws Exception{
        String row;
        while ((row = csvReader.readLine()) != null){
            String[] data = row.split(";");
            interpreter(data);
        }
        csvReader.close();
    }


    private void interpreter(String[] data){
            modelo.Isapre isapre = new modelo.Isapre(data[3]);
            modelo.AFP afp= new modelo.AFP(data[4]);
            trabajadores.add(new Trabajador(data[0],data[1],data[2],isapre,afp));
    }


    public ArrayList<Trabajador> getTrabajadores(){
        return this.trabajadores;
    }

}