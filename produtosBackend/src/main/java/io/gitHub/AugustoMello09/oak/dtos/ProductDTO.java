package io.gitHub.AugustoMello09.oak.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import io.gitHub.AugustoMello09.oak.entities.enums.Available;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private String name;
	
	private String description;

	private BigDecimal price;
	
	private Available available;	

}
