package LOGIC;

import GUI.FRM_Notas;
import GUI.FRM_Estudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        if (e.getSource().equals(v.btnAgregar)) {
            FRM_Estudiante es = new FRM_Estudiante();
            es.mostrar(false, -1);
        } else if (e.getSource().equals(v.btnEditar)){
            FRM_Estudiante es = new FRM_Estudiante();
            es.mostrar(true, -1); ////////////Enviar num
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
