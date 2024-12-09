package Visual;

import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import learningPath.LearningPath;
import usuarios.Usuario;

public class PanelIzquierdoEstudiante extends JPanel {
	JLabel nombreUsuario;
	JButton menuPrincipal =new JButton("Menu");
	JButton misLearningPaths =new JButton("Mis learning paths");
	JButton learningPathsDisponibles =new JButton("Unirme a Learning Paths");
	JButton logout= new JButton("logout");
	BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
	
	
	public PanelIzquierdoEstudiante(Usuario usuario,Map<String, Usuario> usuarios,Map<String, LearningPath> mapaLearningPaths) {
		setLayout(layout);
		nombreUsuario.setText(usuario.getNombre());
		add(nombreUsuario);
		add(menuPrincipal);
		add(misLearningPaths);
		add(learningPathsDisponibles);
		add(logout);
		
	}
}
