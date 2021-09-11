package shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {

    @JsonProperty
    private Integer productID;

    @JsonProperty
    private String title;

    @JsonProperty
    private String description;

    @JsonProperty
    private int price;

}
