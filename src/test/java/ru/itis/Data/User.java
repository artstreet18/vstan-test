package ru.itis.Data;

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

    public String login(){
        return this.login;
    }
    public String password(){
        return this.password;
    }
}
