package com.example.demo.demos.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactDao contactDao;

    @Autowired
    public ContactService(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    public List<Contact> listContacts() {
        return contactDao.listContacts();
    }

    public void updateContact(Contact contact) {
        contactDao.updateContact(contact);
    }

    public void deleteContact(String name) {
        contactDao.deleteContact(name);
    }
}