package GUI;

import LOGIC.ControladorEstudiantes;
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author <a href="https://github.com/JQuinteroC">JQuinteroC</a>
 */
public class FRM_Estudiante extends JFrame {

    public boolean editar;
    public int id;
    JLabel lblTitulo = new JLabel("");
    JLabel lblNombre = new JLabel("Nombre del estudiante:");
    JLabel lblCodigo = new JLabel("Codigo:");
    JLabel lblNot1 = new JLabel("Nota 1 - 35%:");
    JLabel lblNot2 = new JLabel("Nota 2 - 35%:");
    JLabel lblNot3 = new JLabel("Nota 3 - 30%:");
    public JLabel lblProm = new JLabel("Promedio: 0");

    public JTextField txtCodigo = new JTextField();
    public JTextField txtNombre = new JTextField();

    public JSpinner spnNota1 = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));
    public JSpinner spnNota2 = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));
    public JSpinner spnNota3 = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));

    public JButton btnAceptar = new JButton("Aceptar");
    public JButton btnCancelar = new JButton("Cancelar");

    Font fuente = new Font("verdana", Font.PLAIN, 13);

    public void mostrar() throws IOException {
        if (editar) {
            lblTitulo.setText("Editando estudiante");
            Estudiante estu = busqueda(id);// data.consultar(id);
            txtCodigo.setText(Integer.toString(estu.getCod()));
            txtNombre.setText(estu.getNombre());
            spnNota1.setValue(estu.getNota1());
            spnNota2.setValue(estu.getNota2());
            spnNota3.setValue(estu.getNota3());
            lblProm.setText("Promedio: " + estu.getNotaF());
        } else {
            lblTitulo.setText("Agregando un estudiante");
        }
        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 25));
        lblTitulo.setBounds(10, 5, 400, 45);

        lblNombre.setBounds(10, 60, 160, 30);
        lblNombre.setFont(fuente);

        lblCodigo.setBounds(10, 100, 160, 30);
        lblCodigo.setFont(fuente);

        lblNot1.setBounds(10, 140, 150, 30);
        lblNot1.setFont(fuente);

        lblNot2.setBounds(10, 180, 150, 30);
        lblNot2.setFont(fuente);

        lblNot3.setBounds(10, 220, 150, 30);
        lblNot3.setFont(fuente);

        lblProm.setBounds(100, 240, 200, 30);
        lblProm.setFont(fuente);

        txtNombre.setBounds(170, 60, 200, 25);
        txtNombre.setFont(fuente);

        txtCodigo.setBounds(170, 100, 200, 25);
        txtCodigo.setFont(fuente);

        btnAceptar.setBounds(90, 270, 100, 25);
        btnAceptar.setFont(fuente);
        btnAceptar.setOpaque(true);
        btnAceptar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 138, 153), 1));
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setForeground(this.getForeground());

        btnCancelar.setBounds(210, 270, 100, 25);
        btnCancelar.setFont(fuente);
        btnCancelar.setOpaque(true);
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 138, 153), 1));
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setForeground(this.getForeground());

        spnNota1.setBounds(230, 140, 100, 25);
        spnNota1.setFont(fuente);

        spnNota2.setBounds(230, 180, 100, 25);
        spnNota2.setFont(fuente);

        spnNota3.setBounds(230, 220, 100, 25);
        spnNota3.setFont(fuente);

        setSize(400, 340);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Estudiante");
    }

    public Estudiante busqueda(int cod) throws FileNotFoundException, IOException {
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
        } catch (ClassNotFoundException | IOException ex) {

        }

        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i).getCod() == cod) {
                return ar.get(i);
            }

        }
        return null;
    }

    public FRM_Estudiante() throws HeadlessException {
        java.awt.Container c;
        c = getContentPane();

        c.setLayout(null);
        c.add(lblTitulo);
        c.add(lblProm);
        c.add(lblCodigo);
        c.add(lblNombre);
        c.add(lblNot1);
        c.add(lblNot2);
        c.add(lblNot3);
        c.add(btnAceptar);
        c.add(btnCancelar);
        c.add(txtCodigo);
        c.add(txtNombre);
        c.add(spnNota1);
        c.add(spnNota2);
        c.add(spnNota3);
    }

    public void asignaOyentes(ControladorEstudiantes c) {
        btnAceptar.addActionListener(c);
        btnCancelar.addActionListener(c);
        txtCodigo.addKeyListener(c);
    }
}
