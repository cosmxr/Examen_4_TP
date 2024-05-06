import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        textArea.setEditable(false); // Hacer el área de texto no editable
        btnCuentaInfinita = new JButton("Iniciar Cuenta Infinita");
        btnCuentaAtras = new JButton("Iniciar Cuenta Atrás");

        btnCuentaInfinita.addActionListener(e -> {
            Proceso proceso = new CuentaInfinita();
            reverser.execute(proceso);
            reverser.start();
        });

        btnCuentaAtras.addActionListener(e -> {
            Proceso proceso = new CuentaAtras();
            reverser.execute(proceso);
            reverser.start();
        });

        JPanel panel = new JPanel();
        panel.add(btnCuentaInfinita);
        panel.add(btnCuentaAtras);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Manejar cierre de la ventana
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                reverser.stop(); // Detener la ejecución al cerrar la ventana
            }
        });

        frame.setVisible(true);
    }

    public void update(String message) {
        SwingUtilities.invokeLater(() -> textArea.append(message + "\n"));
    }
}

