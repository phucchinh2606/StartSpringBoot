package com.phucchinh.identity_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@NoArgsConstructor //khi khoi tao doi tuong thi co the ko them thuoc tinh
@AllArgsConstructor //khi khoi tao doi tuong thi them full thuoc tinh
@Builder // ca getter va setter va 1 so method khac
@FieldDefaults(level = AccessLevel.PRIVATE) //thay the cho private
public class UserResponse {
    String id;
    String username;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}
