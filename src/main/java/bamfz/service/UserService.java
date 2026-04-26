package bamfz.service;

import bamfz.dto.user.RequestUserDto;
import bamfz.dto.user.ResponseUserDto;
import bamfz.model.User;
import bamfz.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseUserDto create(RequestUserDto dto) {
        User saved = userRepository.save(new User(dto.username(), dto.password()));
        return toDto(saved);
    }

    public List<ResponseUserDto> findAll() {
        return userRepository.findAll().stream().map(UserService::toDto).toList();
    }

    private static ResponseUserDto toDto(User user) {
        return new ResponseUserDto(user.getUsername());
    }
}
