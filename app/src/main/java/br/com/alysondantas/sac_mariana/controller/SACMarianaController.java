package br.com.alysondantas.sac_mariana.controller;

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

import br.com.alysondantas.sac_mariana.exceptions.*;
import br.com.alysondantas.sac_mariana.model.*;//import na lista
import br.com.alysondantas.sac_mariana.util.*;//importo a interface do iterador

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;//uso util.date para usar a variavel tipo date
import java.util.Iterator;

/**
 * 
 * @author Alyson Dantas
 *Classe Controller para intermediar os metodos do model e view
 */
public class SACMarianaController implements Serializable {//abro a classe controller
/**
 * Construtor
 */
	private static SACMarianaController unicaInstancia;
	Lista doador = new Lista();//cria a lista de doadores
	ArrayList<Produto> produtos = new ArrayList();
	Lista produto = new Lista();//cria a lista de produtos
	Lista doacao = new Lista();//cria a liasta de doa��es
    ArrayList<Doacao> doacoes = new ArrayList<>();
    ArrayList<Doador> doadores = new ArrayList<>();
	Lista listaauxiliar=null;//declaro a lista auxiliar para usar no futuro

	private SACMarianaController() {

	}

	public static synchronized SACMarianaController getInstance(){
		if(unicaInstancia==null){
			unicaInstancia = new SACMarianaController();
		}
		return unicaInstancia;
	}

	public static void zerarSingleton (){
		unicaInstancia = null;
	}

	/**
	 * Metodo para cadastrar novo produto e recebe por parametro as informa��es
	 * @param nome
	 * @param tipo
	 * @param dt_criacao
	 * @return novoProduto
	 */
	public boolean cadastrarProduto(String nome, String tipo, String dt_criacao) throws CampoObrigatorioInexistenteException, ProdutoExistenteException {
		if(nome == null || nome.trim().isEmpty() || tipo == null || tipo.trim().isEmpty() || dt_criacao == null || dt_criacao.trim().isEmpty()){
			throw new CampoObrigatorioInexistenteException();
		}
		Produto p = obProdutoNome(nome);
		if(p == null) {
			Produto novoProduto = new Produto();//cria nova celula de produto
			novoProduto.setNome(nome);//atribui na celula o nome
			novoProduto.setTipo(tipo);//atribui na celula o tipo
			novoProduto.setDataCadastro(dt_criacao);//atribui na celula a data
			boolean b = produtos.add(novoProduto);
			return b;//retorna o produto cadastrado
		}else{
			throw new ProdutoExistenteException();
		}
	}

	public Produto obProdutoNome(String nome){
		Iterator<Produto> itr = produtos.iterator();
		Produto aux = null;
		Produto p = null;
		while (itr.hasNext()){
			p=itr.next();
			if(p.getNome().equals(nome)){
				aux = p;
			}
		}
		return aux;
	}

	/**
	 * Metodo para editar produtos pelo id, recebe por parametro as informa��es do produto
	 * @param nome
	 * @param tipo
	 * @param dt_criacao
	 * @return Produto editado
	 */
	public boolean editarProduto(String nome, String tipo, String dt_criacao) throws CampoObrigatorioInexistenteException, ProdutoExistenteException {
		if(nome == null || nome.trim().isEmpty() || tipo == null || tipo.trim().isEmpty() || dt_criacao == null || dt_criacao.trim().isEmpty()){
			throw new CampoObrigatorioInexistenteException();
		}
		Produto auxiliar=obProdutoNome(nome);//auxiliar tipo produto rebe o produto informado atravez do metodo obterproduto
		if(auxiliar!=null){//se for diferente de nulo as novas informa��es s�o passadas para o objeto
			auxiliar.setDataCadastro(dt_criacao);
			auxiliar.setNome(nome);
			auxiliar.setTipo(tipo);
			return true;//retona auxiliar que tem o produto editado
		}else{
			throw new ProdutoExistenteException();
		}
	}

