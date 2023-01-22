package ru.management.reminder.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.management.reminder.dto.ReminderDto;
import ru.management.reminder.models.Reminder;
import ru.management.reminder.repositories.UserRepository;
import ru.management.reminder.utils.DateUtil;

import java.sql.Timestamp;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReminderConverter implements Converter<ReminderDto, Reminder> {

    private final UserRepository userRepository;

    @Override
    public Reminder convert(ReminderDto source) {
        Reminder target = new Reminder();
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setRemind(DateUtil.isoToTimestamp(source.getRemind()));
        target.setUser(userRepository.findById(1L).get()); // Todo GetLoggedUser
        return target;
    }

}
