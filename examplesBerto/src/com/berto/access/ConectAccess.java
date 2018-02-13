/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.berto.access;

/**
 *
 * @author berto.gil
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectAccess {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conexion = DriverManager.getConnection("jdbc:odbc:PruebaJava");
            Statement st = conexion.createStatement();

            ResultSet rs = st.executeQuery("select * from FT ALIMENTACION");
            while (rs.next()) {
                System.out.println(rs.getString("PROVEEDOR"));
                //System.out.println(rs.getObject(2));
            }

        } catch (Exception e) {
            System.out.println("Algun error en algun sitio");
        }

    }
}
