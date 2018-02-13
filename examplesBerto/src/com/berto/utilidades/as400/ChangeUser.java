package com.berto.utilidades.as400;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.security.auth.AS400Credential;
import com.ibm.as400.security.auth.ProfileTokenCredential;
import java.beans.PropertyVetoException;

/**
 *
 * @author berto.gil
 */
public class ChangeUser {

    public static void main(String[] args) throws PropertyVetoException, AS400SecurityException, Exception {
        // Prepare to work with the local AS/400 system.
        AS400 system = new AS400("fcclog", "*CURRENT", "*CURRENT");

        // Create a single-use ProfileTokenCredential with a 60 second timeout.
        // A valid user ID and password must be substituted.
        ProfileTokenCredential pt = new ProfileTokenCredential();
        pt.setSystem(system);
        pt.setTimeoutInterval(60);
        pt.setTokenType(ProfileTokenCredential.TYPE_SINGLE_USE);

        pt.setTokenExtended("USERID", "PASSWORD");

        // Swap the OS/400 thread identity, retrieving a credential to
        // swap back to the original identity later.
        AS400Credential cr = pt.swap(true);

        // Perform work under the swapped identity at this point.

        // Swap back to the original OS/400 thread identity.
        cr.swap();

        // Clean up the credentials.
        cr.destroy();
        pt.destroy();

    }
}
