package LOGIC;

import GUI.FRM_Estudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author <a href="https://github.com/JQuinteroC">JQuinteroC</a>
 */
public class ControladorEstudiantes implements ActionListener, KeyListener {

    FRM_Estudiante v;

    public ControladorEstudiantes(FRM_Estudiante v) {
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(v.btnAceptar)) {
            if (v.editar) {
                try {
                    editar(v.id);
                } catch (IOException ex) {
                    Logger.getLogger(ControladorEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
                }
                v.btnCancelar.doClick();
            } else if (!v.txtCodigo.getText().isEmpty()) {
                int prom = 0; // calcular
                v.lblProm.setText("Promedio: " + prom);
                try {
                    if (insertar()) {
                        v.btnCancelar.doClick();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ControladorEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar el campo de codigo");
                v.txtCodigo.requestFocus();
            }
        } else if (e.getSource().equals(v.btnCancelar)) {
            v.dispose();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar())) {
            e.consume();
        }
    }

    boolean insertar() throws IOException {
        ArrayList<Estudiante> an = new ArrayList();
        try {
            File f = new File("objetos.dat");
            OutputStream file;
            ObjectOutput output;

            if (f.exists()) {
                InputStream file1;
                ObjectInput input1;
                file1 = new FileInputStream("objetos.dat");
                input1 = new ObjectInputStream(file1);
                an = (ArrayList<Estudiante>) input1.readObject();
                input1.close();
                f.delete();
            }

            file = new FileOutputStream("objetos.dat");
            output = new ObjectOutputStream(file);

            ArrayList<Estudiante> ar = new ArrayList<>();
            Estudiante e = new Estudiante();
            Iterator it = an.iterator();
            while (it.hasNext()) {
                e = (Estudiante) it.next();
                ar.add(e);
            }
            e = new Estudiante();
            e.setCod(Integer.parseInt(v.txtCodigo.getText()));
            e.setNombre(v.txtNombre.getText());
            e.setNota1((int) v.spnNota1.getValue());
            e.setNota2((int) v.spnNota2.getValue());
            e.setNota3((int) v.spnNota3.getValue());
            e.setNotaF();
            ar.add(e);

            output.writeObject(ar);
            output.close();
            return true;
        } catch (IOException | ClassNotFoundException | NumberFormatException e) {
            System.out.print(e);
        }
        return true;
    }

    boolean editar(int cod) throws IOException {
        ArrayList<Estudiante> an = new ArrayList();
        try {
            File f = new File("objetos.dat");
            OutputStream file;
            ObjectOutput output;

            if (f.exists()) {
                InputStream file1;
                ObjectInput input1;
                file1 = new FileInputStream("objetos.dat");
                input1 = new ObjectInputStream(file1);
                an = (ArrayList<Estudiante>) input1.readObject();
                input1.close();
                f.delete();
            }

            file = new FileOutputStream("objetos.dat");
            output = new ObjectOutputStream(file);

            ArrayList<Estudiante> ar = new ArrayList<>();
            Estudiante e = new Estudiante();
            Iterator it = an.iterator();
            while (it.hasNext()) {
                e = (Estudiante) it.next();
                ar.add(e);
            }

            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).getCod() == cod) {
                    e = new Estudiante();
                    e.setCod(Integer.parseInt(v.txtCodigo.getText()));
                    e.setNombre(v.txtNombre.getText());
                    e.setNota1((int) v.spnNota1.getValue());
                    e.setNota2((int) v.spnNota2.getValue());
                    e.setNota3((int) v.spnNota3.getValue());
                    e.setNotaF();
                    ar.set(i, e);
                }
            }

            output.writeObject(ar);
            output.close();
            return true;
        } catch (IOException | ClassNotFoundException | NumberFormatException e) {
            System.out.print(e);
        }
        return true;
    }
}
