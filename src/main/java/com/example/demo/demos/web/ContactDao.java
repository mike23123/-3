package com.example.demo.demos.web;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactDao {
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> listContacts() {
        return new ArrayList<>(contacts);
    }

    public Contact getContact(String name) {
        return contacts.stream()
                .filter(contact -> contact.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void updateContact(Contact contact) {
        Optional<Contact> contactOptional = contacts.stream()
                .filter(c -> c.getName().equals(contact.getName()))
                .findFirst();
        if (contactOptional.isPresent()) {
            Contact existingContact = contactOptional.get();
            existingContact.setAddress(contact.getAddress());
            existingContact.setPhone(contact.getPhone());
        }
    }

    public void deleteContact(String name) {
        contacts.removeIf(contact -> contact.getName().equals(name));
    }
}