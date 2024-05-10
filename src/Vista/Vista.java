package Vista;

import Controlador.Reverser;

import javax.swing.*;
import java.awt.*;
/**
 * La clase Vista representa la interfaz gráfica de usuario (GUI) para la aplicación.
 * Permite mostrar mensajes y controlar la visibilidad de la ventana principal.
 */
public class Vista {
    private JFrame frame;          //ventana principal de la aplicación
    private JTextArea textArea;    //area de texto

    private JButton btnCuentaInfinita;
    private JButton btnCuentaAtras;
    private Reverser reverser;
    private JButton btnInputCuentaInfinita;
    private JButton btnInputCuentaAtras;
    JTextArea JTextArea;
    /**
     * Constructor de la clase Vista.
     *
     * @param reverser El controlador principal de la aplicación.
     *                 (En este caso, no se utiliza directamente en los métodos de esta clase).
     */
    public Vista(Reverser reverser) {
        this.reverser = reverser;
        // Inicialización de la ventana principal
        frame = new JFrame("Reverser");
        frame.setLayout(new BorderLayout());

        // Inicialización del área de texto
        textArea = new JTextArea();
        textArea.setEditable(false);

        // Configuración de los botones y el panel de la interfaz
        btnInputCuentaInfinita = new JButton("Input Cuenta Infinita");
        btnInputCuentaAtras = new JButton("Input Cuenta Atrás");
        btnCuentaInfinita = new JButton("Iniciar Cuenta Infinita");
        btnCuentaAtras = new JButton("Iniciar Cuenta Atrás");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        panel.add(btnInputCuentaInfinita);
        panel.add(btnInputCuentaAtras);
        panel.add(btnCuentaInfinita);
        panel.add(btnCuentaAtras);

        // Configuración del contenido de la ventana principal
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Obtiene la ventana principal asociada a esta vista.
     *
     * @return La ventana principal (JFrame) de la aplicación.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Obtiene el botón para iniciar la cuenta infinita.
     *
     * @return El botón JButton para iniciar la cuenta infinita.
     */
    public JButton getBtnCuentaInfinita() {
        return btnCuentaInfinita;
    }
    /**
     * Obtiene el botón para iniciar la cuenta atrás.
     *
     * @return El botón JButton para iniciar la cuenta atrás.
     */
    public JButton getBtnCuentaAtras() {
        return btnCuentaAtras;
    }
    /**
     * Obtiene el botón para seleccionar el proceso Cuenta Infinita.
     *
     * @return El botón JButton para seleccionar el proceso Cuenta Infinita.
     */
    public JButton getBtnInputCuentaInfinita() {
        return btnInputCuentaInfinita;
    }
    /**
     * Obtiene el botón para seleccionar el proceso Cuenta Atrás.
     *
     * @return El botón JButton para seleccionar el proceso Cuenta Atrás.
     */
    public JButton getBtnInputCuentaAtras() {
        return btnInputCuentaAtras;
    }
    /**
     * Muestra la ventana principal de la aplicación.
     */
    public void show() {
        frame.setVisible(true);
    }

    /**
     * Actualiza el área de texto con un nuevo mensaje.
     *
     * @param message El mensaje a mostrar en el área de texto.
     */
    public void update(String message) {
        SwingUtilities.invokeLater(() -> textArea.append(message + "\n"));
    }

}





