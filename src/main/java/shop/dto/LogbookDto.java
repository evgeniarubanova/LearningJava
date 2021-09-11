package shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LogbookDto {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String userLogin;

    @JsonProperty
    private Integer productID;

    @JsonProperty
    private int count;

    public LogbookDto(String userLogin, Integer productID, int count) {
        this.userLogin = userLogin;
        this.productID = productID;
        this.count = count;
    }

}
