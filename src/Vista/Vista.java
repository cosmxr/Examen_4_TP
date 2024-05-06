package Vista;

import Controlador.Reverser;
import Modelo.CuentaAtras;
import Modelo.CuentaInfinita;

import javax.swing.*;
import java.awt.*;

public class Vista {
    private JFrame frame;
    private JTextArea textArea;
    private JButton btnCuentaInfinita;
    private JButton btnCuentaAtras;
    private Reverser reverser;

    public Vista(Reverser reverser) {
        this.reverser = reverser;
        frame = new JFrame("Reverser");
        textArea = new JTextArea();
        textArea.setEditable(false);

        btnCuentaInfinita = new JButton("Iniciar Cuenta Infinita");
        btnCuentaAtras = new JButton("Iniciar Cuenta Atrás");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(btnCuentaInfinita);
        panel.add(btnCuentaAtras);

        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getBtnCuentaInfinita() {
        return btnCuentaInfinita;
    }

    public JButton getBtnCuentaAtras() {
        return btnCuentaAtras;
    }

    public void show() {
        frame.setVisible(true);
    }

    public void update(String message) {
        SwingUtilities.invokeLater(() -> textArea.append(message + "\n"));
    }
}






