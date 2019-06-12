package GUI;

import LOGIC.ControladorNotas;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author <a href="https://github.com/JQuinteroC">JQuinteroC</a>
 */
public class FRM_Notas extends JFrame {

    JLabel lblTitulo = new JLabel("Notas de estudiantes");

    JTable tblNotas = new JTable();
    JScrollPane scTabla = new JScrollPane(tblNotas);

    // Inicializar la varibale con el ico
    public JButton btnAgregar = new JButton("Agregar");
    public JButton btnEditar = new JButton("editar");
    public JButton btnBorrar = new JButton("borrar");

    Font fuente = new Font("verdana", Font.PLAIN, 13);

    public void mostrar() {
        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 25));
        lblTitulo.setBounds(150, 5, 300, 45);

        mostrar_tabla();
        scTabla.setBounds(10, 50, 565, 170);
        scTabla.setBorder(null);
        
        btnAgregar.setBounds(255, 230, 100, 25);
        btnAgregar.setFont(fuente);
        
        btnEditar.setBounds(365, 230, 100, 25);
        btnEditar.setFont(fuente);
        
        btnBorrar.setBounds(475, 230, 100, 25);
        btnBorrar.setFont(fuente);

        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Notas de estudiantes");
    }

    public FRM_Notas() throws HeadlessException {
        java.awt.Container c;
        c = getContentPane();

        c.setLayout(null);
        c.add(lblTitulo);
        c.add(scTabla);
        c.add(btnAgregar);
        c.add(btnEditar);
        c.add(btnBorrar);

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo", "Nombre", "Nota 1-35%", "Nota 2-35%", "Nota 3-30%", "Promedio"
                }
        ));
    }

    public void mostrar_tabla() {

        ArrayList<String[]> lista = new ArrayList();
  //      Conectar d = new Conectar();
//        lista = d.listar();

        DefaultTableModel model = (DefaultTableModel) tblNotas.getModel();
        String[] filas = new String[6];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = lista.get(i)[0];
            filas[1] = lista.get(i)[1];
            filas[2] = lista.get(i)[2];
            filas[3] = lista.get(i)[3];
            filas[4] = lista.get(i)[4];
            filas[5] = lista.get(i)[5];
            model.addRow(filas);
        }
        tblNotas.setModel(model);
    }

    public void asignaOyentes(ControladorNotas c) {
        btnAgregar.addActionListener(c);
    }
}
