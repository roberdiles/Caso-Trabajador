package gui;

import gestor_datos.GestorDatos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Ventana extends JFrame{

    private GestorDatos gestorDatos;

    public Ventana(GestorDatos gestorDatos) {
        this.gestorDatos=gestorDatos;

        setTitle("Sistema Trabajadores");
        setPreferredSize(new Dimension(1100 ,500));
        setMinimumSize(new Dimension(1100 ,500));


        setResizable(true);
        setLocationRelativeTo(null);


        iniciarComponentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void iniciarComponentes() {

        JPanel panelNorth=panelBuscador();
        //add some labels and buttons

        JPanel panelCenter = panelTrabajadores();
        //...etc dynamically

        JPanel panelSouth =panelEditor();
        //add some labels and buttons

        JScrollPane scrollPaneCenter = new JScrollPane(panelCenter,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //panelCenter must be scrollable when too many panels are added to panelCenter


        //add everything to the main panel container
        JPanel panelContainer = new JPanel(new BorderLayout(3,3));
        panelContainer.setBorder(new EmptyBorder(5,5,5,5));
        panelContainer.add(panelNorth,BorderLayout.NORTH);
        panelContainer.add(scrollPaneCenter,BorderLayout.CENTER);
        panelContainer.add(panelSouth,BorderLayout.SOUTH);

        //add everything to frame
        this.getContentPane().add(panelContainer);
        setVisible(true);
    }

    private JPanel panelBuscador(){
        JPanel panelNorth = new JPanel(new GridLayout(1, 10));
        panelNorth.setPreferredSize(new Dimension(1000,25 ));

        JLabel nombre = new JLabel("Nombre");
        panelNorth.add(nombre);
        JLabel apellido = new JLabel("Apellido");
        panelNorth.add(apellido);
        JLabel rut = new JLabel("RUT");
        panelNorth.add(rut);
        JLabel isapre = new JLabel("Isapre");
        panelNorth.add(isapre);
        JLabel afp = new JLabel("AFP");
        panelNorth.add(afp);
        JLabel espaciador1 = new JLabel("");
        panelNorth.add(espaciador1);
        JLabel espaciador2 = new JLabel("");
        panelNorth.add(espaciador2);
        return panelNorth;
    }

    private JPanel panelTrabajadores() {
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelCenter.setPreferredSize(new Dimension(1000,500));

        for (int i=0;i<gestorDatos.getTrabajadores().size();i++) {
            JPanel temp = new JPanel(new GridLayout(1, 10));
            temp.setPreferredSize(new Dimension(1000,50));
            JLabel nombre = new JLabel(gestorDatos.getTrabajadores().get(i).getNombre());
            temp.add(nombre);
            JLabel apellido = new JLabel(gestorDatos.getTrabajadores().get(i).getApellido());
            temp.add(apellido);
            JLabel rut = new JLabel(gestorDatos.getTrabajadores().get(i).getRut());
            temp.add(rut);
            JLabel isapre = new JLabel(gestorDatos.getTrabajadores().get(i).getIsapre().getNombre());
            temp.add(isapre);
            JLabel afp = new JLabel(gestorDatos.getTrabajadores().get(i).getAfp().getNombre());
            temp.add(afp);
            JButton editar = new JButton("Editar");
            temp.add(editar);
            JButton borrar = new JButton("Borrar");

            temp.add(borrar);
            

            panelCenter.add(temp);
        }

        return panelCenter;
    }

    private JPanel panelEditor() {
        JPanel panelSouth = new JPanel(new GridBagLayout());
        panelSouth.setPreferredSize(new Dimension(1000,100));
        return panelSouth;
    }

}
