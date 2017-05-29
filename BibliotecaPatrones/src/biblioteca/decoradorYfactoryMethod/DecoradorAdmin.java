package biblioteca.decoradorYfactoryMethod;

import biblioteca.composite.BookComponent;
import biblioteca.composite.JuegoDeMesa;
import biblioteca.composite.Libro;
import biblioteca.composite.Revista;
import biblioteca.decoradorYfactoryMethod.Administrador;
import biblioteca.decoradorYfactoryMethod.Usuario;
import biblioteca.singleton.Biblioteca;
import java.awt.*; 

import javax.swing.*; 

import java.awt.event.*; 

public class DecoradorAdmin extends DecoradorGeneral implements ActionListener{
    JFrame frame; 
    protected JButton botonbibliotecario1,botonbibliotecario2,botonbibliotecario3,logout,btnagregarlibro,btnagregarrevista,btnagregarmesa;
    String usuario;
    private JComboBox combo;
    JLabel userLabel, label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17,label18,label19,label20;
    JTextArea textarea1;
    JScrollPane scrollpane1,scrollpane2;
    JTextField textfield1 ,tflibroclave,tflibronombre,tflibroautor,tflibroeditor,tflibrogenero,tflibroprecio,tflibrocantidad,tfrevistaclave,tfrevistanombre,tfrevistadescripcion,tfrevistaeditorial,tfrevistaprecio,tfrevistaexistencia,tfmesaclave,tfmesanombre,tfmesadescripcion,tfmesaestado,tfmesaprecio,tfmesaexistencia; 
    String libroclave,libronombre,libroautor,libroeditor,librogenero,revistaclave,revistanombre,revistadescripcion,revistaeditorial,mesaclave,mesanombre,mesadescripcion,mesaestado;
    double libroprecio,revistaprecio,mesaprecio;
    int librocantidad,revistaexistencia,mesaexistencia;

    Usuario admin; 
    
    JPanel panel = new JPanel();
    public DecoradorAdmin(Decorador usu) { 
        super(usu); 

        dameframe().setSize(600, 700); 
        u.dametitulo().setText(getNombre()); 
        dibujar();
    }

