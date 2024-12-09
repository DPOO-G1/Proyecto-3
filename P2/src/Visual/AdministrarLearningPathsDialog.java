package Visual;

import javax.swing.*;

import learningPath.LearningPath;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdministrarLearningPathsDialog extends JDialog {

    private JList<String> listaLearningPaths;
    private JButton seleccionarButton;
    private ArrayList<LearningPath> learningPaths;

    public AdministrarLearningPathsDialog(JFrame parent, ArrayList<LearningPath> learningPaths) {
        super(parent, "Administrar Learning Paths", true);
        this.learningPaths = learningPaths;

        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);

        // Crear modelo para la lista
        DefaultListModel<String> model = new DefaultListModel<>();
        for (LearningPath lp : learningPaths) {
            model.addElement(lp.getTitulo()); // Usa el método getTitulo() del LearningPath
        }

        listaLearningPaths = new JList<>(model);
        listaLearningPaths.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(listaLearningPaths), BorderLayout.CENTER);

        // Botón de seleccionar
        seleccionarButton = new JButton("Seleccionar");
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarLearningPath();
            }
        });
        add(seleccionarButton, BorderLayout.SOUTH);
    }

    private void seleccionarLearningPath() {
        int selectedIndex = listaLearningPaths.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Learning Path.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        LearningPath seleccionado = learningPaths.get(selectedIndex);

        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Error: Learning Path inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        OpcionesLearningPathDialog dialog = new OpcionesLearningPathDialog(this, seleccionado);
        dialog.setVisible(true);
    }


}