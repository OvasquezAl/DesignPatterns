 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    private JLabel texto,texto2;           
    private JTextField caja,caja2;    
    private JButton boton;         

    public Login() {
        super();                  
        configurarVentana();        
        inicializarComponentes();   
    }

    private void configurarVentana() {
        this.setTitle("Inicia Sesion");                   
        this.setSize(310, 210);                                
        this.setLocationRelativeTo(null);                      
        this.setLayout(null);                                  
        this.setResizable(false);                              
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    private void inicializarComponentes() {
        texto = new JLabel();
        texto2 = new JLabel();
        caja = new JTextField();
        caja2 = new JTextField();
        boton = new JButton();
        
        texto.setText("Usuario");   
        texto.setBounds(50, 10, 100, 25);   
        caja.setBounds(150, 10, 100, 25);
        caja2.setBounds(150, 50, 100, 25);
        texto2.setText("Contraseña"); 
        texto2.setBounds(50, 50, 100, 25);
        
        boton.setText("Login");   
        boton.setBounds(50, 100, 200, 30);   
        boton.addActionListener(this); 
        this.add(texto);
        this.add(texto2);
        this.add(caja);
        this.add(caja2);
        this.add(boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton) {
            String nombre = caja.getText();  
            String contrasenia = caja2.getText(); 
        } 
         
    }

    public static void main(String[] args) {
        Login V = new Login();      
        V.setVisible(true);            
    }
}