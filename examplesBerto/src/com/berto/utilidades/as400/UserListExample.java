/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berto.utilidades.as400;

import java.util.Enumeration;

/**
 *
 * @author berto.gil
 * Lista usuarios de un grupo
 */
import com.ibm.as400.access.AS400;
import com.ibm.as400.access.User;
import com.ibm.as400.access.UserList;

public class UserListExample {

	public static void main(String[] args) {
		// If a system and group were not specified, then display
		// help text and exit.
		if (args.length != 2) {
			System.out.println("Usage:  UserListExample system group");
			return;
		}

		try {
			// Create an AS400 object. The system name was passed
			// as the first command line argument.
			AS400 system = new AS400("FCCLOG");

			// The group name was passed as the second command line
			// argument.
			String groupName = args[1];

			// Create the user list object.
			UserList userList = new UserList(system);

			// Get a list of the users in the given group.
			userList.setUserInfo(UserList.MEMBER);
			userList.setGroupInfo(groupName);
			Enumeration enumUsers = userList.getUsers();

			// Iterate through the list and print out the
			// users' names and descriptions.
			while (enumUsers.hasMoreElements()) {
				User u = (User) enumUsers.nextElement();
				System.out.println("User name:   " + u.getUserProfileName());
				System.out.println("Description: " + u.getDescription());
				System.out.println("");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.exit(0);
	}

}