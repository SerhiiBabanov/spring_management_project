package ua.goit.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProducerDTO {

    private UUID id;

    @NotBlank(message = "Name may not be blank")
    @Size(max = 255)
    private String name;

    @Override
    public String toString() {
        return id + "," + name;
    }
}
