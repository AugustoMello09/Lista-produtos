package io.gitHub.AugustoMello09.oak.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import io.gitHub.AugustoMello09.oak.entities.enums.Available;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_product")
public class Produtc implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "ID")
	private UUID id;
	
	@Column(name = "NAME", nullable = false, length = 60)
	private String name;
	
	@Column(name = "DESCRIPTION", nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "AVAILABLE", nullable = false)
	private Available available;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
}
