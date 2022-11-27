package ua.goit.model.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ProductDTO {

    private UUID id;

    @NotBlank(message = "Name may not be blank")
    @Size(max = 255)
    private String name;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal price;

    @NotNull
    private ProducerDTO producer;


}
