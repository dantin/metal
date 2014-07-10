package com.demo2do.core.security.expression;

import com.demo2do.core.security.details.SecurityUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

/**
 * Principal expression root for Spring Security
 */
public class PrincipalExpressionRoot extends WebSecurityExpressionRoot {

    /**
     * constructor
     *
     * @param authentication
     * @param filterInvocation
     */
    public PrincipalExpressionRoot(Authentication authentication, FilterInvocation filterInvocation) {
        super(authentication, filterInvocation);
    }

    /**
     * whether principal in the roles
     *
     * @param roles
     * @return
     */
    public boolean hasAnyPrincipalRole(String... roles) {
        Object principal = super.getPrincipal();
        if(principal != null && (principal instanceof SecurityUserDetails)) {
            return ((SecurityUserDetails) principal).hasAnyPrincipalRole(roles);
        }
        return false;
    }

    /**
     * whether principal has resource
     * 
     * @param type
     * @param key
     * @return
     */
    public boolean hasResource(String type, String key) {
        Object principal = super.getPrincipal();
        if(principal != null && (principal instanceof SecurityUserDetails)) {
            return ((SecurityUserDetails) principal).hasResource(type, key);
        }
        return false;
    }
}
