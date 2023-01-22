package ru.management.reminder.services;

import ru.management.reminder.dto.ReminderDto;
import ru.management.reminder.models.Reminder;

import java.util.List;

public interface ReminderService {

    Reminder create(ReminderDto reminderDto);
    void delete(Long id);

    List<ReminderDto> getList();

}
