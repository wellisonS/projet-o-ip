package projeto;

public class ProdutoNaoEncontradoException extends Exception {

	public ProdutoNaoEncontradoException() {
		super("Erro. O produto não foi encontrado!!");
	}
}
