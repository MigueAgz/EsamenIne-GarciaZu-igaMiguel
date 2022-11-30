package examenpdf;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDF extends JFrame {

    private JPanel ventana;
    private JButton boton1;
    private JTextField nombre, domicilio, clave, curp, estado, mun, localidad, emision, vigencia;

    public PDF() {

        super("Credencial de lector"); //Creacion de ventana
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(90, 241, 211));
        Image icono = new ImageIcon(getClass().getResource("imagenes/credencial.jpg")).getImage();
        setIconImage(icono);
        setVisible(true);

        Ejecutar();
    }

    private void Ejecutar() {
        Ventanas();
        Etiquetas();
        Datos();
        Boton1();
    }

    private void Ventanas() {
        ventana = new JPanel();
        ventana.setLayout(null);
        this.getContentPane().add(ventana);

    }

    private void Etiquetas() {

        //ETIQUETA PARA EL TITULO       
        JLabel et = new JLabel();
        et.setText("INSERTAR DATOS");
        et.setBounds(230, 1, 600, 100);
        et.setForeground(Color.cyan);
        et.setFont(new Font("Times new roman", 100, 40));
        ventana.add(et);

        // ETIQUETA PARA EL NOMBRE
        JLabel et1 = new JLabel();
        et1.setText("Nombre Completo: ");
        et1.setBounds(60, 50, 600, 100);
        et1.setForeground(Color.BLACK);
        et1.setFont(new Font("Arial", Font.ITALIC, 18));
        ventana.add(et1);

        //ETIQUETA PARA EL DOMICILIO
        JLabel et2 = new JLabel();
        et2.setText("Domicilio: ");
        et2.setBounds(60, 80, 600, 100);
        et2.setForeground(Color.BLACK);
        et2.setFont(new Font("Arial", Font.ITALIC, 18));
        ventana.add(et2);

        //ETIQUETA PARA LA CLAVE DE ELECTOR
        JLabel et3 = new JLabel();
        et3.setText("Clave de elector: ");
        et3.setBounds(60, 110, 600, 100);
        et3.setForeground(Color.BLACK);
        et3.setFont(new Font("Arial", Font.ITALIC, 18));
        ventana.add(et3);

        //ETIQUETA DE LA CURP
        JLabel et4 = new JLabel();
        et4.setText("CURP: ");
        et4.setBounds(60, 140, 600, 100);
        et4.setForeground(Color.BLACK);
        et4.setFont(new Font("Arial", Font.ITALIC, 18));
        ventana.add(et4);

        //ETIQUETA PARA EL ESTADO
        JLabel et5 = new JLabel();
        et5.setText("Estado: ");
        et5.setBounds(60, 170, 600, 100);
        et5.setForeground(Color.BLACK);
        et5.setFont(new Font("Arial", Font.ITALIC, 18));
        ventana.add(et5);

        //ETIQUETA PARA EL MUNICIPIO
        JLabel et6 = new JLabel();
        et6.setText("Municipio: ");
        et6.setBounds(60, 200, 600, 100);
        et6.setForeground(Color.BLACK);
        et6.setFont(new Font("Arial", Font.ITALIC, 18));
        ventana.add(et6);

        //ETIQUETA PARA LA LOCALIDAD
        JLabel et7 = new JLabel();
        et7.setText("Localidad ");
        et7.setBounds(60, 230, 600, 100);
        et7.setForeground(Color.BLACK);
        et7.setFont(new Font("Arial", Font.ITALIC, 18));
        ventana.add(et7);

        //ETIQUETA DE EMISION
        JLabel et8 = new JLabel();
        et8.setText("Emision: ");
        et8.setBounds(60, 260, 600, 100);
        et8.setForeground(Color.BLACK);
        et8.setFont(new Font("Arial", Font.ITALIC, 18));
        ventana.add(et8);

        //ETIQUETA PARA LA VIGENCIA
        JLabel et9 = new JLabel();
        et9.setText("Vigencia: ");
        et9.setBounds(60, 290, 600, 100);
        et9.setForeground(Color.BLACK);
        et9.setFont(new Font("Arial", Font.ITALIC, 18));
        ventana.add(et9);

    }

    private void Datos() {

        //NOMBRE
        nombre = new JTextField();
        nombre.setBounds(220, 90, 500, 20);
        ventana.add(nombre);

        //DOMICILIO
        domicilio = new JTextField();
        domicilio.setBounds(160, 120, 500, 20);
        ventana.add(domicilio);

        //CLAVE DE ELECTOR
        clave = new JTextField();
        clave.setBounds(210, 150, 500, 20);
        ventana.add(clave);

        //CURP
        curp = new JTextField();
        curp.setBounds(120, 180, 500, 20);
        ventana.add(curp);

        //ESTADO
        estado = new JTextField();
        estado.setBounds(130, 210, 500, 20);
        ventana.add(estado);

        //MUNICIPIO
        mun = new JTextField();
        mun.setBounds(150, 240, 500, 20);
        ventana.add(mun);

        //LOCALIDAD
        localidad = new JTextField();
        localidad.setBounds(150, 270, 500, 20);
        ventana.add(localidad);

        //EMISION
        emision = new JTextField();
        emision.setBounds(140, 300, 500, 20);
        ventana.add(emision);

        //VIGENCIA
        vigencia = new JTextField();
        vigencia.setBounds(140, 330, 500, 20);
        ventana.add(vigencia);
    }

    private void Boton1() {

        boton1 = new JButton("Abrir PDF");
        boton1.setBounds(480, 400, 120, 40);
        boton1.setForeground(java.awt.Color.MAGENTA);
        boton1.setFont(new java.awt.Font("Baskerville", java.awt.Font.PLAIN, 15));
        boton1.setEnabled(true);
        ventana.add(boton1);

        ActionListener accion = new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

             CrearYAbrir();

            }
        };

        boton1.addActionListener(accion);

    }

    public void CrearYAbrir() {

        String imagen = "/Users/jovanadiaz/Desktop/MIKI.jpg";
                try {
                    PDDocument documento = new PDDocument();
                    PDRectangle mypage = new PDRectangle(800, 850);
                    PDPage pagina = new PDPage(mypage);
                    documento.addPage(pagina);

                    PDImageXObject image = PDImageXObject.createFromFile(imagen, documento);
                    PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                    contenido.drawImage(image, 90, 60, 600, 700);

                    //----------domicilio----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 14);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(355, pagina.getMediaBox().getHeight() - 270);
                    contenido.showText(domicilio.getText());
                    contenido.endText();
                    
                    
                    //----------Paterno----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 14);
                    contenido.newLineAtOffset(285, pagina.getMediaBox().getHeight() - 200);
                    contenido.showText(nombre.getText());
                    contenido.endText();


                    

                    

                    //----------Colonia y Codigo Postal----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 14);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(285, pagina.getMediaBox().getHeight() - 286);
                    contenido.showText(clave.getText());
                    contenido.endText();

                    //----------Número del municipio----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 11);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(485, pagina.getMediaBox().getHeight() - 360);
                    contenido.showText(curp.getText());
                    contenido.endText();

                    //----------CURP----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(330, pagina.getMediaBox().getHeight() - 337);
                    contenido.showText(estado.getText());
                    contenido.endText();

                    //----------Fecha de Nacimiento----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 14);
                    contenido.newLineAtOffset(600, pagina.getMediaBox().getHeight() - 200);
                    contenido.showText(mun.getText());
                    contenido.endText();

                    //----------Sexo----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contenido.newLineAtOffset(655, pagina.getMediaBox().getHeight() - 215);
                    contenido.showText(localidad.getText());
                    contenido.endText();

                    //----------Clave de elector----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contenido.newLineAtOffset(410, pagina.getMediaBox().getHeight() - 318);
                    contenido.showText(emision.getText());
                    contenido.endText();

                    //----------Año----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(635, pagina.getMediaBox().getHeight() - 335);
                    contenido.showText(vigencia.getText());
                    contenido.endText();

                  
                    contenido.close();

                    documento.save("/Users/jovanadiaz/Desktop/INEGZ.pdf");

                } catch (Exception x) {
                    System.out.println("Error: " + x.getMessage().toString());
                }
                
                ////////////////////////////////
                try {
                    File path = new File("/Users/jovanadiaz/Desktop/INEGZ.pdf");
                    Desktop.getDesktop().open(path);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }

}
