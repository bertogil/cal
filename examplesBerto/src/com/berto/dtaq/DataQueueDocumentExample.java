package com.berto.dtaq;

/////////////////////////////////////////////////////////////////////////
//
// Ejemplo de documento de cola de datos. Este programa muestra cómo
// utilizar un documento asociado a una cola de datos del servidor.
//
// @author berto.gil
// Sintaxis del mandato:
//    DataQueueDocumentExample sistema read|write
//
/////////////////////////////////////////////////////////////////////////
import com.ibm.as400.access.*;
import com.ibm.as400.vaccess.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DataQueueDocumentExample {

    private static DataQueueDocument dqDocument;
    private static JTextField text;
    private static boolean rw;

    public static void main(String[] args) {
        // Si no se ha especificado un sistema o read|write, visualizar
        // texto de ayuda y salir.
        if (args.length != 2) {
            System.out.println("Utilización:  DataQueueDocumentExample sistema read|write");
            return;
        }

        rw = args[1].equalsIgnoreCase("read");
        String mode = rw ? "Read" : "Write";

        try {
            // Cree dos marcos.
            JFrame f =
                    new JFrame("Ejemplo de documento de cola de datos - " + mode);

            // Cree un adaptador de diálogo de errores. Esto visualizará
            // los errores ante el usuario.
            ErrorDialogAdapter errorHandler = new ErrorDialogAdapter(f);

            // Cree un adaptador de cursor de trabajo. Esto ajustará el
            // cursor cada vez que se lea o escriba en una cola de datos.
            WorkingCursorAdapter cursorAdapter = new WorkingCursorAdapter(f);

            // Cree un objeto AS400. El nombre del sistema se ha pasado
            // como primer argumento de línea de mandatos.
            AS400 system = new AS400(args[0]);

            // Cree el nombre de vía de acceso de la cola de datos.
            QSYSObjectPathName dqName = new QSYSObjectPathName("QGPL", "JAVATALK", "DTAQ");

            // Compruebe que la cola de datos existe.
            DataQueue dq = new DataQueue(system, dqName.getPath());
            try {
                dq.create(200);
            } catch (Exception e) {
                // Haga caso omiso de las excepciones. Probablemente la cola de datos
                // ya exista.
            }

            // Cree un objeto DataQueueDocument.
            dqDocument = new DataQueueDocument(system, dqName.getPath());
            dqDocument.addErrorListener(errorHandler);
            dqDocument.addWorkingListener(cursorAdapter);

            // Cree un campo de texto para presentar el documento.
            text = new JTextField(dqDocument, "", 40);
            text.setEditable(!rw);

            // Cuando se ejecute el programa, se necesitará controlar cuándo
            // se producen lecturas y escrituras. Para ello dejaremos
            // que se utilice un botón.
            Button button = new Button(mode);
            button.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent event) {
                    if (rw) {
                        dqDocument.read();
                    } else {
                        dqDocument.write();
                        text.setText("");
                    }
                }
            });

            // Cuando el marco se cierre, salga.
            f.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent event) {
                    System.exit(0);
                }
            });

            // Diseñe el marco.
            f.getContentPane().setLayout(new FlowLayout());
            f.getContentPane().add(text);
            f.getContentPane().add(button);
            f.pack();
            f.show();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }
}
