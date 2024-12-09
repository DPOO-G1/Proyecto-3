package Visual;

import javax.swing.JFrame;
import javax.swing.JPanel;

import learningPath.LearningPath;
import usuarios.Usuario;

import java.awt.*;
import java.util.Map;

public class VentanaEstudiante extends JFrame {
	 private BorderLayout layout;
	 private PanelIzquierdoEstudiante PanelIzquiero;
	 
	 public VentanaEstudiante(Usuario usuario,Map<String, Usuario> usuarios,Map<String, LearningPath> mapaLearningPaths){
		 
		 layout= new BorderLayout();
		 setLayout(layout);
		 
		 
		 
		 
	 }
	
	

}
