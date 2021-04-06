package Views;

import Controlers.PessoaJpaController;
import Controlers.exceptions.NonexistentEntityException;
import Models.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class GerenciarPessoa {

    private Pessoa pessoaAtual = new Pessoa();
    private List<Pessoa> listaPessoas = new ArrayList<>();
    private PessoaJpaController controlPessoa = new PessoaJpaController(EmProvider.getInstance().getEntityManagerFactory());

    public GerenciarPessoa() {
    }

    public String gotoAdicionarPessoa() {
        return "CriarPessoa";
    }
    
    public String gotoEditarPessoa() {
        return "EditarPessoa";
    }

    public String gotoListarPessoas() {
        listarPessoas();
        return "ListarPessoas";
    }

    public String salvarPessoa() {
        controlPessoa.create(pessoaAtual);
        return "sucesso";
    }
    
    public String editarPessoa() {
        try {
            controlPessoa.edit(pessoaAtual);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ListarPessoas";
    }
    
    
    public String deletePessoa() {
        try {
            controlPessoa.destroy(pessoaAtual.getId());
            listarPessoas();
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GerenciarPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ListarPessoas";
    }
    
    public void listarPessoas() {
        listaPessoas = controlPessoa.findPessoaEntities();
    }

    public Pessoa getPessoaAtual() {
        return pessoaAtual;
    }

    public void setPessoaAtual(Pessoa pessoaAtual) {
        this.pessoaAtual = pessoaAtual;
    }

    public List<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public void setListaPessoas(List<Pessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
    }
}
