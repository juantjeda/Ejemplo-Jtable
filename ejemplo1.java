       //Antes que nada necesitas declarar el atributo tabla o como quieras llamar a tu Jtable, esto para poder manipularla.
       private DefaultTableModel tabla = new DefaultTableModel(); // aca inicias la manipulacion del Jtable.
       
       JTable miTabla = new JTable(tabla); //Esto creo que ya lo declaraste pero no esta de mas agregarlo.
       this.miTabla.setModel(tabla)//Otra forma de agrear el modelo a tu tabla, como gustes mas es lo mismo.
              
       tabla.addColumn("Encabezado1"); //de esta manera añades el encabezado a la tabla cuantas columnas necesites puedes ir poniendolas.
       tabla.addColumn("Encabezado2");
       tabla.addColumn("Encabezado3");
       
       // Ahora para agregar las filas que segun entiendo lo haces consultando la base de datos debes usar un objeto esto es facil de hacer.
       // Consulta tu base de datos y en el ciclo while pones lo siguiente al hacerlo.
       
       Resulset consulta;
       while(consulta.next()){ // supongamos que ya llenaste la consulta desde la base de datos.
        // Original debe de ir asi pone una fila en blanco, con los datos de tu sql seria asi: tabla.addRow(new Object[]{}) 
        tabla.addRow(new Object[]{campo1.getText(), campo2.getText(), campo3.getText()}); //donde campo1, 2 y 3 es lo que quieres mostrar.
       } 
       
       //Ahora me dijiste que quieres eliminar tendrias que usar el evento mouseClicked sobre tu tabla.       
    public void mouseClicked(MouseEvent e){
        fila = miTAbla.rowAtPoint(e.getPoint()); //Obtienes la fila antes declara tu variable fila como un atributo con valor -1 asi  int fila = -1;
        if(fila> -1){
            //Aqui pones tu sql del delete
            sql = "DELETE FROM tabla "; // Lo puse asi como ejemplo no se como estas manejando tus consultas y tu base de datos asumo que ya lo haces.
            //miTabla.getValueAt(fila, 0).toString() esto te dara los valores de la fila donde 0 es el numero de la columna, esto para que lo pongas en el delete
            //las columnas se cuentan desde 0.                       
            tabla.removeRow(fila); //asi la borras del Jtable.
        }
    }
