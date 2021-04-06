package testandoJPA;

import Controlers.PessoaJpaController;
import Models.Pessoa;
import Views.EmProvider;


public class TestandoJPA {
    public static void main(String[] args) {
        Pessoa p = new Pessoa(Long.MIN_VALUE, "vinicius");
        PessoaJpaController control = 
                new PessoaJpaController(EmProvider
                        .getInstance()
                        .getEntityManagerFactory());
        control.create(p);
        
    }
}
