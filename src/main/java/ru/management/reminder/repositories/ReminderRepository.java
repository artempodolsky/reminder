package ru.management.reminder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.management.reminder.models.Reminder;

import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    void deleteById(Long id);

    List<Reminder> findAllByUserId(Long userId);

}
