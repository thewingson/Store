package kz.almat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {

    @NotEmpty(message = "Please, enter username")
    private String username;

    @NotBlank(message = "Please, enter password")
    @Size(min = 8)
    private String password;

}
