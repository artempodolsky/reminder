//package ru.management.reminder.services.impl;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import ru.management.reminder.dto.CustomUserDetails;
//import ru.management.reminder.models.User;
//import ru.management.reminder.repositories.UserRepository;
//
//import java.util.Optional;
//
//@Component
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByLogin(username);
//        return new CustomUserDetails(user.get());
//    }
//
//}
