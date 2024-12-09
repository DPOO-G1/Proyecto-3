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
        
        Estudiante estudiante = (Estudiante) usuario;

       
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

       
        JLabel informacion = new JLabel("Haga click en el learning path que quiere ver información");
        informacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(10)); // Add spacing
        add(informacion);
        add(Box.createVerticalStrut(20));

        
        List<LearningPath> learningPaths = estudiante.getLearningPaths();

        for (LearningPath learningPath : learningPaths) {
            
            JButton botonLearningPath = new JButton(learningPath.getTitulo());
            botonLearningPath.setAlignmentX(Component.CENTER_ALIGNMENT);

            
            PanelLearningPathEstudiante panelLearningPath = new PanelLearningPathEstudiante(learningPath, mainPanel, estudiante);
            mainPanel.add(panelLearningPath, learningPath.getTitulo());

           
            botonLearningPath.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                    cardLayout.show(mainPanel, learningPath.getTitulo());
                }
            });

            
            add(botonLearningPath);
            add(Box.createVerticalStrut(10));
        }
    }
}