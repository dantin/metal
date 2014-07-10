package com.demo2do.core.security.details;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * User Details object
 */
public interface SecurityUserDetails extends UserDetails {

    /**
     * whether a user has a role
     *
     * @param roles role string
     * @return
     */
    public boolean hasAnyPrincipalRole(String... roles);

    /**
     * whether a user can access a resource
     *
     * @param type
     * @param key
     * @return
     */
    public boolean hasResource(String type, String key);

}
