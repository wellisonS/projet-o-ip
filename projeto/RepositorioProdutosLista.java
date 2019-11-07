package projeto;

public class RepositorioProdutosLista implements repositorioprodutos  {
	private Produto produto;
	private RepositorioProdutosLista proximo;
	public RepositorioProdutosLista() {
		this.produto=null;
		this.proximo=new RepositorioProdutosLista();
	}
	
	public void cadastrar(Produto produto)throws ProdutoJaCadastradoException {
		if(this.proximo==null) {
			this.produto=produto;
			this.proximo=new RepositorioProdutosLista();
		}else if(this.produto.getIdentificador().equals(produto.getIdentificador())){
			throw new ProdutoJaCadastradoException();
		}else {
			this.proximo.cadastrar(produto);
		}
	}

	

	public void remover(String identificador)throws ProdutoNaoEncontradoException {
		if(this.proximo==null) {
			throw new ProdutoNaoEncontradoException();
		}else if(this.produto.getIdentificador().equals(produto.getIdentificador())) {
			this.produto=this.proximo.produto;
			this.proximo=this.proximo.proximo;
		}else {
			this.proximo.remover(identificador);
		}
		
	}
	
	public void atualizar(Produto produtonovo) throws ProdutoNaoEncontradoException{
		if(this.proximo==null) {
			throw new ProdutoNaoEncontradoException();
		}else if(this.produto.getIdentificador().equals(produto.getIdentificador())) {
			this.produto=produtonovo;
		}else {
			this.proximo.atualizar(produtonovo);
		}
		
	}

	
	public String procurar(String identificador) throws ProdutoNaoEncontradoException {
		String retorna="";
		if(this.proximo==null){
			throw new ProdutoNaoEncontradoException();
		}else if(this.produto.getIdentificador().equals(produto.getIdentificador())) {
			retorna=produto.getMarca()+"\n"+produto.getModelo()+"\n"+produto.getTamanho()+"/n"+produto.getPreco();
		}else {
			this.proximo.procurar(identificador);
		}
		return retorna;
	}
	
}
