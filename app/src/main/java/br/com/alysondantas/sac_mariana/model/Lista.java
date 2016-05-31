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

import br.com.alysondantas.sac_mariana.util.*;//importo a interface da lista

/**
 * 
 * @author Alyson
 *Classe generica para todas as listas
 */
public class Lista implements ILista {//minha lista � implementada pela interface
	private Celula primeira;//crio a primeira celula


	@Override
	/**
	 * Metodo para verificar se a lista � vazia
	 */
	public boolean estaVazia() {
		return primeira==null;//retorna true se a primeira celula for nula
	}

	@Override
	/**
	 * Metodo para obter o tamanho da lista(contando com 0)(como um vetor)
	 */
	public int obterTamanho() {
		int numeroCelulas=0;//variavel para guardar o tamanho da lista
		Celula auxiliar=primeira;//Auxiliar recebe a primeira
		while(auxiliar.getProximo()!=null){//enquanto a proxima de auxiliar for diferente de nula
			numeroCelulas++;//numero de celulas rebe ela mais um
			auxiliar=auxiliar.getProximo();//auxiliar passa pra proxima
		}
		return numeroCelulas;//quando sair do la�o retorna o tamanho da lista
	}

	@Override
	/**
	 * Metodo para inserir no inicio da lista
	 * @param Objetct
	 */
	public void inserirInicio(Object o) {
		Celula celula=new Celula(o);//celula � instanciada com o objeto que foi passsado
		if(primeira==null){//se n�o tiver nenhum objeto na lista
			primeira=celula;//a primeira se torna a celula que foi instanciada
		}
		else{//se n�o
			Celula auxiliar=primeira;//cria uma celula auxiliar que guarda a primeira
			primeira=celula;//orimeira se torna a celula nova
			primeira.setProximo(auxiliar);//e o proximo da primeira pega a auxiliar
		}
	}

	@Override
	/**
	 * inserir no final(n�o foi utilizado)
	 * @deprecated inserirInicio
	 * @param Object
	 */
	public void inserirFinal(Object o) {
		Celula novaCelula = new Celula(0);//celula nova � instancia com o objeto que foi passado
		Celula ultimaCelula=primeira;//uma variavel � criada para encontrar o ultimo elemento e a inicio recebe a primeira
		if(primeira!=null){//se ja existir lista
			while(ultimaCelula.getProximo()!=null){//enquanto o proximo da celula n�o for nulo
				ultimaCelula=ultimaCelula.getProximo();//ela passa pra proxima
			}
			ultimaCelula.setProximo(novaCelula);//quando sair do la�o o proximo do ultimo se torna a nova celula
		}else{//se n�o existir lista
			primeira=novaCelula;//a primeira se torna a celula
		}
	}

	@Override
	/**
	 * Metodo para remover no inicio
	 */
	public Object removerInicio() {
		Celula auxiliar=primeira;//auxiliar recebe a primeira
		if(primeira!=null){//se existir a primeira
			primeira=primeira.getProximo();//primeira passa pra seu proximo
		}
		return auxiliar.getObjeto();//retorna o objeto removido
		//n�o fiz uso desse retorno, eu podia colocar null mas por verifica��o se for diferente de nulo foi removido
	}

	@Override
	/**
	 * Metodo para remover no final
	 * @deprecated remover
	 */
	public Object removerFinal() {
		//n�o fiz uso desse metodo ja que era pra uma lista com duas referencias uma pra inicio e uma pro final
		//o metodo de remover no meio serve para remover no final se n�o existir as duas referencias
		if(primeira!=null){//se existir lista
			Celula ultimaCelula=primeira;//tulma recebe a primeira
			Celula penultimaCelula=primeira;//penultima recebe a primeira
			while(ultimaCelula.getProximo()!=null){//enquanto o proximo de ultimo for diferente de nulo
				penultimaCelula=ultimaCelula;//penultima recebe a ultima
				ultimaCelula=ultimaCelula.getProximo();//ultima passa pra proxima
			}
			penultimaCelula.setProximo(null);//penultima aponta pra nulo
			ultimaCelula.setProximo(null);//ultima � desnecessaria
		}
		return null;
	}

	@Override
	/**
	 * remove objeto atravez do index(indice onde ele esta)
	 * @param index
	 */
	public Object remover(int index) {
		Celula auxiliar=primeira;//auxiliar recebe a primeira
		Celula antes=primeira;//anterio recebe a primeira
		Object remove;//objeto a ser removido
		if(index==0){//se index for igual a 0 ele � o primeiro elemnto
			remove=removerInicio();//chamo remo��o no inicio
		}else{//se n�o
			for(int contador=index;contador>0;contador--){//eu instancio um contador do tamanho do index e vou decrementar ele enquando for maior que zero
				antes=auxiliar;//antes recebe auxiliar
				auxiliar=auxiliar.getProximo();//auxiliar passa pro proximo
			}
			//quando sair do "for" auxiliar sera o elemnto que desejo remover e antes sera um elemento atras de auxiliar
			remove=auxiliar.getObjeto();//remove recebe o objeto a ser removido
			antes.setProximo(auxiliar.getProximo());//antes aponta pro proximo de auxiliar
		}
		return remove;//retorno o objeto a ser removido se diferente de null ele foi removido
	}

	@Override
	/**
	 * Metodo para encontrar objeto atravez do index(indice)
	 * @param index
	 */
	public Object recuperar(int index) {
		Celula auxiliar=primeira;//auxiliar recebe a primeira
		int contador;//crio um contador
		for(contador=index;contador>0;contador--){//dou ao contador o index e decremento ele enquanto for maior que zero
			auxiliar=auxiliar.getProximo();//auxiliar passa pro proximo
		}
		//quando sair do "for" o auxiliar � o elemento desejado
		return auxiliar.getObjeto();//retorno objeto encontrado
	}

	@Override
	/**
	 * Metodo pra retornar um iterador com o primeiro elemnto da lista
	 */
	public Iterador iterador() {
		MeuIterador iterador=new MeuIterador(primeira);//instancio o iterador com a primeira celula por paramentro
		return iterador;//retorno o iterador
	}	
	/**
	 * Metodo para trocar dois objetos de posi��o como um BubbleSort
	 * @param index1
	 * @param index2
	 */
	public void bubbleSort(int index1, int index2) {
		Celula celula1 = primeira;//celula1 recebe primeira celula
		Celula celula2 = primeira;//celula2 recebe primeira celula
		int contador;//contador � instanciado
		Object objeto;//objeto a ser trocado � instanciado
		//nesse caso por recorrencia de bugs eu n�o decremento eu incremento
		for(contador =0; contador <index1; contador++){//contador recebe 0 e entando ele for menor que o primeiro index ele � incrementado
			celula1 = celula1.getProximo();//celula1 passa ao proximo dela
		}//quando sair do la�o ela esta no elemnto desejado
		for(contador =0; contador <index2; contador++){//contador recebe 0 e entando ele for menor que o primeiro index ele � incrementado
			celula2 = celula2.getProximo();//celula2 passa ao proximo dela
		}//quando sair do la�o ela esta no elemento desejado
		objeto = celula1.getObjeto();//objeto recebe o objeto da celula1
		celula1.setObjeto(celula2.getObjeto());//celula1 recebe o objeto da celula2
		celula2.setObjeto(objeto);//celula2 recebe o objeto da celula1 anterio
		//metodo foi baseado no BubbleSort
	}
}