package Visual;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import learningPath.LearningPath;
import usuarios.Usuario;

public class PanelIzquierdoEstudiante extends JPanel {
	JLabel nombreUsuario ;
	JButton menuPrincipal =new JButton("Menu");
	JButton misLearningPaths =new JButton("Mis learning paths");
	JButton learningPathsDisponibles =new JButton("Unirme a Learning Paths");
	JButton logout= new JButton("logout");
	BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
	
	public PanelIzquierdoEstudiante(Usuario usuario,Map<String, Usuario> usuarios,Map<String, LearningPath> mapaLearningPaths, JPanel mainPanel) {
		setLayout(layout);
		 nombreUsuario = new JLabel("Bienvenido, " + usuario.getNombre());
	        nombreUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);

	        
	    add(Box.createVerticalStrut(10)); 
	        add(nombreUsuario);
	        add(Box.createVerticalStrut(20)); 
	        add(menuPrincipal);
	        add(misLearningPaths);
	        add(learningPathsDisponibles);
	        add(logout);
		
		this.setBackground(Color.LIGHT_GRAY);
	
        menuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "panelPrincipal");
            }
        });

        misLearningPaths.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "panelMisLearningPaths");
            }
        });

        learningPathsDisponibles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "LearningPathsDisponibles");
            }
        });

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
 
                System.exit(0); 
            }
        });
    	
	}
}
