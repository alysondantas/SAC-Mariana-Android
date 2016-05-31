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
 * Classe para a celula generica
 */
public class Celula {//Classe para um celula generica
	private Celula proximo;//Referencia para a proxima celula
	private Object objeto;//Objeto generico que vai estar dentro da celula
	/**
	 * Metodo construtor da classe obrigando que venha um objeto quando criar celula
	 * @param o
	 */
	public Celula(Object o){
		this.objeto=o;//objeto recebe object que foi passado
	}
	//Construtores do encapsulamento
	public Celula getProximo() {// para que em outro pacote possa acessar o proximo
		return proximo;//retorna o proximo
	}
	//
	public void setProximo(Celula proximo) {//Para que o ser alterado o proximo por outro pacote
		this.proximo = proximo;//proximo da classe recebe o que foi passado
	}
	//Os dois a baixo tem o mesmo papel que o get e set acima.
	public Object getObjeto() {
		return objeto;
	}
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	//
}
