package org.openstack4j.api.identity;

import java.util.List;

import org.openstack4j.common.RestService;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.identity.Domain;
import org.openstack4j.model.identity.Group;
import org.openstack4j.model.identity.Project;
import org.openstack4j.model.identity.Role;
import org.openstack4j.model.identity.User;

/**
 * Identity.v3 User operations
 *
 */
public interface UserService extends RestService {

	/**
	 * gets detailed information about a specified user by id
	 *
	 * @param userId the user id
	 * @return the user
	 */
	User get(String userId);

	/**
	 * get detailed information about users matching specified name across all domains
	 *
	 * @param userName the user name
	 * @return the of list users matching the name across all domains
	 */
	List<? extends User> getByName(String userName);

	/**
     * get detailed information about a user specified by username and domain id
     *
     * @param userName the user name
     * @param domainId the domain identifier
     * @return the user
     */
	User getByName(String userName, String domainId);

    /**
     * delete a user by id
     *
     * @param userid the userId
     * @return the action response
     */
	ActionResponse delete(String userId);

	/**
	 * updates the password for or enables or disables a specified user.
	 *
	 * @param user the user set to update
	 * @return the updated user
	 */
	User update(User user);

	/**
	 * create a new user
	 *
	 * @param user the user
	 * @return the newly created user
	 */
	User create(User user);

	/**
	 * creates a new user
	 *
	 * @param domainId the domain id
	 * @param name the name of the new user
	 * @param password the password of the new user
	 * @param email the email of the new user
	 * @param enabled the enabled of the new user
	 * @return the newly created user
	 */
	User create(String domainId, String name, String password, String email, boolean enabled);

	/**
	 * @param userId the user id
	 * @return the domain of the user
	 */
	Domain getUserDomain(String userId);

	/**
	 * lists groups for a specified user
	 *
	 * @param userId the user id
	 * @return list of groups for a user
	 */
	List<? extends Group> listUserGroups(String userId);

	/**
	 * lists projects for a specified user
	 *
	 * @param user the user
	 * @return list of projects for a user
	 */
	List<? extends Project> listUserProjects(String userId);

	/**
	 * list role assignments for specified user in project context
	 *
	 * @param userId the user id
	 * @param scope the scope (project,domain)
	 * @return list of role assignments for specified user
	 */
	List<? extends Role> listProjectUserRoles(String userId, String projectId);

	/**
	 * list role assignment for specified user in domain context
	 *
	 * @param userId the user identifier
	 * @param domainId the domain identifier
	 * @return list of role assignments for specified user and domain
	 */
	List<? extends Role> listDomainUserRoles(String userId, String domainId);

    /**
     * adds an existing user to an existing group
     *
     * @param groupId the group id
     * @param userId the user id
     * @return the ActionResponse
     */
    ActionResponse addUserToGroup(String groupId, String userId);

    /**
     * removes a user from a group
     *
     * @param groupId the group id
     * @param userId the user id
     * @return the ActionResponse
     */
    ActionResponse removeUserFromGroup(String groupId, String userId);

	/**
	 * lists users.
	 *
	 * @return list of users
	 */
	List<? extends User> list();

}
