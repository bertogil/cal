package com.berto.dtaq;

import com.ibm.as400.access.DataQueue;
import com.ibm.as400.access.SecureAS400;

/**
 *
 * @author berto.gil
 */
public class DataQueueFactory {

    // Assumes URI locations below are used for any and every DataQueue
    private static final String dqInURI = "/QSYS.LIB/ICAN.LIB/TRFNIN.DTAQ";
    private static final String dqOutURI = "/QSYS.LIB/ICAN.LIB/TRFNOUT.DTAQ";

    public static final DataQueue createInQueue(SecureAS400 server) {
        DataQueue queue = null;
        try {
            queue = new DataQueue(server, dqInURI);
        } catch (Exception e) {
            System.out.println("Exception creating data queue:\n" + e);
        }
        return queue;
    }

    public static final DataQueue createOutQueue(SecureAS400 server) {
        DataQueue queue = null;
        try {
            queue = new DataQueue(server, dqOutURI);
        } catch (Exception e) {
            System.out.println("Exception creating data queue:\n" + e);
        }
        return queue;
    }
}
