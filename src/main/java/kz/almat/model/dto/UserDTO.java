package kz.almat.model.dto;

import kz.almat.anootation.PasswordMatches;
import kz.almat.anootation.ValidEmail;
import kz.almat.anootation.ValidPhone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Minimum length of password must be 8")
    private String password;

    @NotBlank
    @Size(min = 8)
    private String confirmPassword;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @ValidEmail
    @NotBlank(message = "Email is required")
    private String email;

    @ValidPhone
    @NotBlank(message = "Phone number is required")
    private String phone;

}