	/**
	 * Metodo para passar o iterador para listar
	 * @return iterador
	 */
	public ArrayList<Produto> listarProdutos() {
		return produtos;//retorno do iterador recebendo o primeiro elemento da lista produto
	}
	/**
	 * Metodo para remover um produto e recebe por parametro o id do produto a ser alterado
	 * @return true ou false do produto removido
	 */
	public boolean removerProduto(String nome) throws ConflitoException, ProdutoInexistenteException {
        Iterator<Doacao> itrDoacoes = doacoes.iterator();
        Produto removeProduto = null;
        Doacao removeDoacao = null;

        removeProduto = obProdutoNome(nome);
        if(removeProduto == null){
            throw new ProdutoInexistenteException();
        }
        while(itrDoacoes.hasNext()){
            removeDoacao = itrDoacoes.next();
            if(removeDoacao.getProduto().equals(removeProduto)){
                throw new ConflitoException();
            }
        }
        boolean a = produtos.remove(removeProduto);
        return a;
	}
	/**
	 * Metodo cadastrar doador, para cadastrar doador ele recebe por parametro as informa��es
	 * @param numCadastro
	 * @param nome
	 * @param dt_nascimento
	 * @param rua
	 * @param numero
	 * @param bairro
	 * @param cep
	 * @param cidade
	 * @param uf
	 * @param pais
	 * @param tipo
	 * @return novo doador
	 */
	public boolean cadastrarDoador(String numCadastro, String nome, String dt_nascimento, String rua, int numero, String bairro, String cep, String cidade, String uf, String pais, String tipo) throws CampoObrigatorioInexistenteException, ConflitoException {
		if(numCadastro == null || numCadastro.trim().isEmpty() || dt_nascimento == null || dt_nascimento.trim().isEmpty() || rua == null || rua.trim().isEmpty() || numero == 0 || bairro == null || bairro.trim().isEmpty()|| cep == null || cep.trim().isEmpty() || cidade == null || cidade.trim().isEmpty() || uf == null || uf.trim().isEmpty() || pais == null || pais.trim().isEmpty() || tipo == null || tipo.trim().isEmpty()){
            throw new CampoObrigatorioInexistenteException();
        }
        Doador novoDoador=new Doador();//cria nova celula de doador

		novoDoador.setNumCadastro(numCadastro);//atribui na celula o numero de cadastro
		novoDoador.setNome(nome);//atribui na celula o nome
		novoDoador.setDt_Nascimento(dt_nascimento);//atribui na celula a data de nascimento
		novoDoador.Enderecovem(rua, numero, bairro, cep, cidade, uf, pais);//entrega ao construtor as informa��es de endere�o
		novoDoador.setTipo(tipo);//atribui na celula o tipo

        Doador auxiliar = obterDoador(numCadastro);//cria auxiliar do tipo doador
        if(auxiliar !=null){
         throw new ConflitoException();
        }

        doadores.add(novoDoador);

        return true;//retonar o doador cadastrado
	}
	/**
	 * Metodo para editar o doador pelo numero de cadastro para alterar doador, recebe por parametro as informa��es do doador
	 * @param numCadastro
	 * @param nome
	 * @param dt_nascimento
	 * @param rua
	 * @param numero
	 * @param bairro
	 * @param cep
	 * @param cidade
	 * @param uf
	 * @param pais
	 * @param tipo
	 * @return
	 */
	public boolean editarDoador(String numCadastro, String nome, String dt_nascimento, String rua, int numero, String bairro, String cep, String cidade, String uf, String pais, String tipo) throws CampoObrigatorioInexistenteException, DoadorInexistenteException {
		if(numCadastro == null || numCadastro.trim().isEmpty() || dt_nascimento == null || dt_nascimento.trim().isEmpty() || rua == null || rua.trim().isEmpty() || numero == 0 || bairro == null || bairro.trim().isEmpty()|| cep == null || cep.trim().isEmpty() || cidade == null || cidade.trim().isEmpty() || uf == null || uf.trim().isEmpty() || pais == null || pais.trim().isEmpty() || tipo == null || tipo.trim().isEmpty()){
			throw new CampoObrigatorioInexistenteException();
		}
		Doador auxiliar=obterDoador(numCadastro);//auxiliar tipo doador rebe o doador informado atravez do metodo obterdoador
		if(auxiliar!=null){//se existir doador as novas informa��es s�o passadas ao objeto
			auxiliar.setNumCadastro(numCadastro);
			auxiliar.setNome(nome);
			auxiliar.setDt_Nascimento(dt_nascimento);
			auxiliar.Enderecovem(rua, numero, bairro, cep, cidade, uf, pais);
			auxiliar.setTipo(tipo);
			return true;
		}
		throw new DoadorInexistenteException();
	}
	/**
	 * Metodo para obter doador a partir do numero de cadastro
	 * @param numCadastro
	 * @return
	 */
	public Doador obterDoador(String numCadastro) {
		Doador auxiliar=null;//declara uma auxiliar do tipo doador
        Iterator<Doador> itr = doadores.iterator();
		while(itr.hasNext()){//enquanto existir elemento na lista
			auxiliar = itr.next();//auxiliar recebe o objeto atual e o iterador recebe a proxima celula
			if(numCadastro.contentEquals(auxiliar.getNumCadastro())){//se numero de cadastro do objeto de auxiliar for igual a numero de cadastro do objeto que � procurado
				return auxiliar;//retonar objeto encontrado
			}
        }
		return null;//se n�o retorna nulo
	}
	/**
	 * Metodo para remover doador pelo numero de cadastro
	 * @param numCadastro
	 * @return true ou false
	 */
	public boolean removerDoador(String numCadastro) throws DoadorInexistenteException, ConflitoException {
		Iterator<Doacao> itrDoacoes = doacoes.iterator();
		Doador removeDoador = null;
		Doacao removeDoacao = null;

		removeDoador = obterDoador(numCadastro);
		if(removeDoador == null){
			throw new DoadorInexistenteException();
		}
		while(itrDoacoes.hasNext()){
			removeDoacao = itrDoacoes.next();
			if(removeDoacao.getDoador().equals(removeDoador)){
				throw new ConflitoException();
			}
		}
		boolean a = doadores.remove(removeDoador);
		return a;
	}	
	/**
	 * metodo que retorna o iterador com o primeiro elemento da lista para ele ser listado na main
	 * @return iterador
	 */
	public Iterador listarDoadores() {
		return doador.iterador();//retorna o iterador com o primeiro elemento da lista doador
	}
	/**
	 * Metodo para cadastrar doa��o e recebe por parametro as informa��es
	 * @param quantidade
	 * @param dt_doacao
	 * @param tipo
	 * @return Nova doa��o
	 */
	public boolean efetuarDoacao(String nomeDoador, String nomeProduto, int quantidade, String dt_doacao,boolean tipo) throws CampoObrigatorioInexistenteException, ProdutoInexistenteException, DoadorInexistenteException {
		if(nomeProduto == null || nomeProduto.trim().isEmpty() || nomeDoador == null || nomeDoador.trim().isEmpty() || quantidade < 1 || dt_doacao == null || dt_doacao.trim().isEmpty()){
			throw new CampoObrigatorioInexistenteException();
		}
		Doador doador = obterDoador(nomeDoador);
		if(doador == null){
			throw new DoadorInexistenteException();
		}
		Produto produto = obProdutoNome(nomeProduto);
		if(produto == null){
			throw new ProdutoInexistenteException();
		}

		Doacao novaDoacao=new Doacao();//cria nova celula de doa��o
		novaDoacao.setDoador(doador);//atribui na celula a referencia do doador
		novaDoacao.setProduto(produto);//atribui na celula a referencia do produto
		novaDoacao.setQtd(quantidade);//atribui na celula a quantidade
		novaDoacao.setData(dt_doacao);//atribui na celula a data de doa��o
		novaDoacao.setMonetario(tipo);//atribui na celula o tpo de doa��o
		doacoes.add(novaDoacao);

		return true;
	}
	/**
	 * Metodo para alterar doa��o, recebe por parametro as informa��es da doa��o
	 * @param idDoacao
	 * @param quantidade
	 * @param dt_doacao
	 * @param tipo
	 * @return doa��o alterada
	 */
	public boolean alterarDoacao(Integer idDoacao, String numDoador, String nomeProduto, int quantidade, String dt_doacao, boolean tipo) throws CampoObrigatorioInexistenteException {
		Doacao auxiliar;//cria variavel auxiliar do tipo doa��o
		if(idDoacao<1 || numDoador == null || numDoador.trim().isEmpty() || nomeProduto == null || nomeProduto.trim().isEmpty() || quantidade < 1 || dt_doacao == null || dt_doacao.trim().isEmpty()){
			throw new CampoObrigatorioInexistenteException();
		}
		Produto produto = obProdutoNome(nomeProduto);
		Doador doador = obterDoador(numDoador);
		Iterator<Doacao> itr = doacoes.iterator();
		if(!doacoes.isEmpty()){
			while(itr.hasNext()){
				auxiliar = itr.next();
				if(auxiliar.getId_doacao() == idDoacao){
					auxiliar.setData(dt_doacao);
					auxiliar.setDoador(doador);
					auxiliar.setMonetario(tipo);
					auxiliar.setProduto(produto);
					auxiliar.setQtd(quantidade);
					return true;
				}
			}
		}
		return false;//se n�o retorna nulo
	}
	/**
	 * Metodo para remover determinada doa��o pelo id
	 * @param idDoacao
	 * @return true ou false
	 */
	public boolean removerDoacao(int idDoacao){
		Doacao doacao;
		Iterator<Doacao> itr = doacoes.iterator();
		while (itr.hasNext()){
			doacao = itr.next();
			if(doacao.getId_doacao() == idDoacao){
				doacoes.remove(doacao);
				return true;
			}
		}
		return false;//se n�o retorna false
	}
	/**
	 * Metodo que retorna o iterador com o primeiro elemento da lista doa��o para ele ser listado na main
	 * @param monetario
	 * @param doador
	 * @return iterador
	 */
	public Iterador listarDoacoesOrdenadas(boolean monetario, Doador doador){
		listaauxiliar=new Lista();//lista auxiliar � criada
		Doacao auxiliar;//cria variavel do tipo doa��o para auxiliar
		MeuIterador iterador=(MeuIterador) doacao.iterador();//cria iterador e ele recebe primeiro elemento da lista doa��o
		if(!(doacao.estaVazia())){//se a lista m�o estiver vazia
			if(monetario==true){//se for por monetario
				if(doador==null){//se doador vim nulo ent�o � pra listar todos
					while(iterador.temProximo()){//enquanto existir proximo elemento
						auxiliar=(Doacao)iterador.obterProximo();//auxiliar recebe elemento atual e iterador passa pro proximo
						if(auxiliar.isMonetario()==true){//se a atual for monetaria
							listaauxiliar.inserirInicio(auxiliar);//o elemento atual � inserido no inicio da lista auxiliar
						}
					}
					if(!listaauxiliar.estaVazia()){//se lista auxiliar n�o for vazia
						MeuIterador iterador2=(MeuIterador) ordenarLista();//iterador2 recebe a ordena��o da lista auxiliar 
						return iterador2;//retorna o iterador 2
					}
				}else{//se doador n�o vinher nulo
					while(iterador.temProximo()){//enquanto existir proximo elemento
						auxiliar=(Doacao)iterador.obterProximo();//auxiliar recebe objeto atual e iterador passa pro proximo
						if(auxiliar.isMonetario()==true){//se a atual for monetario
							if(doador.equals(auxiliar.getDoador())){//se doador for igual ao doador referenciado na auxiliar
								listaauxiliar.inserirInicio(auxiliar);//o elemento atual � inserido na lsita auxiliar
							}
						}
					}
					if(!listaauxiliar.estaVazia()){//se lista auxiliar n�o for vazia
						MeuIterador iterador2=(MeuIterador) ordenarLista();//iterador2 recebe a ordena��o da lista auxiliar
						return iterador2;//retirna o iterador 2
					}
				}
			}else{//se n�o for monetario
				if(doador==null){//se doador vim nulo ent�o � pra listar todos
					while(iterador.temProximo()){//se existir proximo elemento
						auxiliar=(Doacao)iterador.obterProximo();//auxiliar recebe atual e iterador passa pro proximo
						if(auxiliar.isMonetario()==false){//verifica se realmente n�o � monetario
							listaauxiliar.inserirInicio(auxiliar);//atual � inserida no inicio da lista auxiliar
						}
					}
					if(!listaauxiliar.estaVazia()){//se a lista auxiliar n�o for nula
						MeuIterador iterador2=(MeuIterador) ordenarLista();//iterador2 recebe a ordena��o da lista auxiliar
						return iterador2;//retorna o iterador 2
					}
				}else{//se n�o for nulo
					while(iterador.temProximo()){//se existir proximo elemento
						auxiliar=(Doacao)iterador.obterProximo();//auxiliar recebe atual e iterador passa pro proximo
						if(auxiliar.isMonetario()==false){//se monetario for false
							if(doador.equals(auxiliar.getDoador())){//se doador for igual referenciado dentro do atual
								listaauxiliar.inserirInicio(auxiliar);//atual � inserida no inicio da lista auxiliar
							}
						}
					}
					if(!listaauxiliar.estaVazia()){//se lsista auxiliar for diferente de nulo
						MeuIterador iterador2=(MeuIterador) ordenarLista();//iterador2 recebe a ordena��o da lista auxiliar
						return iterador2;//retorna o iterador 2
					}
				}
			}
		}
		return null;//se houver erro retorna nulo
	}
	/**
	 * Metodo para calcula percentual de doadores
	 */
	public void calcularPercentualDoadores(){
		double percentualTotalMonetario=0;//variavel para o percentual total monetario
		double percentualTotal=0;//variavel para o percentual total
		double percentual=0;//varivael para o percentual
		double quantidade=0;//variavel para a quantidade de doa��es por doador
		Doador auxiliardoador;//variavel auxiliar de doador
		Doacao auxiliardoacao;//variavel auxiliar de doa��o
		MeuIterador iteradordoacao = (MeuIterador) doacao.iterador();//iterador doa��o recebe primeiro elemento de doa��o
		MeuIterador iteradordoador = (MeuIterador) doador.iterador();//iterador doador recebe primeiro elemento de doador
		while(iteradordoacao.temProximo()){//enquanto houver proximo elemento na lista de doa��o
			auxiliardoacao=(Doacao) iteradordoacao.obterProximo();//auxiliar de doa��o recebe atual e iterador de doa��o recebe proximo
			if(auxiliardoacao.isMonetario()==true){//se atual for doa��o monetaria
				percentualTotalMonetario=percentualTotalMonetario+(double)auxiliardoacao.getQtd();//percentual total monetario recebe ele mais a quantidade da doa��o atual
			}else{//se n�o
				percentualTotal=percentualTotal+(double)auxiliardoacao.getQtd();//percentual total recebe ele mais a quantidade da doa��o atual
			}
		}
		iteradordoacao.reiniciar();//iterador de doa��o � reiniciado
		System.out.println("=====Total de doa��es n�o monetarias====");
		System.out.println("Total de doa��es n�o monetaria foi: "+percentualTotal);
		while(iteradordoador.temProximo()){//enquanto existir proximo doador
			auxiliardoador=(Doador) iteradordoador.obterProximo();//auxiliar de doador recebe atual e iterador passa pro proximo
			while(iteradordoacao.temProximo()){//enquanto existir proxima doa��o
				auxiliardoacao=(Doacao) iteradordoacao.obterProximo();//auxiliar doa��o recebe atual e iterador de doa��o passa pro proximo
				if(auxiliardoador.equals(auxiliardoacao.getDoador())){//se doador atual for igual ao referenciado na doa��o
					if(auxiliardoacao.isMonetario()==false){//se a doa��o n�o for monetaria
						quantidade=quantidade+(double)auxiliardoacao.getQtd();//quantidade recebe ela mesmo e a quantidade da doa��o
					}
				}
			}
			quantidade=quantidade*100;//quantidade � multiplicada por 100
			percentual=quantidade/percentualTotal;//percentual recebe quantidade dividida pelo percentual total
			System.out.println("Doador:"+auxiliardoador.getNome());//exibe nome do doador
			System.out.print("Percentual:"+percentual);//exibe percentual do doador
			System.out.println("%");
			System.out.println("");
			percentual=0;//reinicia as variaveis e o iterador de doa��o
			quantidade=0;
			iteradordoacao.reiniciar();
		}
		System.out.println("");
		System.out.println("=====Total de doa��es monetarias====");
		System.out.println("Total de doa��es monetaria foi: "+percentualTotalMonetario);
		iteradordoador.reiniciar();//iterador de doador � reiniciado
		while(iteradordoador.temProximo()){//enquanto existir proximo doador
			auxiliardoador=(Doador) iteradordoador.obterProximo();//auxiliar de doador recebe atual e iterador passa pro proximo
			while(iteradordoacao.temProximo()){//enquanto existir proxima doa��o
				auxiliardoacao=(Doacao) iteradordoacao.obterProximo();//auxiliar de do��o recebe o atual e iterador de doa��o passa pro proximo
				if(auxiliardoador.equals(auxiliardoacao.getDoador())){//se doador atual for igual ao doador referenciado na doa��o
					if(auxiliardoacao.isMonetario()==true){//se doa��o for monetaria
						quantidade=quantidade+(double)auxiliardoacao.getQtd();//quantidade recebe ela mais a quantidade de doa��o
					}
				}
			}
			quantidade=quantidade*100;//quantiade � multiplicada por 100
			percentual=quantidade/percentualTotalMonetario;//percentual recebe a quantidade dividida pelo percentual total monetario
			System.out.println("Doador:"+auxiliardoador.getNome());//exibe o doador
			System.out.print("Percentual:"+percentual);//exibe o percentual do doador
			System.out.println("%");
			System.out.println("");
			percentual=0;//reinicia as variavel e o iterador de doa��o
			quantidade=0;
			iteradordoacao.reiniciar();
		}
	}
	/**
	 * Metodo para ordenar uma lista
	 * @return iterador
	 */
	public Iterador ordenarLista(){
		int tamanho=0;//variavel para receber o tamanho da lista
		int indexauxiliar=0;//variavel auxiliar para receber o index
		int indexdepois=0;//variavel auxiliar para receber o index proximo ao indexauxiliar
		Doacao auxiliar;//varavel do tipo doa��o auxiliar
		MeuIterador iterador2=(MeuIterador) listaauxiliar.iterador();//iterador recebe o primeiro elemento da lista auxiliar
		Doacao depois=(Doacao)iterador2.obterProximo();//variavel do tipo doa��o que vai estar uma celula a frente da auxiliar
		tamanho=listaauxiliar.obterTamanho();//tamanho recebe o tamanho da lista pelo metodo obtertamanho
		while(iterador2.temProximo()){//enquanto houver um proximo elemento na lista
			indexdepois++;//index da proxima incrementa
			auxiliar=depois;//auxiliar recebe a proxima celula
			depois=(Doacao) iterador2.obterProximo();//depois passa pra proxima
			if( (double)auxiliar.getQtd()<(double)depois.getQtd() && tamanho>=indexdepois){//se quantidade da doa��o de auxiliar for menor que a quantidade da sucessora e depois n�o seja null
				listaauxiliar.bubbleSort(indexauxiliar, indexdepois);//o metodo bubble sort � chamado para trocar os objetos
				iterador2.reiniciar();//iterador volta ao inicio
				indexauxiliar=-1;//index auxiliar recebe -1
				indexdepois=0;//index da proxima de auxiliar recebe 0
				auxiliar=null;//auxiliar recebe null
				depois=(Doacao) iterador2.obterProximo();//depois recebe o primeiro elemento da lista
			}
			indexauxiliar++;//index auxiliar incrementa
		}
		iterador2.reiniciar();//iterador volta a primeira celula para ser retornado
		return iterador2;
	}

}