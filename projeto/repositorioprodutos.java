package projeto;

public interface repositorioprodutos {

	public void cadastrar(Produto produto) throws ProdutoJaCadastradoException;

	public String procurar(String identificador) throws ProdutoNaoEncontradoException;

	public void remover(String identificador)throws ProdutoNaoEncontradoException;

	public void atualizar(Produto produtonov) throws ProdutoNaoEncontradoException;
}
