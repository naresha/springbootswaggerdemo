package com.nareshak.demo.swaggerdemo.controller;

import com.nareshak.demo.swaggerdemo.model.Contact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private static final List<Contact> contacts;

    static {
        contacts = new ArrayList<>();
        contacts.add(new Contact(1L, "Naresha", "K", "911234512345"));
    }

    @ApiOperation(value = "list all contacts", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "unauthorised")
    })
    @GetMapping("/")
    public List<Contact> index() {
        return contacts;
    }

    @PostMapping("/")
    public Contact create(@RequestBody Contact contact) {
        contacts.add(contact);
        return contact;
    }

    @GetMapping("/{id}")
    public Contact show(@PathVariable Long id) {
        return contacts
                .stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
