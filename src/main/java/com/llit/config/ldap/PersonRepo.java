package com.llit.config.ldap;

import java.util.List;

public interface PersonRepo {

    public List<Person> getAllPersons();
    public List<String> getAllPersonNames();
    public Person getPersonNamesByUid(String userId);
}
