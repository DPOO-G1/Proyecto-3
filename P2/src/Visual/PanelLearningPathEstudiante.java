package Visual;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import actividades.Actividad;
import learningPath.LearningPath;
import usuarios.Estudiante;
import usuarios.Usuario;

public class PanelLearningPathEstudiante extends JPanel{
	
	JButton retirar;
	JButton anadir;
	JLabel titulo;
	JLabel descripcion;
	JLabel objetivos;
	JLabel nivelDificultad;
	JLabel profesor;
	JLabel duracion;
	JLabel rating;
	JLabel fechaCreacion; 
	JLabel fechaUltModificacion;
	
	public PanelLearningPathEstudiante(LearningPath learningPath, JPanel mainPanel,Estudiante estudiante) {
		retirar =new JButton("Retirar Learninpath");
		anadir =new JButton("Retirar Learninpath");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		titulo = new JLabel("Título: " + learningPath.getTitulo());
        descripcion = new JLabel("Descripción: " + learningPath.getDescripcion());
        objetivos = new JLabel("Objetivos: " + learningPath.getObjetivos());
        nivelDificultad = new JLabel("Nivel de Dificultad: " + learningPath.getNivelDificultad());
        profesor = new JLabel("Profesor: " + learningPath.getProfesor().getNombre());
        duracion = new JLabel("Duración: " + learningPath.getDuracion() + " horas");
        rating = new JLabel("Rating: " + learningPath.getRating());
        fechaCreacion = new JLabel("Fecha de Creación: " + learningPath.getFechaCreacion());
        fechaUltModificacion = new JLabel("Última Modificación: " + learningPath.getFechaUltModificacion());
        
        add(retirar);
        add(titulo);
        add(descripcion);
        add(objetivos);
        add(nivelDificultad);
        add(profesor);
        add(duracion);
        add(rating);
        add(fechaCreacion);
        add(fechaUltModificacion);
        
        retirar.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	 List<LearningPath> learningPaths = estudiante.getLearningPaths();
		                 learningPaths.removeIf(lp -> lp.getTitulo().equals(learningPath.getTitulo()));

		            }
		        });
        anadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	List<LearningPath> learningPaths = estudiante.getLearningPaths(); 
            	boolean exists = learningPaths.stream()
                         .anyMatch(lp -> lp.getTitulo().equals(learningPath.getTitulo()));

                 if (!exists) {
                     learningPaths.add(learningPath);
                     
                 } else {
                     JOptionPane.showMessageDialog(null, "El Learning Path ya existe.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                 }
            }
        });

        
        List<Actividad> actividades = learningPath.getActividades();
        
        for(int i =0; i<actividades.size();i++) {
			
			Actividad actividad=actividades.get(i);
			JButton botonActividad =new JButton(actividad.getDescripcion());
			PanelActividadesEstudiante panelActividades= new PanelActividadesEstudiante(actividad);
			
			
			mainPanel.add(panelActividades,actividad.getDescripcion());
			botonActividad.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
		                cardLayout.show(mainPanel,actividad.getDescripcion() );
		            }
		        });
			
		}
		
	}

}
