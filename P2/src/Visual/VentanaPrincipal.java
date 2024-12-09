package Visual;

import javax.swing.*;

import learningPath.LearningPath;
import usuarios.Usuario;

import java.awt.*;
import java.util.Map;

public class VentanaPrincipal extends JFrame {

    private CardLayout layout;
    private JPanel mainPanel;

    public VentanaPrincipal(Map<String, Usuario> usuarios, Map<String, LearningPath> mapaLearningPaths) {
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setTitle("LearningPaths v.3");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       
        layout = new CardLayout();
        mainPanel = new JPanel(layout); 

       
        JPanel panelInicio = new PanelInicio(layout, mainPanel, usuarios, mapaLearningPaths);
        JPanel panelCrearUsuario = new PanelCrearUsuario(layout, mainPanel, usuarios);

        mainPanel.add(panelInicio, "PanelInicio");
        mainPanel.add(panelCrearUsuario, "PanelCrearUsuario");

        
        add(mainPanel);

       
        layout.show(mainPanel, "PanelInicio");
    }
}
