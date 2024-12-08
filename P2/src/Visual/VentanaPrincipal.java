package Visual;

import javax.swing.*;

import usuarios.Usuario;

import java.awt.*;
import java.util.Map;

public class VentanaPrincipal extends JFrame {

    private CardLayout layout;
    private JPanel mainPanel;

    public VentanaPrincipal(Map<String, Usuario> usuarios) {
        // Set up the frame
        setTitle("LearningPaths v.3");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize CardLayout and main panel
        layout = new CardLayout();
        mainPanel = new JPanel(layout); // Use the same CardLayout instance

        // Create panels and add them to the main panel
        JPanel panelInicio = new PanelInicio(layout, mainPanel, usuarios);
        JPanel panelCrearUsuario = new PanelCrearUsuario(layout, mainPanel, usuarios);

        mainPanel.add(panelInicio, "PanelInicio");
        mainPanel.add(panelCrearUsuario, "PanelCrearUsuario");

        // Add main panel to the frame
        add(mainPanel);

        // Show initial panel
        layout.show(mainPanel, "PanelInicio");
    }
}
