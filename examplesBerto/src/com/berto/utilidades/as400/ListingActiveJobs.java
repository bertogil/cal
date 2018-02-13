package com.berto.utilidades.as400;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.Job;
import com.ibm.as400.access.JobList;
import com.ibm.as400.access.ObjectDoesNotExistException;
import java.io.IOException;
import java.util.Enumeration;

/**
 *
 * @author berto.gil
 * Ejemplo para listar trabajos activos
 */
public class ListingActiveJobs {

    public static void main(String[] args) throws AS400SecurityException, ErrorCompletingRequestException, InterruptedException, ObjectDoesNotExistException, IOException {
        // Create an AS400 object. List the
        // jobs on this iSeries.
        AS400 sys = new AS400("FCCLOG");

        // Create the job list object.
        JobList jobList = new JobList(sys);

        // Get the list of active jobs.
        Enumeration list = jobList.getJobs();

        // For each active job on the system
        // print job information.
        while (list.hasMoreElements()) {
            Job j = (Job) list.nextElement();

            System.out.println(j.getName() + "."
                    + j.getUser() + "."
                    + j.getNumber());
        }

    }
}
