package core;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import Visual.VentanaPrincipal;
import actividades.Encuesta;
import actividades.Examen;
import actividades.Quiz;
import actividades.Recurso;
import learningPath.LearningPath;
import usuarios.Estudiante;
import usuarios.Profesor;
import usuarios.Usuario;

public class Consola {
	private static Map<String, Usuario> usuarios = new HashMap<>();
	private static Map<String, LearningPath> mapaLearningPaths = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
   
	public static void main(String[] args) {
		usuarios = Controller.cargarPersistenciaUsuarios();
		mapaLearningPaths = Controller.cargarPersistenciaLearningPaths(usuarios);	
		
		//PersistenciaActividades.cargarActividades(mapaLearningPaths);
		//(PersistenciaInscripciones.cargarInscripciones(usuarios, mapaLearningPaths);
		SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(usuarios, mapaLearningPaths);
            ventanaPrincipal.setVisible(true);
            
        });
	}
}
	
	
	