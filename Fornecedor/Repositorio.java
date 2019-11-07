package Fornecedor;

public interface Repositorio {
    public void remover (String cnpj) throws FornecedorNaoEncontradoException;
    public void atualizar (Fornecedor fornecedor) throws FornecedorNaoEncontradoException;
    public void cadastrar (Fornecedor fornecedor) throws FornecedorJaCadastradoException;
    public Fornecedor procurar (String dados) throws FornecedorNaoEncontradoException;


    }

