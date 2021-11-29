package gestor_datos;

import modelo.Trabajador;

import java.util.ArrayList;

public class GestorDatos {

    private ArrayList<Trabajador> trabajadores;

    /**
     * Clase GestorDatos encargada de gestionar los datos recibidos del CSV
     */
    public GestorDatos(){
        GestorCSV csvManager= new GestorCSV();
        this.trabajadores=csvManager.getTrabajadores();

    }


    /*
    public int seleccionar() {
        Scanner teclado = new Scanner(System.in);
        //String[] datos = lista();
        int respuesta;
        do {
            System.out.println("¿Que alimento desea ver?");
            respuesta = teclado.nextInt();
        } while (respuesta > 9 || respuesta<0);
        return respuesta;
    }
    Aun no se implementa
     */




    /**
     * Metodo getEtiquetadas, recibe el parametro etiqueta y devuelve un arreglo de todos los objetos que coincidan con la etiqueta
     * @param etiqueta Tipo vegano/vegetariano
     * @return retorna el arreglo con los objetos coincidentes con la etiqueta dada
     */
    /*
    public ArrayList<Trabajador> getEtiquetadas(Etiqueta etiqueta){
        ArrayList<Trabajador> temp= new ArrayList<>();
        for (int i=0;i<trabajadores.size();i++) {
            if (trabajadores.get(i).getEtiqueta()==etiqueta) {
                temp.add(trabajadores.get(i));
            }
        }
        return temp;
    }

    public ArrayList<Trabajador> getTipo(Tipo tipo){
        ArrayList<Trabajador> temp= new ArrayList<>();
        for (int i=0;i<trabajadores.size();i++) {
            if (trabajadores.get(i).getTipo()==tipo) {
                temp.add(trabajadores.get(i));
            }
        }
        return temp;
    }
    */

    /**
     * Metodo mostrarLista, recibe un Arreglo de objeto trabajador e imprime todos los objetos de la lista
     * @param lista Lista de objetos a imprimir
     */
    public String mostrarLista(ArrayList<Trabajador> lista){
        String temp="";
        for (int i=0;i<lista.size();i++){
            temp+=(lista.get(i).toString())+"\n";
        }
        return temp;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
}