package Visual;
import javax.swing.*;

import learningPath.LearningPath;
import usuarios.Profesor;
import usuarios.Usuario;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class VentanaProfesor extends JFrame {

    private JLabel mensajeBienvenida;
    private JButton crearLearningPathButton;
    private JButton administrarLearningPathsButton;
    private Map<String, LearningPath> mapaLearningPaths;
    private Usuario profesor;

    public VentanaProfesor(Usuario profesor,Map<String, LearningPath> mapaLearningPaths, Map<String, Usuario> usuarios) {
        setTitle("Ventana Profesor");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.mapaLearningPaths = mapaLearningPaths;
        this.profesor = profesor;

        // Mensaje de bienvenida
        mensajeBienvenida = new JLabel("Bienvenido, " + profesor.getNombre(), SwingConstants.CENTER);
        mensajeBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        add(mensajeBienvenida, BorderLayout.NORTH);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));

        crearLearningPathButton = new JButton("Crear Learning Path");
        administrarLearningPathsButton = new JButton("Administrar Learning Paths");

        // Acciones de los botones
        crearLearningPathButton.addActionListener(e -> crearLearningPath());
        administrarLearningPathsButton.addActionListener(e -> administrarLearningPaths((Profesor) profesor));

        buttonPanel.add(crearLearningPathButton);
        buttonPanel.add(administrarLearningPathsButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void crearLearningPath() {
        CrearLearningPathDialog dialog = new CrearLearningPathDialog(this, mapaLearningPaths,profesor);
        dialog.setVisible(true);
    }

    private void administrarLearningPaths(Profesor profesor) {
    	ArrayList<LearningPath> learningpaths = profesor.getLearningpaths();
    	AdministrarLearningPathsDialog dialog = new AdministrarLearningPathsDialog(this,learningpaths);
        dialog.setVisible(true);
    }

   
}