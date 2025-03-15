package com.phucchinh.identity_service.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor //khi khoi tao doi tuong thi co the ko them thuoc tinh
@AllArgsConstructor //khi khoi tao doi tuong thi them full thuoc tinh
@Builder // ca getter va setter va 1 so method khac
@FieldDefaults(level = AccessLevel.PRIVATE) //thay the cho private
public class UserCreationRequest {

    @Size(min = 3, message = "USERNAME_INVALID")
    String username;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;
    String firstName;
    String lastName;
    LocalDate dob;

}
