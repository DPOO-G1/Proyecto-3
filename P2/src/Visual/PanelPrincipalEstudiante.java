package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import usuarios.Usuario;

public class PanelPrincipalEstudiante extends JPanel{
	JLabel bienvenida;
	public PanelPrincipalEstudiante(Usuario usuario) {
		setLayout(new BorderLayout());
		bienvenida = new JLabel("Bienvenido "+usuario.getNombre());
		bienvenida.setOpaque(true); 
		bienvenida.setBackground(Color.LIGHT_GRAY);
		bienvenida.setFont(new Font("Arial", Font.BOLD, 20));
		bienvenida.setForeground(Color.BLACK);

        this.add(bienvenida, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
	}
}
