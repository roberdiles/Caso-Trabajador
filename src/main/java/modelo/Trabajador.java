package modelo;

public class Trabajador extends Persona {

    private String rut;
    private Isapre isapre;
    private AFP afp;

    public Trabajador(String nombre, String apellido, String rut, Isapre isapre, AFP afp) {
        super(nombre, apellido);
        this.rut = rut;
        this.isapre = isapre;
        this.afp = afp;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Isapre getIsapre() {
        return isapre;
    }

    public void setIsapre(Isapre isapre) {
        this.isapre = isapre;
    }

    public AFP getAfp() {
        return afp;
    }

    public void setAfp(AFP afp) {
        this.afp = afp;
    }

    @Override
    public String toString(){
        return ("Nombre Completo: "+nombre+" "+apellido +" | RUT: "+rut);
    }
}
