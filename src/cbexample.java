import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cbexample extends JButton {
    // HTML para el estilo del botón
    private static final String BUTTON_HTML_TEMPLATE = "<html><div style=\"padding: 8px 15px; "
                                                       + "margin: 5px; border-radius: 10px; background-color: #%s; "
                                                       + "color: white; font-family: Arial;\">%s</div></html>";

    public cbexample(String text, String backgroundColor) {
        super(String.format(BUTTON_HTML_TEMPLATE, backgroundColor, text));
        initializeButton();
    }

    public cbexample(String text) {
        this(text, "007bff"); // Color predeterminado si no se especifica uno
    }

    // Método para quitar estilos predeterminados y agregar cursor de mano
    private void initializeButton() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setContentAreaFilled(false);  // Quita el fondo predeterminado del JButton
        setBorderPainted(false);      // Quita el borde predeterminado
        setFocusPainted(false);       // Quita el efecto de enfoque
        setOpaque(false);             // Permite que el HTML sea el único estilo visible
    }

    // Método main para probar el botón personalizado
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Button Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        cbexample customButton = new cbexample("Haz clic aquí", "ff0000"); // Botón rojo personalizado
        cbexample defaultColorButton = new cbexample("Haz clic aquí"); // Botón azul predeterminado

        // Listener de prueba
        customButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "¡Botón presionado!");
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(customButton);
        frame.add(defaultColorButton);

        frame.setVisible(true);
    }
}
