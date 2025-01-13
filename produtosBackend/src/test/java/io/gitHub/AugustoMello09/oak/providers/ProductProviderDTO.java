package io.gitHub.AugustoMello09.oak.providers;

import java.math.BigDecimal;
import java.util.UUID;

import io.gitHub.AugustoMello09.oak.dtos.ProductDTO;
import io.gitHub.AugustoMello09.oak.entities.enums.Available;

public class ProductProviderDTO {
	
	private static final UUID ID = UUID.fromString("148cf4fc-b379-4e25-8bf4-f73feb06befa");
	private static final String NAME = "Caneca Minimalista";
	private static final BigDecimal PRICE = BigDecimal.ZERO;
	private static final String DESCRIPTION = "Caneca de cerâmica branca com design minimalista, capacidade de 300 ml. Perfeita para café, chá ou qualquer bebida quente. Resistente à lava-louças e micro-ondas.";

	public ProductDTO create() {
		ProductDTO entity = new ProductDTO();
		entity.setId(ID);
		entity.setName(NAME);
		entity.setDescription(DESCRIPTION);
		entity.setPrice(PRICE);
		entity.setAvailable(Available.AVAILABLE);
		return entity;
	}
	
	public UUID getId() {
		return ID;
	}

}
