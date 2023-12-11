package chemistry.service;

import chemistry.models.Users;
import chemistry.service.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
