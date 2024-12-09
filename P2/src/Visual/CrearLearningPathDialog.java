package Visual;

import javax.swing.*;

import core.Controller;
import learningPath.LearningPath;
import usuarios.Profesor;
import usuarios.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CrearLearningPathDialog extends JDialog {

    private JTextField tituloField;
    private JTextArea descripcionArea;
    private JTextArea objetivosArea;
    private JComboBox<String> dificultadComboBox;
    private JButton crearButton;
    private Map<String, LearningPath> mapaLearningPaths;
    private Usuario profesor;
    
    public CrearLearningPathDialog(JFrame parent,Map<String, LearningPath> mapaLearningPaths,Usuario profesor) {
        super(parent, "Crear Learning Path", true);
        this.mapaLearningPaths = mapaLearningPaths;
        this.profesor = profesor;
        setSize(400, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);

        // Panel para los campos
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        // Campo para el título
        inputPanel.add(new JLabel("Título:"));
        tituloField = new JTextField();
        inputPanel.add(tituloField);

        // Campo para la descripción
        inputPanel.add(new JLabel("Descripción:"));
        descripcionArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(descripcionArea));

        // Campo para los objetivos
        inputPanel.add(new JLabel("Objetivos:"));
        objetivosArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(objetivosArea));

        // Campo para la dificultad
        inputPanel.add(new JLabel("Dificultad:"));
        String[] dificultades = {"Fácil", "Media", "Difícil"};
        dificultadComboBox = new JComboBox<>(dificultades);
        inputPanel.add(dificultadComboBox);

        add(inputPanel, BorderLayout.CENTER);

        // Botón para crear
        crearButton = new JButton("Crear");
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearLearningPath();
            }
        });
        add(crearButton, BorderLayout.SOUTH);
    }

    private void crearLearningPath() {
        String titulo = tituloField.getText();
        String descripcion = descripcionArea.getText();
        String objetivos = objetivosArea.getText();
        String dificultad = (String) dificultadComboBox.getSelectedItem();

        if (titulo.isEmpty() || descripcion.isEmpty() || objetivos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        JOptionPane.showMessageDialog(this, "Learning Path creado exitosamente:\n" +
                "Título: " + titulo + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Objetivos: " + objetivos + "\n" +
                "Dificultad: " + dificultad);
        Controller.crearLearningPath(this.mapaLearningPaths,(Profesor) profesor,titulo,descripcion, objetivos,dificultad);
        
        dispose(); // Cierra el diálogo
    }

  
}