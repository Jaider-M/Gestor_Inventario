import javax.swing.JOptionPane;
public class Venta {
    private Inventario inventario;

    public Venta(Inventario inventario) {
        this.inventario = inventario;
    }

    public void registrarVenta(String nombre, int cantidadVendida) {
        Producto producto = inventario.consultarProducto(nombre);
        if (producto != null) {
            int cantidadActual = producto.getCantidad();
            if (cantidadVendida <= cantidadActual) {
                producto.setCantidad(cantidadActual - cantidadVendida);
                JOptionPane.showMessageDialog(null, "Venta registrada: " + " \n " + "| " + "Producto: " + nombre + " | Cantidad: " + cantidadVendida + " |");
            } else {
                JOptionPane.showMessageDialog(null,"No hay suficiente cantidad en inventario.");
            }
        } else {
            JOptionPane.showMessageDialog(null,"Producto no encontrado.");
        }
    }
}
