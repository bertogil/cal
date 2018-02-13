package com.berto.utilidades.as400;

import com.ibm.as400.access.*;
import com.ibm.as400.security.auth.UserProfilePrincipal;
import java.io.IOException;

/**
 *
 * @author berto.gil
 * Ejemplo datos que se pueden obtener del perfil de usuario
 */
public class UserProfile {

    public static void main(String[] args) throws AS400Exception, AS400SecurityException, ConnectionDroppedException, ErrorCompletingRequestException, InterruptedException, ObjectDoesNotExistException, IOException {
        String name = "BERTO";
        AS400 system = new AS400("AITENA77");
        UserProfilePrincipal profile = new UserProfilePrincipal(system, name);
        String userProfile = profile.getUserProfileName();
        User userId = profile.getUser();
        String nameId = profile.getName();
        System.out.println("Perfil de usuario: " + userProfile);
        System.out.println("Nombre usuario: " + nameId);
        System.out.println("Descripción usuario: " + userId.getDescription());
        System.out.println("Libreria principal: " + userId.getCurrentLibraryName());
        System.out.println("Grupo autorización: " + userId.getGroupAuthority());
        System.out.println("Path local: " + userId.getLocalePathName());
        System.out.println("Descripción trabajo: " + userId.getJobDescription());
        
    }
}
