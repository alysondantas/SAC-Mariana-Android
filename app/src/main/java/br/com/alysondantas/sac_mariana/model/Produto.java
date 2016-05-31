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

import java.util.Date;//Import no util para poder usar o "Date"
/**
 * 
 * @author Alyson
 * Classes para os produtos
 */
public class Produto {
	//Tipo static para que n�o mude
	private static Integer serialId=0;//SerialID � quem vai definir o id de cada produto quando for criado 
	private Integer id;//id do produto
	private String tipo;//tipo do produto
	private String nome;//nome do produto
	private String dataCadastro;//data de cadastro do produto
	/**
	 * Construtor da classe para incrementar o SeriaID e dar o serial do produto
	 */
	public Produto(){
		serialId=serialId+1;//Incrementa o SerialID para que n�o se repita
		this.id=serialId;//id da doacao recebe o serialID da cria��o
	}
	//
	public Integer getId_produto() {//para que em outro pacote possa acessar o id
		return id;//retorna o id
	}
	//
	public String getTipo() {//para que em outro pacote possa acessar a tipo
		return tipo;//retorna o tipo
	}

	public void setTipo(String tipo) {//para que outro pacote possa alterar o tipo
		this.tipo = tipo;//tipo recebe o tipo passado
	}
	//os get e set abaixo tem as mesma fun��es
	public String getDataCadastro() {
		return dataCadastro;
	}
	//
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	//
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Metodo para apenas para mostrar o produto quando for chamada
	 */
	public void mostarProduto(){
		System.out.println("ID: "+id);//mostra id
		System.out.println("Nome: "+nome);//mostra nome
		System.out.println("Tipo: "+tipo);//mostra tipo
		System.out.println("Data de Cadastro: "+dataCadastro);//mostra data de cadastro
		System.out.println("");
	}
}
