/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;


/**
 *
 * @author Zinal
 */
 @DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/furniture",
        callerQuery = "select password from Usermaster where email = ?",
        groupsQuery = "select groupId from Usermaster where email = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)

@ApplicationScoped
public class furniture {

    public furniture() {
    }
    
}
