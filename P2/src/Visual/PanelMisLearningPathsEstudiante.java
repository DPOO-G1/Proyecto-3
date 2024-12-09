package Visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import learningPath.LearningPath;
import usuarios.Estudiante;
import usuarios.Usuario;

public class PanelMisLearningPathsEstudiante extends JPanel {
    public PanelMisLearningPathsEstudiante(Usuario usuario, JPanel mainPanel) {
        // Cast user to Estudiante
        Estudiante estudiante = (Estudiante) usuario;

        // Set vertical layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add header information
        JLabel informacion = new JLabel("Haga click en el learning path que quiere ver información");
        informacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(10)); // Add spacing
        add(informacion);
        add(Box.createVerticalStrut(20));

        // Get the list of LearningPaths
        List<LearningPath> learningPaths = estudiante.getLearningPaths();

        for (LearningPath learningPath : learningPaths) {
            // Create a button for each LearningPath
            JButton botonLearningPath = new JButton(learningPath.getTitulo());
            botonLearningPath.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Create the corresponding panel for the LearningPath
            PanelLearningPathEstudiante panelLearningPath = new PanelLearningPathEstudiante(learningPath, mainPanel, estudiante);
            mainPanel.add(panelLearningPath, learningPath.getTitulo());

            // Add ActionListener to the button
            botonLearningPath.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                    cardLayout.show(mainPanel, learningPath.getTitulo());
                }
            });

            // Add the button to the current panel
            add(botonLearningPath);
            add(Box.createVerticalStrut(10)); // Add spacing between buttons
        }
    }
}