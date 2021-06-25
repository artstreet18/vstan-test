package ru.itis.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String login;
    private String password;
    private String email;

    public String login() {
        return this.login;
    }

    public String password() {
        return this.password;
    }

    public String email() {
        return this.email;
    }
}
