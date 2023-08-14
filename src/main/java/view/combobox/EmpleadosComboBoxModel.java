package view.combobox;

import modelos.empleado;

import javax.swing.*;

public class EmpleadosComboBoxModel extends AbstractListModel implements ComboBoxModel {
    private empleado[] empleados;
    private empleado selection = null;

    public EmpleadosComboBoxModel(empleado[] empleados) {
        this.empleados = empleados;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (empleado) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

    @Override
    public int getSize() {
        return empleados.length;
    }

    @Override
    public Object getElementAt(int index) {
        return empleados[index];
    }

    /**
     * Devuelve el índice del elemento con el ID indicado.
     *
     * @param id ID del elemento a buscar.
     * @return Índice del elemento con el ID indicado, o -1 si no se encuentra.
     */
    public int getIndexOf(int id) {
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].getId_empleado() == id) {
                return i;
            }
        }
        return -1;
    }
}