    @Override
    public void dibujar() {
        textarea1=new JTextArea();
        scrollpane1=new JScrollPane(textarea1);    
        scrollpane1.setBounds(300,60,220,170);

        botonbibliotecario1 = new JButton("Agregar libro");
        botonbibliotecario1.setBounds(40, 120, 220, 20);

        botonbibliotecario2 = new JButton("Agregar Coleccion");
        botonbibliotecario2.setBounds(40, 160, 220, 20);
        botonbibliotecario2.setVisible(false);

        combo = new JComboBox();
        combo.addItem("Agregar Libro");
        combo.addItem("Agregar Revista");
        combo.addItem("Agregar Juego de Mesa");
        combo.setBounds(40, 120, 220, 20); 

        btnagregarlibro= new JButton("Agregar");
        btnagregarlibro.setBounds(370, 550, 100, 30); 
        btnagregarlibro.setVisible(false);

        btnagregarrevista= new JButton("Agregar");
        btnagregarrevista.setBounds(370, 550, 100, 30); 
        btnagregarrevista.setVisible(false);

        btnagregarmesa= new JButton("Agregar");
        btnagregarmesa.setBounds(370, 550, 100, 30); 
        btnagregarmesa.setVisible(false);

        
        
        label2 = new JLabel("Ingrese clave");
        label2.setBounds(5, 320, 160, 25);
        label2.setVisible(false);
        tflibroclave=new JTextField();
        tflibroclave.setBounds(170,320,150,30);
        tflibroclave.setVisible(false);

        label3 = new JLabel("Ingrese nombre");
        label3.setBounds(5, 350, 160, 25);
        label3.setVisible(false);

        tflibronombre=new JTextField();
        tflibronombre.setBounds(170,350,150,30);
        tflibronombre.setVisible(false);
        label4 = new JLabel("Ingrese autor");
        label4.setBounds(5, 380, 160, 25);
        label4.setVisible(false);	
        tflibroautor=new JTextField();
        tflibroautor.setBounds(170,380,150,30);
        tflibroautor.setVisible(false);

        label5 = new JLabel("Ingrese editor");
        label5.setBounds(5, 410, 160, 25);
        label5.setVisible(false);	
        tflibroeditor=new JTextField();
        tflibroeditor.setBounds(170,410,150,30);
        tflibroeditor.setVisible(false);

        label6 = new JLabel("Ingrese genero");
        label6.setBounds(5, 440, 160, 25);
        label6.setVisible(false);	
        tflibrogenero=new JTextField();
        tflibrogenero.setBounds(170,440,150,30);
        tflibrogenero.setVisible(false);

        label7 = new JLabel("Ingrese precio");
        label7.setBounds(5, 470, 160, 25);
        label7.setVisible(false);	
        tflibroprecio=new JTextField();
        tflibroprecio.setBounds(170,470,150,30);
        tflibroprecio.setVisible(false);

        label8 = new JLabel("Ingrese cantidad de libros");
        label8.setBounds(5, 510, 160, 25);
        label8.setVisible(false);	
        tflibrocantidad=new JTextField();
        tflibrocantidad.setBounds(170,510,150,30);
        tflibrocantidad.setVisible(false);

        
        /// Aqui termina lo de libros y empieza las revistas

        label9 = new JLabel("Ingrese clave");
        label9.setBounds(5, 320, 160, 25);
        label9.setVisible(false);
        tfrevistaclave=new JTextField();
        tfrevistaclave.setBounds(170,320,150,30);
        tfrevistaclave.setVisible(false);

        label10 = new JLabel("Ingrese nombre");
        label10.setBounds(5, 350, 160, 25);
        label10.setVisible(false);

        tfrevistanombre=new JTextField();
        tfrevistanombre.setBounds(170,350,150,30);
        tfrevistanombre.setVisible(false);
        label11 = new JLabel("Ingrese descripcion");
        label11.setBounds(5, 380, 160, 25);
        label11.setVisible(false);	
        tfrevistadescripcion=new JTextField();
        tfrevistadescripcion.setBounds(170,380,150,30);
        tfrevistadescripcion.setVisible(false);

        label12 = new JLabel("Ingrese editorial");
        label12.setBounds(5, 410, 160, 25);
        label12.setVisible(false);	
        tfrevistaeditorial=new JTextField();
        tfrevistaeditorial.setBounds(170,410,150,30);
        tfrevistaeditorial.setVisible(false);

        label13 = new JLabel("Ingrese precio");
        label13.setBounds(5, 440, 160, 25);
        label13.setVisible(false);	
        tfrevistaprecio=new JTextField();
        tfrevistaprecio.setBounds(170,440,150,30);
        tfrevistaprecio.setVisible(false);

        label14 = new JLabel("Ingrese existencia");
        label14.setBounds(5, 470, 160, 25);
        label14.setVisible(false);	
        tfrevistaexistencia=new JTextField();
        tfrevistaexistencia.setBounds(170,470,150,30);
        tfrevistaexistencia.setVisible(false);

        botonbibliotecario1.addActionListener(this);
        botonbibliotecario2.addActionListener(this);
        btnagregarlibro.addActionListener(this);
        combo.addActionListener(this);                 

        btnagregarrevista.addActionListener(this);
        btnagregarmesa.addActionListener(this);

        dameboton().setVisible(false);
        dameboton2().setVisible(false);
        //u.agregar(botonbibliotecario1);

        //elementos de uegos de mesa

        label15 = new JLabel("Ingrese clave");
        label15.setBounds(5, 320, 160, 25);
        label15.setVisible(false);
        tfmesaclave=new JTextField();
        tfmesaclave.setBounds(170,320,150,30);
        tfmesaclave.setVisible(false);

        label16 = new JLabel("Ingrese nombre");
        label16.setBounds(5, 350, 160, 25);
        label16.setVisible(false);

        tfmesanombre=new JTextField();
        tfmesanombre.setBounds(170,350,150,30);
        tfmesanombre.setVisible(false);
        label17 = new JLabel("Ingrese descripcion");
        label17.setBounds(5, 380, 160, 25);
        label17.setVisible(false);	
        tfmesadescripcion=new JTextField();
        tfmesadescripcion.setBounds(170,380,150,30);
        tfmesadescripcion.setVisible(false);

        label18 = new JLabel("Ingrese estado");
        label18.setBounds(5, 410, 160, 25);
        label18.setVisible(false);	
        tfmesaestado=new JTextField();
        tfmesaestado.setBounds(170,410,150,30);
        tfmesaestado.setVisible(false);

        label19 = new JLabel("Ingrese precio");
        label19.setBounds(5, 440, 160, 25);
        label19.setVisible(false);	
        tfmesaprecio=new JTextField();
        tfmesaprecio.setBounds(170,440,150,30);
        tfmesaprecio.setVisible(false);

        label20 = new JLabel("Ingrese existencia");
        label20.setBounds(5, 470, 160, 25);
        label20.setVisible(false);	
        tfmesaexistencia=new JTextField();
        tfmesaexistencia.setBounds(170,470,150,30);
        tfmesaexistencia.setVisible(false);

        
        u.agregar(botonbibliotecario2);
        u.agregar(combo); 
        u.agregar(btnagregarlibro); 
        u.agregar(label2); 
        u.agregar(tflibroclave); 

        u.agregar(label3); 
        u.agregar(tflibronombre); 
        u.agregar(label4); 
        u.agregar(tflibroautor); 
        u.agregar(label5); 
        u.agregar(tflibroeditor); 
        u.agregar(label6); 
        u.agregar(tflibrogenero); 
        u.agregar(label7); 
        u.agregar(tflibroprecio); 
        u.agregar(label8); 
        u.agregar(tflibrocantidad);

        u.agregar(label9); 
        u.agregar(label10); 
        u.agregar(label11); 
        u.agregar(label12); 
        u.agregar(label13);  
        u.agregar(label14);
        u.agregar(tfrevistaclave);
        u.agregar(tfrevistanombre);
        u.agregar(tfrevistadescripcion);
        u.agregar(tfrevistaeditorial);
        u.agregar(tfrevistaprecio);
        u.agregar(tfrevistaexistencia);

        u.agregar(label15); 
        u.agregar(label16); 
        u.agregar(label17); 
        u.agregar(label18); 
        u.agregar(label19);  
        u.agregar(label20);
        u.agregar(tfmesaclave);
        u.agregar(tfmesanombre);
        u.agregar(tfmesadescripcion);
        u.agregar(tfmesaestado);
        u.agregar(tfmesaprecio);
        u.agregar(tfmesaexistencia);

        u.agregar(btnagregarrevista);
        u.agregar(btnagregarmesa); 

    }

