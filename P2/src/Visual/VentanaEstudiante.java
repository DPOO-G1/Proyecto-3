package Visual;

import javax.swing.JFrame;
import javax.swing.JPanel;

import learningPath.LearningPath;
import usuarios.Usuario;

import java.awt.*;
import java.util.Map;

public class VentanaEstudiante extends JFrame {
	 
	 private BorderLayout layout;
	 private PanelIzquierdoEstudiante panelIzquiero;
	 private PanelPrincipalEstudiante panelPrincipal;
	 private PanelMisLearningPathsEstudiante panelMisLearningpaths;
	 private PanelLearningPathsDisponibles panelLearningPathsEstudiante;
	 
	 private JPanel mainPanel;
	 
	 public VentanaEstudiante(Usuario usuario,Map<String, Usuario> usuarios,Map<String, LearningPath> mapaLearningPaths){
		 
		 layout= new BorderLayout();
		 setLayout(layout);
		 
		 mainPanel = new JPanel(layout); 
	     mainPanel.setLayout(new CardLayout());
	     
	     panelPrincipal = new PanelPrincipalEstudiante(usuario);
	     mainPanel.add(panelPrincipal, "panelPrincipal");
	     
	     panelMisLearningpaths = new PanelMisLearningPathsEstudiante(usuario, mainPanel);
	     mainPanel.add(panelMisLearningpaths, "panelMisLearningPaths");
	     
	     panelLearningPathsEstudiante = new PanelLearningPathsDisponibles(usuario, mainPanel, mapaLearningPaths);
	     mainPanel.add(panelLearningPathsEstudiante, "panelLearningPathsEstudiante");
	     
	     
	     add(mainPanel, BorderLayout.CENTER);
		 
		 panelIzquiero = new PanelIzquierdoEstudiante(usuario, usuarios, mapaLearningPaths, mainPanel);
		 add(panelIzquiero, BorderLayout.EAST);
		 
	 }
	
	

}
