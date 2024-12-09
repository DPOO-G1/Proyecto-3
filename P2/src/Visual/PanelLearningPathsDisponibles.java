package Visual;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import learningPath.LearningPath;
import usuarios.Estudiante;
import usuarios.Usuario;

public class PanelLearningPathsDisponibles extends JPanel {

    public PanelLearningPathsDisponibles(Usuario usuario, JPanel mainPanel) {
        
        Estudiante estudiante = (Estudiante) usuario;

        List<LearningPath> learningPaths = estudiante.getLearningPaths();

        setLayout(new GridLayout(learningPaths.size(), 2, 10, 10));

        
        for (LearningPath learningPath : learningPaths) {
            
            JLabel tituloLabel = new JLabel(learningPath.getTitulo());

            JButton detalleButton = new JButton("Ver detalles");

            detalleButton.addActionListener(e -> {
            	CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, learningPath.getTitulo()); 
               
            });

            add(tituloLabel);
            add(detalleButton);
        }
    }
}