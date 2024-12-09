package Visual;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.Controller;
import persistencia.PersistenciaUsuarios;
import usuarios.Estudiante;
import usuarios.Profesor;
import usuarios.Usuario;

public class PanelCrearUsuario extends JPanel{

	JTextField nombre = new JTextField("Nombre");
	JTextField correo = new JTextField("Correo");
	JTextField contraseña = new JTextField("Contraseña");
    String[] tiposUsuarios = {"Profesor", "Estudiante", "Calificador"};
    JComboBox<String> tipoUsuarioComboBox = new JComboBox<>(tiposUsuarios);
	JButton guardar = new JButton("Guardar");
	JButton atras = new JButton("Atras");
	
	public PanelCrearUsuario(CardLayout layout, JPanel panelPrincipal,Map<String, Usuario> usuarios) {
		setLayout(new GridLayout(6, 1, 10, 10));
		add(nombre);
		add(correo);
		add(contraseña);
		add(tipoUsuarioComboBox);
		
		add(guardar);
		add(atras);
		
		guardar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               
	            	int tipo;
	            	String crearNombre= nombre.getText();
	            	String crearCorreo= correo.getText();
	            	String crearContraseña= contraseña.getText();
	            	String selectedType = (String) tipoUsuarioComboBox.getSelectedItem();
	            	
	            	if(selectedType == "Profesor") {
	            		 tipo=2;
	            	}
	            	else if(selectedType == "Estudiante"){
	            		 tipo=1;
	            		}
	            	else{
	            		 tipo=3;
	            	}
	            	
	            	Controller.crearUsuario(usuarios, crearNombre, crearCorreo, crearContraseña, tipo);
	            	JOptionPane.showMessageDialog(null, "Usuario creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            		}	          	
					});
		
		atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(panelPrincipal, "PanelInicio");
            	}
        	});
		}
	}


