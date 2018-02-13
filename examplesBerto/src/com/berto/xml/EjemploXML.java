package com.berto.xml;

/**
 *
 * @author berto.gil
 */

import java.util.*;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


public class EjemploXML {

  public static void main(String[] args) {
     try {
        SAXBuilder builder=new SAXBuilder(false);
        //usar el parser Xerces y no queremos
        //que valide el documento
        Document doc=builder.build("c:\\ejemplo.xml");
        //construyo el arbol en memoria desde el fichero
        // que se lo pasaré por parametro.
        Element raiz=doc.getRootElement();
        //cojo el elemento raiz
        System.out.println("Tipo documento:"+
                    raiz.getAttributeValue("DOCUMENTO"));
        //todos los hijos que tengan como nombre plantilla
        List equipos=raiz.getChildren("DOC_INFO");
        System.out.println("Formada por:"+equipos.size()+" equipos");
        Iterator i = equipos.iterator();
        while (i.hasNext()){
            Element e= (Element)i.next();
            //primer hijo que tenga como nombre club
            Element club =e.getChild("ALBARAN");
            List plantilla=e.getChildren("DOCUMENTO");
         //   System.out.println
         //                 (club.getText()+":"+"valoracion="+
         //                  club.getAttributeValue("valoracion")+","+
         //                  "ciudad="+club.getAttributeValue("ciudad")+","+
         //                  "formada por:"+plantilla.size()+"jugadores");
         //    if (e.getChildren("conextranjeros").size()==0)
         //     System.out.println("No tiene extranjeros");
         //    else  System.out.println("Tiene extranjeros");
             System.out.println("Tipo documento:"+
                    plantilla.contains(plantilla));

        }
        // Dejamos de mano del lector el sacar el nombre
        //de los arbitros, animate!!
     }catch (Exception e){
        e.printStackTrace();
     }
  }
}