    @Override
    public String getNombre() {
        return "Administrador:";
    }

    @Override
    public void agregar(Component c) {  
    }

    @Override
    public JLabel dametitulo() { 
        return userLabel;
    }

    @Override
    public JFrame dameframe() { 
        return u.dameframe();
    }

    @Override
    public JButton dameboton() { 
        return u.dameboton();
    }

    @Override
    public JButton dameboton2() { 
        return u.dameboton2();
    }

    @Override
    public void cerrar(){
        u.getUser().logout();
        u.dameframe().dispose();
    }

    @Override
    public Usuario getUser(){
        return u.getUser();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==botonbibliotecario2){

            //textarea1.append(b.getNombreBiblioteca());
            //textarea1.append(b.contenidoToString());
        }  
        if(ae.getSource()==btnagregarlibro){
            BookComponent c=u.getSeleccionado();
                if(c.getClave().equalsIgnoreCase("null")){
                    JOptionPane.showMessageDialog(combo, "Seleccione una coleccion a la cual agregar el Libro");
                }else{
            libroclave = tflibroclave.getText();
            libronombre = tflibronombre.getText(); 
            libroautor = tflibroautor.getText();  
            libroeditor = tflibroeditor.getText(); 
            librogenero = tflibrogenero.getText();

            try{
            libroprecio = Double.parseDouble(tflibroprecio.getText());
            librocantidad =Integer.parseInt(tflibrocantidad.getText()); 
            }catch(Exception e){
            }
            
                    Biblioteca b=Biblioteca.getInstance();
                    b.agregar(u.getSeleccionado(), new Libro(libroclave, libronombre, libroautor, libroeditor, librogenero, libroprecio, librocantidad));
                    JOptionPane.showMessageDialog(combo, "Elemento agregado");
                }
        } 
         
