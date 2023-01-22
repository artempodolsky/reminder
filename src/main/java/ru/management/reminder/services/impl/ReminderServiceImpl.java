package ru.management.reminder.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.management.reminder.converters.ReminderConverter;
import ru.management.reminder.dto.ReminderDto;
import ru.management.reminder.models.Reminder;
import ru.management.reminder.repositories.ReminderRepository;
import ru.management.reminder.services.ReminderService;
import ru.management.reminder.utils.DateUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReminderServiceImpl implements ReminderService {

    private final ReminderRepository reminderRepository;
    private final ReminderConverter reminderConverter;

    @Override
    public Reminder create(ReminderDto reminderDto) {
        return reminderRepository.save(
                Objects.requireNonNull(
                        reminderConverter.convert(reminderDto)));
    }

    @Override
    public void delete(Long id) {
        reminderRepository.deleteById(id);
    }

    @Override
    public List<ReminderDto> getList() {
        List<Reminder> reminderList = reminderRepository.findAllByUserId(1L); // todo getLoggedUser()
        return reminderList
                .stream()
                .map(reminder -> new ReminderDto(
                        reminder.getId(),
                        reminder.getTitle(),
                        reminder.getDescription(),
                        DateUtil.timestampToIso(reminder.getRemind())))
                .collect(Collectors.toList());
    }

}
