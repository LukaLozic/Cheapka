package com.llit.config.auth.ldap;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends LdapRepository<User> {
    User findByUid(String username);
    User findByUsernameAndPassword(String username, String password);
    List<User> findByUsernameLikeIgnoreCase(String username);
}