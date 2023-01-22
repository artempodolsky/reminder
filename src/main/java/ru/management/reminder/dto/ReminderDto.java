package ru.management.reminder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReminderDto {

    private Long id;

    private String title;

    private String description;

    private String remind;

}
