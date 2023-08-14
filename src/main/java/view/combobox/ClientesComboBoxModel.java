package view.combobox;

import modelos.cliente;

import javax.swing.*;

    public class ClientesComboBoxModel extends AbstractListModel implements ComboBoxModel {

        private cliente[] clientes;
        private cliente selection = null;

        public ClientesComboBoxModel(cliente[] clientes) {
            this.clientes = clientes;
        }

        @Override
        public void setSelectedItem(Object anItem) {
            selection = (cliente) anItem;
        }

        @Override
        public Object getSelectedItem() {
            return selection;
        }

        @Override
        public int getSize() {
            return clientes.length;
        }

        @Override
        public Object getElementAt(int index) {
            return clientes[index];
        }


        /**
         * Busca el índice de un cliente en el arreglo de clientes.
         *
         * @param clienteId El ID del cliente a buscar.
         * @return El índice del cliente en el arreglo de clientes.
         */
        public int buscarIndiceDelCliente(int clienteId) {
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i].getId_cliente() == clienteId) {
                    return i;
                }
            }

            return -1;
        }

        /**
         * Devuelve el índice del elemento con el ID indicado.
         *
         * @param clienteId ID del elemento a buscar.
         * @return Índice del elemento con el ID indicado, o -1 si no se encuentra.
         */
        public int getIndexOf(int clienteId) {
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i].getId_cliente() == clienteId) {
                    return i;
                }
            }
            return -1;
        }
    }

