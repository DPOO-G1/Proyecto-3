package Visual;

import javax.swing.*;
import java.util.List;
import actividades.Actividad;

public class PanelActividadesEstudiante extends JPanel {
    JLabel tipoLabel;
    JLabel descripcionLabel;
    JLabel objetivoLabel;
    JLabel nivelDificultadLabel;
    JLabel duracionLabel;
    JLabel actividadesPrerrequisitoLabel;
    JLabel fechaLimLabel;
    JLabel actividadesOpcionalesLabel;
    JLabel estadoLabel;
    JLabel completadoLabel;
    JLabel obligatoriaLabel;
    JLabel reseñasLabel;
    JLabel ratingsLabel;
    JLabel calificacionLabel;
    JLabel ratingPromLabel;

    // Default constructor (if needed)
    public PanelActividadesEstudiante() {
        // You can leave this empty or provide default behavior
    }

    // Constructor that initializes the panel with an Actividad object
    public PanelActividadesEstudiante(Actividad actividad) {
        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Initialize labels with data from Actividad
        tipoLabel = new JLabel("Tipo: " + actividad.getTipo());
        descripcionLabel = new JLabel("Descripción: " + actividad.getDescripcion());
        objetivoLabel = new JLabel("Objetivo: " + actividad.getObjetivo());
        nivelDificultadLabel = new JLabel("Nivel de Dificultad: " + actividad.getNivelDificultad());
        duracionLabel = new JLabel("Duración: " + actividad.getDuracion() + " horas");
        actividadesPrerrequisitoLabel = new JLabel("Actividades Prerrequisito: " + listToString(actividad.getActividadesPrerrequisito()));
        fechaLimLabel = new JLabel("Fecha Límite: " + actividad.getFechaLim());
        actividadesOpcionalesLabel = new JLabel("Actividades Opcionales: " + listToString(actividad.getActividadesOpcionales()));
        estadoLabel = new JLabel("Estado: " + actividad.getEstado());
        completadoLabel = new JLabel("Completado: " + (actividad.isCompletado() ? "Sí" : "No"));
        obligatoriaLabel = new JLabel("Obligatoria: " + (actividad.isObligatoria() ? "Sí" : "No"));
        reseñasLabel = new JLabel("Número de Reseñas: " + (actividad.getReseñas() != null ? actividad.getReseñas().size() : "N/A"));
        calificacionLabel = new JLabel("Calificación: " + actividad.getCalificacion());
        ratingPromLabel = new JLabel("Promedio de Rating: " + actividad.getRatingProm());

        // Add vertical spacing and labels to the panel
        add(Box.createVerticalStrut(10));
        add(tipoLabel);
        add(descripcionLabel);
        add(objetivoLabel);
        add(nivelDificultadLabel);
        add(duracionLabel);
        add(actividadesPrerrequisitoLabel);
        add(fechaLimLabel);
        add(actividadesOpcionalesLabel);
        add(estadoLabel);
        add(completadoLabel);
        add(obligatoriaLabel);
        add(reseñasLabel);
        add(calificacionLabel);
        add(ratingPromLabel);
    }

    
    private String listToString(List<?> list) {
        if (list == null || list.isEmpty()) {
            return "N/A";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            sb.append(obj.toString()).append(", ");
        }
        return sb.substring(0, sb.length() - 2); 
    }
}