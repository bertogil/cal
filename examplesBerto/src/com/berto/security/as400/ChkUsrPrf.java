package com.berto.security.as400;

import com.ibm.as400.access.AS400;

/**
 * Ejemplo verificación usuario as400
 * @author berto.gil
 */
public class ChkUsrPrf {

    // Variables de la clase
    private AS400 as400;
    private boolean disabled;
    private String sys;

    /**
     * Verifica el perfil de Usuario
     * @param pUsr 
     * @param pPass 
     * @return
     */
    public boolean chkUsrPrf(String pUsr, String pPass) {

        // Declaramos variables
        boolean wOk = false;

        try {
            // Segun si debremos desactivar al usuario ejecutamos un metodo u otro
            if (this.getDisabled()) {
                // Chekeamos el Usuario/Pass
                as400 = new AS400(sys);
                wOk = as400.authenticate(pUsr, pPass);
            } else {
                // Chekeamos el Usuario/Pass
                as400 = new AS400(sys, pUsr, pPass);
                wOk = as400.validateSignon();
            } // endif

        } catch (Exception e) {
            System.err.println("Err - Chekeando usuario (" + pUsr + ") (" + pPass + ") :" + e);
            wOk = false;
        } finally {
            as400.disconnectAllServices();
            as400 = null;
        } // endtry
        return wOk;
    }

    /**
     * retorna si debemos desactivar el usuario
     */
    public boolean getDisabled() {
        return disabled;
    }

    /**
     * Indica si debemos desactivar el usuario (por defecto true)
     */
    public void setDisabled(boolean pDis) {
        disabled = pDis;
    }
}
