package ru.management.reminder.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.management.reminder.dto.ReminderDto;
import ru.management.reminder.models.Reminder;
import ru.management.reminder.utils.DateUtil;

@Component
public class ReminderReverseConverter implements Converter<Reminder, ReminderDto> {

    @Override
    public ReminderDto convert(Reminder source) {
        return new ReminderDto(
                source.getId(),
                source.getTitle(),
                source.getDescription(),
                DateUtil.timestampToIso(source.getRemind()));
    }

}
