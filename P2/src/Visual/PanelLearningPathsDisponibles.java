package Visual;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.Controller;
import learningPath.LearningPath;
import usuarios.Estudiante;
import usuarios.Usuario;

public class PanelLearningPathsDisponibles extends JPanel {

	public PanelLearningPathsDisponibles(Usuario usuario, JPanel mainPanel, Map<String, LearningPath> mapaLearningPaths, Map<String, Usuario> usuarios1) {
	    
	    Estudiante estudiante = (Estudiante) usuario;

	    
	    setLayout(new GridLayout(0, 2, 10, 10));

	    
	    for (LearningPath learningPath : mapaLearningPaths.values()) {
	        
	        JLabel tituloLabel = new JLabel(learningPath.getTitulo());

	        
	        JButton detalleButton = new JButton("Unirme");
	        
	        
	        detalleButton.addActionListener(e -> {
	            
	            Controller.añadirLearningPath(usuarios1, mapaLearningPaths, learningPath.getTitulo(), usuario);

	        });
  
	        add(tituloLabel);
	        add(detalleButton);
	    }}
	}
