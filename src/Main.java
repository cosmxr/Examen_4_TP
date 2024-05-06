import Excepciones.ProcesoNoImplementado;
import Excepciones.ProcesoSinEspecificar;
import Excepciones.ProcesoYaDetenido;
import Vista.Vista;
import Controlador.Reverser;
import Modelo.CuentaAtras;
import Modelo.CuentaInfinita;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del controlador Reverser sin pasar ningún parámetro
        Reverser reverser = new Reverser();
        Vista vista = new Vista(reverser);

        // Establecer la referencia de la vista en el reverser
        reverser.setVista(vista);

        // Ejecutar la creación de la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Hacer visible la ventana de la aplicación
            vista.getFrame().setVisible(true);
        });

        // Configurar ActionListener para el botón de Cuenta Infinita
        vista.getBtnCuentaInfinita().addActionListener(e -> {
            try {
                reverser.execute(new CuentaInfinita(vista)); // Iniciar una cuenta infinita
            } catch (ProcesoNoImplementado ex) {
                throw new RuntimeException(ex);
            }
            try {
                reverser.start(); // Comenzar la ejecución del proceso
            } catch (ProcesoSinEspecificar ex) {
                throw new RuntimeException(ex);

            }
        });

        // Configurar ActionListener para el botón de Cuenta Atrás
        vista.getBtnCuentaAtras().addActionListener(e -> {
            try {
                reverser.execute(new CuentaAtras(vista)); // Iniciar una cuenta atrás
            } catch (ProcesoNoImplementado ex) {
                throw new RuntimeException(ex);
            }
            try {
                reverser.start(); // Comenzar la ejecución del proceso
            } catch (ProcesoSinEspecificar ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}


