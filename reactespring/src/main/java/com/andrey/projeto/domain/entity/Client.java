package com.andrey.projeto.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="tb_client")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo nome é obrigatorio")
	@Column(length = 50, nullable = false)
	private String name;
	
	@NotNull(message = "Campo aniversario é obrigatorio")
	@Column(nullable = false)
	private LocalDate birthday;
	
	@NotNull(message = "Campo saldo é obrigatorio")
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal amount;

}
