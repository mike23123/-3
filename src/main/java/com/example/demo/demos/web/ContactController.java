package com.example.demo.demos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public String addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
        return "联系人添加成功";
    }

    @GetMapping
    public List<Contact> listContacts() {
        return contactService.listContacts();
    }

    @PutMapping
    public String updateContact(@RequestBody Contact contact) {
        contactService.updateContact(contact);
        return "联系人信息更新成功";
    }

    @DeleteMapping("/{name}")
    public String deleteContact(@PathVariable String name) {
        contactService.deleteContact(name);
        return "联系人删除成功";
    }
}