        if(ae.getSource()==btnagregarrevista){
            BookComponent c= u.getSeleccionado();
            if(c.getClave().equalsIgnoreCase("null")){
                JOptionPane.showMessageDialog(combo, "Seleccione una coleccion a la cual agregar el Libro");
            }else{
            revistaclave = tfrevistaclave.getText(); 
            revistanombre = tfrevistanombre.getText();
            revistadescripcion = tfrevistadescripcion.getText();
            revistaeditorial = tfrevistaeditorial.getText();
            try{revistaprecio =  Double.parseDouble(tfrevistaprecio.getText());
            revistaexistencia = Integer.parseInt(tfrevistaexistencia.getText());
            }catch(Exception e){}
                    Biblioteca b=Biblioteca.getInstance();
                    b.agregar(u.getSeleccionado(), new Revista(revistaclave,revistanombre,revistaprecio));
                    JOptionPane.showMessageDialog(combo, "Elemento agregado");
            
            }
        } 
         
        if(ae.getSource()==btnagregarmesa){
            BookComponent c= u.getSeleccionado();
            if(c.getClave().equalsIgnoreCase("null")){
                JOptionPane.showMessageDialog(combo, "Seleccione una coleccion a la cual agregar el Libro");
            }else{
            mesaclave = tfmesaclave.getText(); 
            mesanombre = tfmesanombre.getText(); 
            mesadescripcion = tfmesadescripcion.getText(); 
            mesaestado = tfmesaestado.getText(); 
            try{mesaprecio = Double.parseDouble(tfmesaprecio.getText());
            mesaexistencia = Integer.parseInt(tfmesaexistencia.getText());
            }catch(Exception e){}
                    Biblioteca b=Biblioteca.getInstance();
                    b.agregar(u.getSeleccionado(), new JuegoDeMesa(mesaclave, mesanombre));
                    JOptionPane.showMessageDialog(combo, "Elemento agregado");
            
            }

        } 
         
        if(ae.getSource()==combo){
            if(combo.getSelectedIndex() == 0){
                label2.setVisible(true);	
                tflibroclave.setVisible(true);
                label3.setVisible(true);	
                tflibronombre.setVisible(true);
                label4.setVisible(true);	
                tflibroautor.setVisible(true);
                label4.setVisible(true);	
                tflibroautor.setVisible(true);
                label5.setVisible(true);	
                tflibroeditor.setVisible(true);
                label6.setVisible(true);	
                tflibrogenero.setVisible(true);
                label7.setVisible(true);	
                tflibroprecio.setVisible(true);
                label8.setVisible(true);	
                tflibrocantidad.setVisible(true);

                btnagregarlibro.setVisible(true);

                btnagregarrevista.setVisible(false);
                btnagregarmesa.setVisible(false); 

                label9.setVisible(false); 
                label10.setVisible(false); 
                label11.setVisible(false); 
                label12.setVisible(false); 
                label13.setVisible(false);  
                label14.setVisible(false);
                tfrevistaclave.setVisible(false);
                tfrevistanombre.setVisible(false);
                tfrevistadescripcion.setVisible(false);
                tfrevistaeditorial.setVisible(false);
                tfrevistaprecio.setVisible(false);
                tfrevistaexistencia.setVisible(false);

                label15.setVisible(false); 
                label16.setVisible(false); 
                label17.setVisible(false); 
                label18.setVisible(false); 
                label19.setVisible(false);  
                label20.setVisible(false);
                tfmesaclave.setVisible(false);
                tfmesanombre.setVisible(false);
                tfmesadescripcion.setVisible(false);
                tfmesaestado.setVisible(false);
                tfmesaprecio.setVisible(false);
                tfmesaexistencia.setVisible(false);   
            } 
        } 

