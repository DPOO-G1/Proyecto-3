package Visual;
import javax.swing.*;

import learningPath.LearningPath;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpcionesLearningPathDialog extends JDialog {

    private JButton mostrarActividadesButton;
    private JButton añadirActividadButton;
    private LearningPath learningPath;

    public OpcionesLearningPathDialog(AdministrarLearningPathsDialog administrarLearningPathsDialog, LearningPath learningPath) {
        super(administrarLearningPathsDialog, "Opciones de Learning Path", true);
        this.learningPath = learningPath;

        setSize(300, 200);
        setLayout(new GridLayout(2, 1));
        setLocationRelativeTo(administrarLearningPathsDialog);

        // Botón para mostrar actividades
        mostrarActividadesButton = new JButton("Mostrar Actividades");
        mostrarActividadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarActividades();
            }
        });

        // Botón para añadir actividad
        añadirActividadButton = new JButton("Añadir Actividad");
        añadirActividadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirActividad();
            }
        });

        add(mostrarActividadesButton);
        add(añadirActividadButton);
    }

    private void mostrarActividades() {
        JOptionPane.showMessageDialog(this, "Actividades del Learning Path: " + learningPath.getTitulo());
        // implementar la lógica para mostrar las actividades del Learning Path seleccionado
    }

    private void añadirActividad() {
        JOptionPane.showMessageDialog(this, "Añadir nueva actividad al Learning Path: " + learningPath.getTitulo());
        // implementar la lógica para añadir una nueva actividad
    }
}