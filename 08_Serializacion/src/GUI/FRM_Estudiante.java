package GUI;

import LOGIC.ControladorEstudiantes;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author <a href="https://github.com/JQuinteroC">JQuinteroC</a>
 */
public class FRM_Estudiante extends JFrame {

    JLabel lblTitulo = new JLabel("");
    JLabel lblNombre = new JLabel("Nombre del estudiante");
    JLabel lblNot1 = new JLabel("Nota 1 - 35%:");
    JLabel lblNot2 = new JLabel("Nota 2 - 35%:");
    JLabel lblNot3 = new JLabel("Nota 3 - 30%:");
    JLabel lblProm = new JLabel("Promedio: ");

    JTextField txtNombre = new JTextField();

    JSpinner spnNota1 = new JSpinner();

    public JButton btnAceptar = new JButton("Aceptar");
    public JButton btnCancelar = new JButton("Cancelar");

    Font fuente = new Font("verdana", Font.PLAIN, 13);

    public void mostrar(boolean editar, int id) {
        if (editar) {
            lblTitulo.setText("Editando estudiante");
        } else {
            lblTitulo.setText("Agregando un estudiante");
        }
        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 25));
        lblTitulo.setBounds(150, 5, 300, 45);

        txtNombre.setFont(fuente);
        txtNombre.setBounds(170, 110, 200, 25);

        btnAceptar.setBounds(255, 230, 100, 25);
        btnAceptar.setFont(fuente);

        btnCancelar.setBounds(365, 230, 100, 25);
        btnCancelar.setFont(fuente);

        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Notas de estudiantes");
    }

    public FRM_Estudiante() throws HeadlessException {
        java.awt.Container c;
        c = getContentPane();

        c.setLayout(null);
        c.add(lblTitulo);
        c.add(btnAceptar);
        c.add(btnCancelar);
    }

    public void asignaOyentes(ControladorEstudiantes c) {
        btnAceptar.addActionListener(c);
    }
}
