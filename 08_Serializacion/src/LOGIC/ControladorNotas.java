package LOGIC;

import GUI.FRM_Notas;
import GUI.FRM_Estudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author <a href="https://github.com/JQuinteroC">JQuinteroC</a>
 */
public class ControladorNotas implements ActionListener, KeyListener {

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
                es.mostrar(); ////////////Enviar num
            } catch (IOException ex) {
                Logger.getLogger(ControladorNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
            es.asignaOyentes(cE);
        } else if (e.getSource().equals(v.btnBorrar)){
            String cod = v.tblNotas.getModel().getValueAt(v.tblNotas.getSelectedRow(), 0).toString();
            //Eliminar estudiante
            v.btnAct.doClick();
        }else if (e.getSource().equals(v.btnAct)) {
            try {
                v.mostrar_tabla();
            } catch (IOException ex) {
                Logger.getLogger(ControladorNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    }
}
