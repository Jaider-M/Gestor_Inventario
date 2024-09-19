import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    // Agrega un nuevo producto al inventario
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Actualiza la cantidad de un producto en el inventario
    public void actualizarCantidad(String nombre, int nuevaCantidad) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setCantidad(nuevaCantidad);
                JOptionPane.showMessageDialog(null, "Cantidad actualizada correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
    }

    // Elimina un producto del inventario
    public void eliminarProducto(String nombre) {
        boolean eliminado = productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        }
    }

    // Muestra el estado actual del inventario
    public void mostrarInventario() {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El inventario está vacío.");
        } else {
            StringBuilder inventarioString = new StringBuilder("Estado del inventario:\n\n");
            for (Producto p : productos) {
                inventarioString.append(p).append("\n");
            }
            JOptionPane.showMessageDialog(null, inventarioString.toString());
        }
    }

    // Consulta un producto específico en el inventario
    public Producto consultarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
}
