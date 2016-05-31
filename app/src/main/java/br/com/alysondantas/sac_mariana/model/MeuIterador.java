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

import  br.com.alysondantas.sac_mariana.model.*;//importo a classe celula generica
import  br.com.alysondantas.sac_mariana.util.*;//importo a intefacer interador
/**
 * 
 * @author Alyson
 * Meu iterador para trabalhar dentro das listas
 */
public class MeuIterador implements Iterador {//Meu iterador implementa a interface Iterador
	private Celula auxiliar;//crio uma celula auxiliar para trabalhar dentro do iterador
	private Celula primeira;//crio um celula para sempre ser a primeira celula da lista encadeada
	/**
	 * Construtor para receber primeira celula
	 * @param primeira
	 */
	public MeuIterador(Object primeira){//construtor do meu iterador recebe a primeira celula da lista como objeto
		auxiliar=(Celula)primeira;//auxiliar recebe a primeira celula
		this.primeira=(Celula)primeira;//primeira recebe a primeira celula
	}

	@Override
	/**
	 * Metodo para verificar se existe proxima celula ou n�o
	 */
	public boolean temProximo() {
		return auxiliar!=null;//se auxiliar for diferente de null � porque existe outra celula
	}

	@Override
	/**
	 * Metodo para retornar celula atuala e passar pra proxima
	 */
	public Object obterProximo() {
		Object objetoRecebido=auxiliar.getObjeto();//objeto recebido pega o objeto da celula atual
		auxiliar=auxiliar.getProximo();//celula atual passa pra proxima
		return objetoRecebido;//retorna o objeto que foi recebido
	}
	/**
	 * metodo para fazer com que o iterador retorne para o inicio da lista
	 */
	 public void reiniciar() {
		 auxiliar = primeira;//auxiliar recebe a primeira
	 }
}