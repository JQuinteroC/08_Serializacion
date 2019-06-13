package LOGIC;

import GUI.FRM_Notas;
import GUI.FRM_Estudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/**
 *
 * @author <a href="https://github.com/JQuinteroC">JQuinteroC</a>
 */
public class ControladorNotas implements ActionListener {

    FRM_Notas v;

    public ControladorNotas(FRM_Notas v) {
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FRM_Estudiante es = new FRM_Estudiante();
        if (e.getSource().equals(v.btnAgregar)) {
            ControladorEstudiantes cE = new ControladorEstudiantes(es);
            es.editar = false;
            es.id = -1;
            try {
                es.mostrar();
            } catch (IOException ex) {
                Logger.getLogger(ControladorNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
            es.asignaOyentes(cE);
        } else if (e.getSource().equals(v.btnEditar)) {
            ControladorEstudiantes cE = new ControladorEstudiantes(es);
            es.editar = true;
            es.id = Integer.parseInt(v.tblNotas.getModel().getValueAt(v.tblNotas.getSelectedRow(), 0).toString());
            try {
                es.mostrar(); 
            } catch (IOException ex) {
                Logger.getLogger(ControladorNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
            es.asignaOyentes(cE);
        } else if (e.getSource().equals(v.btnBorrar)) {
            int cod = Integer.parseInt(v.tblNotas.getModel().getValueAt(v.tblNotas.getSelectedRow(), 0).toString());
            try {
                eliminar(cod);
            } catch (IOException ex) {
                Logger.getLogger(ControladorNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
            v.btnAct.doClick();
        } else if (e.getSource().equals(v.btnAct)) {
            try {
                v.mostrar_tabla();
            } catch (IOException ex) {
                Logger.getLogger(ControladorNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    boolean eliminar(int cod) throws IOException {
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
                    ar.remove(i);
                    break;
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
