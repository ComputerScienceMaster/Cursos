
package Views;

import Controlers.PessoaJpaController;
import Models.Pessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class GerenciarPessoa {
    private Pessoa pessoaAtual = new Pessoa();
    private PessoaJpaController controlPessoa = new PessoaJpaController(EmProvider.getInstance().getEntityManagerFactory());
    
    public GerenciarPessoa() {
    }

    public String gotoAdicionarPessoa(){
        return "CriarPessoa";
    }
    
    public String salvarPessoa(){
        controlPessoa.create(pessoaAtual);
        return "sucesso";
    }
    
    public Pessoa getPessoaAtual() {
        return pessoaAtual;
    }

    public void setPessoaAtual(Pessoa pessoaAtual) {
        this.pessoaAtual = pessoaAtual;
    }
    
    
}
