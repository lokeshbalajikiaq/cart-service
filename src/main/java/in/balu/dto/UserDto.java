package in.balu.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer userId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String contact;

    private CredentialDto credentialDto;

}
