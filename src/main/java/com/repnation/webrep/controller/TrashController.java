package com.repnation.webrep.controller;

import com.repnation.webrep.domain.model.EntryRequest;
import com.repnation.webrep.domain.model.TrashEntry;
import com.repnation.webrep.service.TrashService;
import com.repnation.webrep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class TrashController {

    private final UserService userService;

    private final TrashService trashService;

    @Autowired
    public TrashController(UserService userService, TrashService trashService) {
        this.userService = userService;
        this.trashService = trashService;
    }


    @PostMapping(value="/users/{id}/trash", consumes = "application/json")
    public void addNewEntry(@PathVariable Long id, @RequestBody EntryRequest request) {

        userService.findById(id).map(user -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(request.getDate(), formatter);
            return trashService.save(new TrashEntry(user, date));
        });
    }

}
