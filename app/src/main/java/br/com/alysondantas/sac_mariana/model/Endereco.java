package br.com.alysondantas.sac_mariana.model;

/*******************************************************************************

Autor: Alyson Felipe Oliveira Dantas

Componente Curricular: MI - Algoritmos II

Concluido em: 12/12/2015

Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum

trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e

apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo

de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte

do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.

******************************************************************************************/

/**
 * 
 * @author Alyson
 * Classe criada para instanciar um objeto endere�o para o doador
 */
public class Endereco {
	private String rua;
	private int numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	private String pais;
	/**
	 * Construto obrigando o recebimento dos elementos rua,numero,bairro,cep,cidade,uf e pais.
	 * @param rua
	 * @param numero
	 * @param bairro
	 * @param cep
	 * @param cidade
	 * @param uf
	 * @param pais
	 */
	public Endereco(String rua,	int numero, String bairro, String cep, String cidade, String uf, String pais){
		this.setRua(rua);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setCep(cep);
		this.setCidade(cidade);
		this.setUf(uf);
		this.setPais(pais);
	}
	//
	public int getNumero() {
		return numero;
	}
	//
	public void setNumero(int numero) {
		this.numero = numero;
	}
	//
	public String getRua() {
		return rua;
	}
	//
	public void setRua(String rua) {
		this.rua = rua;
	}
	//
	public String getBairro() {
		return bairro;
	}

	//
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	//
	public String getCep() {
		return cep;
	}
	//
	public void setCep(String cep) {
		this.cep = cep;
	}
	//
	public String getCidade() {
		return cidade;
	}
	//
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	//
	public String getUf() {
		return uf;
	}
	//
	public void setUf(String uf) {
		this.uf = uf;
	}
	//
	public String getPais() {
		return pais;
	}
	//
	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
