package Visual;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.*;

import core.Controller;
import learningPath.LearningPath;
import usuarios.Estudiante;
import usuarios.Profesor;
import usuarios.Usuario;

public class PanelInicio extends JPanel {

    JButton crearUsuario = new JButton("Crear Usuario");
    JButton login = new JButton("Login");
    JTextField usuario = new JTextField("Usuario");
    JTextField contraseña = new JTextField("Contraseña");
    JLabel instrucciones = new JLabel("Bienvenido a LearningPaths v.3", SwingConstants.CENTER);

    public PanelInicio(CardLayout layout, JPanel panelPrincipal, Map<String, Usuario> usuarios,Map<String, LearningPath> mapaLearningPaths) {
        setLayout(new GridLayout(5, 1, 10, 10));

        add(instrucciones);
        add(usuario);
        add(contraseña);
        add(login);
        add(crearUsuario);

        crearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(panelPrincipal, "PanelCrearUsuario");
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String correoLogin= usuario.getText();
            	String contraseñaLogin= contraseña.getText();
            	if(Controller.verificarIdentidad(usuarios, correoLogin, contraseñaLogin)) {
            		
            		Usuario usuario=usuarios.get(correoLogin);
            		if (usuario instanceof Estudiante) {
            			VentanaEstudiante ventanaEstudiante = new VentanaEstudiante(usuario,usuarios,mapaLearningPaths, usuarios);
                        ventanaEstudiante.setVisible(true);
                        
            		}
            		if (usuario instanceof Profesor) {
            			VentanaProfesor ventanaProfesor= new VentanaProfesor(usuario,mapaLearningPaths, usuarios);
                        ventanaProfesor.setVisible(true);
            		}
            		
            	}
            	else {
            		
            		JOptionPane.showMessageDialog(null, "Usuario o contraseña invalid(a/o)", "Error", JOptionPane.INFORMATION_MESSAGE);
            	}
            }
         });
    }
}
    
