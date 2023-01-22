package ru.management.reminder.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.management.reminder.dto.ReminderDto;
import ru.management.reminder.models.Reminder;
import ru.management.reminder.services.ReminderService;

import java.util.List;

@RestController
@RequestMapping("/reminder")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReminderController {

    private final ReminderService reminderService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reminder> create(@RequestBody ReminderDto reminderDto) {
        return ResponseEntity.ok(reminderService.create(reminderDto));
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reminderService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReminderDto>> getList() {
        return ResponseEntity.ok(reminderService.getList());
    }

}
