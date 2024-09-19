import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de inventario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Inventario inventario = new Inventario();
        Venta venta = new Venta(inventario);

        // Creación de los botones en la interfaz gráfica
        JButton btnRegistrar = new JButton("Registrar producto");
        btnRegistrar.setPreferredSize(new Dimension(200, 50));
        JButton btnActualizar = new JButton("Actualizar cantidad");
        btnActualizar.setPreferredSize(new Dimension(200, 50));
        JButton btnEliminar = new JButton("Eliminar producto");
        btnEliminar.setPreferredSize(new Dimension(200, 50));
        JButton btnConsultar = new JButton("Consultar inventario");
        btnConsultar.setPreferredSize(new Dimension(200, 50));
        JButton btnRegistrarVenta = new JButton("Registrar venta");
        btnRegistrarVenta.setPreferredSize(new Dimension(200, 50));
        JButton btnSalir = new JButton("Salir");
        btnSalir.setPreferredSize(new Dimension(200, 50));

        // Creación de un panel para agrupar los botones
        JPanel panel = new JPanel();
        panel.add(btnRegistrar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnConsultar);
        panel.add(btnRegistrarVenta);
        panel.add(btnSalir);

        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(400, 400);

        frame.setVisible(true);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del producto:");
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la cantidad disponible:"));
                double precio = Double.parseDouble(JOptionPane.showInputDialog(frame, "Ingrese el precio del producto:"));
                inventario.agregarProducto(new Producto(nombre, cantidad, precio));
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del producto a actualizar:");
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la nueva cantidad:"));
                inventario.actualizarCantidad(nombre, cantidad);
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del producto a eliminar:");
                inventario.eliminarProducto(nombre);
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventario.mostrarInventario();
            }
        });

        btnRegistrarVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del producto vendido:");
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la cantidad vendida:"));
                venta.registrarVenta(nombre, cantidad);
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
