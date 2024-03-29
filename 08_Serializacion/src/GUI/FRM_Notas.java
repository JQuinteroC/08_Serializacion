package GUI;

import LOGIC.ControladorNotas;
import LOGIC.Estudiante;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
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

    public JTable tblNotas = new JTable();
    JScrollPane scTabla = new JScrollPane(tblNotas);

    // Inicializar la varibale con el ico
    public JButton btnAgregar = new JButton("Agregar");
    public JButton btnEditar = new JButton("Editar");
    public JButton btnBorrar = new JButton("Borrar");
    public JButton btnAct = new JButton("Actualizar");

    Font fuente = new Font("verdana", Font.PLAIN, 13);

    public void mostrar() throws IOException {
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

        btnAct.setBounds(10, 230, 110, 25);
        btnAct.setFont(fuente);

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
        c.add(btnAct);

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo", "Nombre", "Nota 1-35%", "Nota 2-35%", "Nota 3-30%", "Promedio"
                }
        ));
    }

    public void mostrar_tabla() throws IOException {

        ArrayList<Estudiante> lista = listado();

        DefaultTableModel model = (DefaultTableModel) tblNotas.getModel();
        int rows = model.getDataVector().size();
        for (int i = 0; i < rows; i++) {
            model.removeRow(0);
        }
        String[] filas = new String[6];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = Integer.toString(lista.get(i).getCod());
            filas[1] = lista.get(i).getNombre();
            filas[2] = Integer.toString(lista.get(i).getNota1());
            filas[3] = Integer.toString(lista.get(i).getNota2());
            filas[4] = Integer.toString(lista.get(i).getNota3());
            filas[5] = Double.toString(lista.get(i).getNotaF());
            model.addRow(filas);
        }
        tblNotas.setModel(model);
    }
    
    public ArrayList<Estudiante> listado() throws FileNotFoundException, IOException {
        ArrayList<Estudiante> ar = new ArrayList();
        try {
            Estudiante e;

            InputStream file;
            ObjectInput input;
            file = new FileInputStream("objetos.dat");
            input = new ObjectInputStream(file);

            ar = (ArrayList<Estudiante>) input.readObject();
            input.close();
            Iterator it = ar.iterator();
            while (it.hasNext()) {
                e = (Estudiante) it.next();
            }
        } catch (ClassNotFoundException ex) {

        } catch (IOException ex) {

        }

        return ar;
    }

    public void asignaOyentes(ControladorNotas c) {
        btnAgregar.addActionListener(c);
        btnEditar.addActionListener(c);
        btnBorrar.addActionListener(c);
        btnAct.addActionListener(c);
    }
}
