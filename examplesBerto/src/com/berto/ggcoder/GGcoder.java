package com.berto.ggcoder;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import net.sf.json.JSONObject;
import org.h2.util.IOUtils;

/**
 * Recupera lat y long de las direcciones de los destinatarios de una bbdd
 * @author berto.gil
 */
public class GGcoder {

    private static final String URL = "http://maps.google.com/maps/geo?output=json";
    private static final String DEFAULT_KEY = "ABQIAAAAtPa1UVHVZrkSwD-vN59ZWhTk1xsLRgQt2bcfpc3P2iFS90SSKhQ86aFjfuzTwOFOBJvy20e9XYIYGw";
    private static String DBurl = "jdbc:as400://FCCLOG";
    // private static String DBurl = "jdbc:mysql://localhost:3306/destinatarios";
    // private static String driver = "com.mysql.jdbc.Driver";
    private static String driver = "com.ibm.as400.access.AS400JDBCDriver";
    private static final String COUNTRY = "ESPAÑA";
    private static int statusCode;
    private static int error = 0;
    private static String wCod = "";
    private static String wCli = "";
    private static String wOrd = "";

    public static void main(String[] args) throws Exception {

        // Cliente
        wCli = args[0];
        // wCli = "610";
        // Destinatario
        wCod = args[1];
        //wCod = "ES020765";
        // Orden dirección
        wOrd = args[2];
        //wOrd = "0";

        Connection();
    }

    public static GAddress geocode(String address, String key) throws Exception {
        URL url = new URL(URL + "&q=" + URLEncoder.encode(address, "UTF-8")
                + "&key=" + key);
        URLConnection conn = url.openConnection();
        ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
        IOUtils.copy(conn.getInputStream(), output);
        output.close();

        GAddress gaddr = new GAddress();
        JSONObject json = JSONObject.fromObject(output.toString());
        JSONObject status = (JSONObject) query(json, "Status");
        gaddr.setCode(Integer.parseInt(query(status, "code").toString()));
        statusCode = Integer.parseInt(query(status, "code").toString());

        if (statusCode == 200) {
            JSONObject placemark = (JSONObject) query(json, "Placemark[0]");

            final String commonId = "AddressDetails.Country.AdministrativeArea";

            gaddr.setFullAddress(query(placemark, "address").toString());
            gaddr.setAccuracy(Integer.parseInt(query(placemark, "AddressDetails.Accuracy").toString()));
            gaddr.setZipCode(query(placemark,
                    commonId + ".SubAdministrativeArea.Locality.PostalCode.PostalCodeNumber").toString());
            gaddr.setAddress(query(placemark,
                    commonId + ".SubAdministrativeArea.Locality.Thoroughfare.ThoroughfareName").toString());
            gaddr.setCity(query(placemark,
                    commonId + ".SubAdministrativeArea.SubAdministrativeAreaName").toString());
            gaddr.setState(query(placemark, commonId + ".AdministrativeAreaName").toString());
            gaddr.setLat(Double.parseDouble(query(placemark, "Point.coordinates[1]").toString()));
            gaddr.setLng(Double.parseDouble(query(placemark, "Point.coordinates[0]").toString()));

        }

        return gaddr;
    }

    public static GAddress geocode(String address) throws Exception {
        return geocode(address, DEFAULT_KEY);
    }

    /* Permite anidar query para json nested objects, ie. Placemark[0].address */
    private static Object query(JSONObject jo, String query) {
        try {
            String[] keys = query.split("\\.");
            Object r = queryHelper(jo, keys[0]);
            for (int i = 1; i < keys.length; i++) {
                r = queryHelper(JSONObject.fromObject(r), keys[i]);
            }
            return r;
        } catch (Exception e) {
            return "";
        }
    }

    /* Ayuda a encontrar en los objetos: Placemark[0] */
    private static Object queryHelper(JSONObject jo, String query) {
        int openIndex = query.indexOf('[');
        int endIndex = query.indexOf(']');
        if (openIndex > 0) {
            String key = query.substring(0, openIndex);
            int index = Integer.parseInt(query.substring(openIndex + 1, endIndex));
            return jo.getJSONArray(key).get(index);
        }
        return jo.get(query);
    }

