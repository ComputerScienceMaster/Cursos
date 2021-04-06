
import Controler.PessoaDAO;
import Model.Pessoa;


public class TestandoPersistencia {
    public static void main(String[] args) {
        Pessoa p = new Pessoa(0, "vinicius", "vinistos@gmail.com", "12345");
        
        PessoaDAO pDao = new PessoaDAO();
        pDao.criar(p);
        
        System.out.println(pDao.lerPorId(1));
    }
}
