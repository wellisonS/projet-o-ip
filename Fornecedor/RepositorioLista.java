package Fornecedor;

public class RepositorioLista implements Repositorio{
    private Fornecedor fornecedor;
    private RepositorioLista proximo;
    public RepositorioLista(){
        this.fornecedor = null;
        this.proximo = null;
    }

    @Override
    public void remover(String cnpj) throws FornecedorNaoEncontradoException {
        if (this.fornecedor.getCnpj().equals(cnpj)){
            this.fornecedor = this.proximo.fornecedor;
            this.proximo = this.proximo.proximo;
        } else if (this.proximo != null){
            this.proximo.remover(cnpj);
        } else {
            throw  new FornecedorNaoEncontradoException();
        }
    }

    @Override
    public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException {
        if (this.fornecedor.getCnpj().equals(cnpj)){
            return this.fornecedor;
        } else if (this.proximo != null){
           return this.proximo.procurar(cnpj);
        } else {
            throw new FornecedorNaoEncontradoException();
        }


    }

    @Override
    public void cadastrar(Fornecedor fornecedor) throws FornecedorJaCadastradoException{
        if (this.fornecedor == null){
            this.fornecedor = fornecedor;
            this.proximo = new RepositorioLista();
        }
        else if (this.fornecedor.getCnpj().equals(fornecedor.getCnpj())){
            throw new FornecedorJaCadastradoException();
        }

        else{
            this.proximo.cadastrar(fornecedor);
        }
    }

    @Override
    public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
        if (this.fornecedor.getCnpj().equals(fornecedor.getCnpj())){
            this.fornecedor.setNomeFantasia(fornecedor.getNomeFantasia());
            this.fornecedor.setTipoProduto(fornecedor.getTipoProduto());
        } else if (this.proximo != null){
            this.proximo.atualizar(fornecedor);
        } else {
            throw new FornecedorNaoEncontradoException();
        }

    }
}
