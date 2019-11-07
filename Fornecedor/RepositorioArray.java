package Fornecedor;

public class RepositorioArray implements Repositorio {
   private Fornecedor [] fornecedor;
   private  int index ;
   public RepositorioArray(){
       this.fornecedor = new Fornecedor [100];
       this.index = 0;
   }

   public int getIndice(String cnpj){
       int fornecedor  = -1;
       boolean falsoBreak = false;
       for (int i = 0; i < this.index && !falsoBreak;i++){
           if (this.fornecedor[this.index].getCnpj().equals(cnpj)){
               fornecedor = i;
               falsoBreak = true;

           }
       }

    return fornecedor;
   }
    @Override
    public void remover(String cnpj) throws FornecedorNaoEncontradoException {

    }

    @Override
    public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException {
       Fornecedor fornecedor  = null;
       boolean falsoBreak = false;
       for (int i = 0; i < this.index && !falsoBreak;i++){
           if (this.fornecedor[this.index].getCnpj().equals(cnpj)){
                fornecedor = this.fornecedor[i];
                falsoBreak = true;

           }
       }


       return fornecedor;
    }

    @Override
    public void cadastrar(Fornecedor fornecedor) throws FornecedorJaCadastradoException {

          for (int i = 0; i < this.index;i++){
              if (this.fornecedor[i].getCnpj().equals(fornecedor.getCnpj())){
                  throw new FornecedorJaCadastradoException();
              }
           }
          this.fornecedor[this.index] = fornecedor;
          this.index++;


    }

    @Override
    public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {

    }
}
