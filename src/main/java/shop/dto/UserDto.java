package shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String surname;

    @JsonProperty
    private String address;

    @JsonProperty
    private String number;

    @JsonProperty
    private String login;

    @JsonProperty
    private String password;

    public UserDto(String name, String surname, String address, String number, String login) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.login = login;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
