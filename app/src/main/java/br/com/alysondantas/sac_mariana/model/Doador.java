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

import java.util.Date;
//Import no util para poder usar o "Date"
/**
 * 
 * @author Alyson
 *Classe para os doadores
 */
public class Doador {
	//Tipo static para que n�o mude
	private static Integer serialId=0;//SerialID � quem vai definir o id de cada doador quando for criado
	private Integer id;//id do doador
	//id n�o foi usado em momento algum ja que o numero de cadastro tambem nunca se repete
	private Endereco endereco;//Endere�o do tipo Endere�o para n�o criar tanta String dentro de doador
	private String tipo;//tipo do doador fisica ou juridica
	private String numCadastro;// numero de cadastro cpf ou cnpj
	private String nome;//nome do doador
	private String dt_nascimento;//data de nascimento
	/**
	 * Construtor da classe para incrementar o SeriaID e dar ao id
	 */
	public Doador(){
		serialId=serialId+1;//Incrementa o SerialID para que n�o se repita
		this.id=serialId;//id da doacao recebe o serialID da cria��o
	}
	//
	public Integer getId() {//para que em outro pacote possa acessar o id
		return id;//retorna o id
	}
	/**
	 * Metodo para cadastrar os endere�os em um objeto
	 * @param rua
	 * @param numero
	 * @param bairro
	 * @param cep
	 * @param cidade
	 * @param uf
	 * @param pais
	 */
	public void Enderecovem(String rua,	int numero, String bairro, String cep, String cidade, String uf, String pais){//no ato de cadastro quando for pedido rua,numero,bairro etc, � criado um objeto so com esses atributos e enviado ao endere�o do doador
		Endereco enderecovem = new Endereco(rua,numero,bairro,cep,cidade,uf,pais);//cria objeto
		this.endereco=enderecovem;//entrega o objeto ao endere�o
		}
	//
	public Endereco getEndereco() {//para que em outro pacote possa acessar o endere�o
		return endereco;//retorna o endere�o
	}
	//
	public void setEndereco(Endereco endereco) {//para que em outro pacote possa alterar o endere�o
		this.endereco = endereco;//endere�o da classe recebe o endere�o passado
	}
	//os get e set abaixo tem as mesma fun��es
	public String getTipo() {
		return tipo;
	}
	//
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//
	public String getNumCadastro() {
		return numCadastro;
	}
	//
	public void setNumCadastro(String numCadastro) {
		this.numCadastro = numCadastro;
	}
	//
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	//
	public String getDt_Nascimento() {
		return dt_nascimento;
	}
	//
	public void setDt_Nascimento(String dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	/**
	 * Metodo para apenas para mostrar o doador quando for chamada
	 */
	public void mostarDoador(){
		System.out.println("ID: "+id);//mostra id
		System.out.println("Nome: "+nome);//mostra nome
		System.out.println("Tipo: "+tipo);//mostra tipo
		System.out.println("Numero de Cadastro: "+numCadastro);//mostra numero de cadastro
		System.out.println("Data de Nascimento: "+dt_nascimento);//mostra data de nascimento
		System.out.println("Endere�o:");
		System.out.println("Rua: "+endereco.getRua());//mostra rua do objeto endere�o
		System.out.println("Numero: "+endereco.getNumero());//mostra numero do objeto endere�o
		System.out.println("Bairro: "+endereco.getBairro());//mostra bairro do objeto endere�o
		System.out.println("CEP: "+endereco.getCep());//mostra cep do objeto endere�o
		System.out.println("Cidade: "+endereco.getCidade());
		System.out.println("UF: "+endereco.getUf());
		System.out.println("Pais: "+endereco.getPais());
		System.out.println("");
	}
}