    /* Metodo que crea la conexion y ejecuta los sql (seleccion y actualizacion) */
    public static void Connection() throws SQLException, ClassNotFoundException, Exception {

        // Dirección
        String prdidi = "";
        // Población
        String prdipo = "";
        // Código postal
        String prdicp = "";
        // Proximidad
        int distance = 0;
        // Latitud
        double latitud = 0;
        // Longitud
        double longitud = 0;
        // Dirección completa
        String address = "";
        // Exactitud
        int accuracy = 0;
        // Error sql
        SQLWarning w;

        // Sql para sacar datos de los destinatarios
        String sqlSelect =
                "SELECT prdidi, prdipo, prdicp FROM CENDAT.ALPRDI where prdicl="
                + wCli
                + " and prdide='"
                + wCod
                + "' and prdior="
                + wOrd;

        // Sql para saber la distancia mínima a algún punto de entrega

        String sqlDistance =
                "SELECT MIN(distance(cast('"
                + longitud
                + "' as decimal(18, 6)), cast('"
                + latitud
                + "' as decimal(18,6)), PUENLO, PUENLA))"
                + " as distance from CENDAT.ALPUEN";

        // Sql para actualizar datos de los destinatarios
        String sqlUpdate =
                "UPDATE CENDAT.ALPRDI SET prdiex="
                + accuracy
                + ", prdila="
                + latitud
                + ", prdilo="
                + longitud
                + ", prdieg='"
                + error
                + ", prdipc='"
                + 'S'
                + ", prdipx='"
                + distance
                + "' where prdicl="
                + wCli
                + " and prdide='"
                + wCod
                + "' and prdior="
                + wOrd;

        // Registramos el Driver DB2/400
        Class.forName(driver);

        // Nos conectamos al Driver
        Connection con = DriverManager.getConnection(DBurl, "DIRECTOS", "DIRECTOS");

        if ((w = con.getWarnings()) != null) {
            while (w != null) {
                System.out.println(
                        "SQLWarning: "
                        + w.getSQLState()
                        + '\t'
                        + w.getMessage()
                        + '\t'
                        + w.getErrorCode()
                        + '\t');
                w = w.getNextWarning();
            } // enddo
        } // endif

        Statement stmt1 = con.createStatement();
        Statement stmt2 = con.createStatement();
        Statement stmt3 = con.createStatement();
        ResultSet rs1 = stmt1.executeQuery(sqlSelect);

        if (rs1.next()) {
            do {
                prdidi = replaceCodigos(rs1.getString(1).trim());
                prdipo = replaceCodigos(rs1.getString(2).trim());
                prdicp = rs1.getString(3).trim();

                address = prdidi + " " + prdipo + " " + prdicp;
                GAddress codigos = GGcoder.geocode(address);
                latitud = codigos.getLat();
                longitud = codigos.getLng();
                error = codigos.getCode();
                accuracy = codigos.getAccuracy();

                distance = stmt2.executeUpdate(sqlDistance);
                stmt3.executeUpdate(sqlUpdate);

            } while (rs1.next());
        }

        rs1.close();
        stmt1.close();
        stmt2.close();
        stmt3.close();
    }

    /* Metodo que reemplaza simbolos raros */
    public static String replaceCodigos(String codigo) {

        codigo = codigo.replace('(', ' ');
        codigo = codigo.replace(')', ' ');
        codigo = codigo.replace('/', ' ');
        codigo = codigo.replace('\\', ' ');
        codigo = codigo.replace('*', ' ');
        codigo = codigo.replace('?', ' ');
        codigo = codigo.replace('[', ' ');
        codigo = codigo.replace(']', ' ');
        codigo = codigo.replace(',', ' ');
        codigo = codigo.replace('-', ' ');
        codigo = codigo.replace('.', ' ');
        // codigo = codigo.replace('#', 'Ñ');

        return codigo;
    }
}