        if(ae.getSource()==combo){
            if(combo.getSelectedIndex() == 1){
                label2.setVisible(false);	
                tflibroclave.setVisible(false);
                label3.setVisible(false);	
                tflibronombre.setVisible(false);
                label4.setVisible(false);	
                tflibroautor.setVisible(false);
                label4.setVisible(false);	
                tflibroautor.setVisible(false);
                label5.setVisible(false);	
                tflibroeditor.setVisible(false);
                label6.setVisible(false);	
                tflibrogenero.setVisible(false);
                label7.setVisible(false);	
                tflibroprecio.setVisible(false);
                label8.setVisible(false);	
                tflibrocantidad.setVisible(false);

                btnagregarlibro.setVisible(false);
                btnagregarrevista.setVisible(true);
                btnagregarmesa.setVisible(false);

                label9.setVisible(true); 
                label10.setVisible(true); 
                label11.setVisible(true); 
                label12.setVisible(true); 
                label13.setVisible(true);  
                label14.setVisible(true);
                tfrevistaclave.setVisible(true);
                tfrevistanombre.setVisible(true);
                tfrevistadescripcion.setVisible(true);
                tfrevistaeditorial.setVisible(true);
                tfrevistaprecio.setVisible(true);
                tfrevistaexistencia.setVisible(true);

                label15.setVisible(false); 
                label16.setVisible(false); 
                label17.setVisible(false); 
                label18.setVisible(false); 
                label19.setVisible(false);  
                label20.setVisible(false);
                tfmesaclave.setVisible(false);
                tfmesanombre.setVisible(false);
                tfmesadescripcion.setVisible(false);
                tfmesaestado.setVisible(false);
                tfmesaprecio.setVisible(false);
                tfmesaexistencia.setVisible(false);

            } 
        } 

         
         
        if(ae.getSource()==combo){
            if(combo.getSelectedIndex() == 2){
                label2.setVisible(false);	
                tflibroclave.setVisible(false);
                label3.setVisible(false);	
                tflibronombre.setVisible(false);
                label4.setVisible(false);	
                tflibroautor.setVisible(false);
                label4.setVisible(false);	
                tflibroautor.setVisible(false);
                label5.setVisible(false);	
                tflibroeditor.setVisible(false);
                label6.setVisible(false);	
                tflibrogenero.setVisible(false);
                label7.setVisible(false);	
                tflibroprecio.setVisible(false);
                label8.setVisible(false);	
                tflibrocantidad.setVisible(false);

                btnagregarlibro.setVisible(false);
                btnagregarrevista.setVisible(false);
                btnagregarmesa.setVisible(true);

                label15.setVisible(true); 
                label16.setVisible(true); 
                label17.setVisible(true); 
                label18.setVisible(true); 
                label19.setVisible(true);  
                label20.setVisible(true);
                tfmesaclave.setVisible(true);
                tfmesanombre.setVisible(true);
                tfmesadescripcion.setVisible(true);
                tfmesaestado.setVisible(true);
                tfmesaprecio.setVisible(true);
                tfmesaexistencia.setVisible(true);

                label9.setVisible(false); 
                label10.setVisible(false); 
                label11.setVisible(false); 
                label12.setVisible(false); 
                label13.setVisible(false);  
                label14.setVisible(false);
                tfrevistaclave.setVisible(false);
                tfrevistanombre.setVisible(false);
                tfrevistadescripcion.setVisible(false);
                tfrevistaeditorial.setVisible(false);
                tfrevistaprecio.setVisible(false);
                tfrevistaexistencia.setVisible(false);

            } 
        } 

    }

    @Override
    public BookComponent getSeleccionado() {
    return u.getSeleccionado();    
    }

}