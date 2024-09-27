package com.softgraf.primavera.data.dto;

import org.springframework.web.multipart.MultipartFile;

import com.softgraf.primavera.data.entity.Produto;

// padrão DTO (Data Transfer Object)
// representa o formulário do produto
public class ProdutoRequest {

	// campos devem ter os mesmos nomes do formulário
	private String id;
	private String descricao;
	private String preco;
	private String quantidade;
	private String urlImagem;
	private MultipartFile imagem;
	
	public void setImagem(MultipartFile imagem) {
		String nomeArq = imagem.getOriginalFilename();
		if (!nomeArq.isBlank()) {
			setUrlImagem(nomeArq);
		}
		
		this.imagem = imagem;
	}
	
	public Produto toProduto() {
		Produto produto = new Produto();
		if (!getId().isEmpty()) {
			produto.setId(Long.parseLong(getId()));
		}
		produto.setDescricao(descricao.toLowerCase());
		produto.setPreco(Double.parseDouble(preco.replace(",", ".")));
		produto.setQuantidade(Integer.parseInt(quantidade));
		produto.setUrl(urlImagem);
		return produto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public MultipartFile getImagem() {
		return imagem;
	}
	
	
}
