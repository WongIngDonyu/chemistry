package chemistry.DTO;

import chemistry.models.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersDto {
    private int id;
    private String username;
    private String password;
    private Role role;
}
