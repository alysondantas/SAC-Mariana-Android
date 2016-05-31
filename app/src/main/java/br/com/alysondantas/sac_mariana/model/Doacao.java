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
 * Classe para as doa��es
 */
public class Doacao {
	//Tipo static para que n�o mude
	private static Integer serialId=0;//SerialID � quem vai definir o id de cada doacao quando for criada 
	private Integer id;//id da doacao
	private String data;//data da doacao
	private Doador doador;//Objeto do tipo doador para receber a referencia do doador
	private Produto produto;//Objeto do tipo produto para receber a referencia do produto
	private int qtd;//quantidade da doa��o
	private boolean monetario;//Tipo bolean para saber se � monetario ou n�o true=sim false=n�o
	/**
	 * Construtor da classe para incrementar o SeriaID e dar o serial da doa��o
	 */
	public Doacao(){
		serialId=serialId+1;//Incrementa o SerialID para que n�o se repita
		this.id=serialId;//id da doacao recebe o serialID da cria��o
	}
	/**
	 * Metodo para apenas para mostrar a doa��o quando for chamada
	 */
	public void mostarDoacao(){
		System.out.println("ID: "+id);//mostra id
		System.out.println("Data: "+data);//mostra data
		System.out.println("Quantidade: "+qtd);//mostra quantidade
		System.out.println("");//da uma quebra de linha
	}
	//
	public Integer getId_doacao() {//para que em outro pacote possa acessar o id
		return id;//retorna o id
	}
	//
	public String getData() {//para que em outro pacote possa acessar a data
		return data;//retorna a data
	}
	public void setData(String data) {//Para que a data possa ser alterada por outro pacote
		this.data = data;//data da classe recebe o que foi passado
	}
	//os get e set abaixo tem as mesma fun��es
	public Doador getDoador() {
		return doador;
	}
	public void setDoador(Doador doador) {
		this.doador = doador;
	}
	//
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	//
	public Number getQtd() {
		return qtd;
	}
	//
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	//
	public boolean isMonetario() {
		return monetario;
	}
	//
	public void setMonetario(boolean monetario) {
		this.monetario = monetario;
	}
	
}