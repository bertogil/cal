package com.berto.utilidades.as400;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.RequestNotSupportedException;
import com.ibm.as400.access.User;
import com.ibm.as400.access.UserList;
import java.io.IOException;
import java.util.Enumeration;

/**
 *
 * @author berto.gil Lista usuario de FCCLOG
 */
public class ListingUsers {
	public static void main(String[] args) throws AS400SecurityException, ErrorCompletingRequestException,
			InterruptedException, IOException, ObjectDoesNotExistException, RequestNotSupportedException {
		// Create an AS400 object.
		AS400 system = new AS400("FCCLOG");

		// Create the UserList object.
		UserList userList = new UserList(system);

		// Get the list of all users and groups.
		Enumeration enumUsers = userList.getUsers();

		// Iterate through the list.
		while (enumUsers.hasMoreElements()) {
			User u = (User) enumUsers.nextElement();
			System.out.println(u.getUserProfileName());
		}
	}
}
