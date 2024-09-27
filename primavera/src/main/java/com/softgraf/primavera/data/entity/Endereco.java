package com.softgraf.primavera.data.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


// Anotação JPA
@Embeddable
public class Endereco {
	
	@Column(length = 30)
	private String rua;
	
	@Column(length = 20)
	private String bairro;
	
	@NotBlank(message = "Cidade é obrigatório")
	@Size(min=3, max=30)
	@Column(length = 30, nullable = false)
	private String cidade;
	
	@NotBlank(message = "Estado é obrigatório")
	@Column(length = 20, nullable = false)
	private String estado;
	
	@Column(length = 9)
	private String cep;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(rua, other.rua);
	}
	
	
	
	
}
