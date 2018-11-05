package Controler;

import Model.Pessoa;
import Util.DbConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO {

    public boolean criar(Pessoa p) {
        Connection conn = DbConnect.getConexaoMySQL();
        String insertSQL = "INSERT INTO Pessoa (nomePessoa, senhaPessoa, emailPessoa) VALUES ('"
                + p.getNomePessoa() + "','"
                + p.getSenhaPessoa() + "','"
                + p.getEmailPessoa() + "')";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(insertSQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean update(Pessoa p) {
        return true;
    }

    public boolean delete(Pessoa p) {
        return true;
    }

    public Pessoa lerPorId(int id) {
        Pessoa p = new Pessoa();
        Connection conn = DbConnect.getConexaoMySQL();
        String selectSQL = "SELECT * FROM Pessoa WHERE idPessoa = " + id;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(selectSQL);
            while (rs.next()) {
                p.setNomePessoa(rs.getString("nomePessoa"));
                p.setSenhaPessoa(rs.getString("senhaPessoa"));
                p.setEmailPessoa(rs.getString("emailPessoa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public List<Pessoa> lerTodas() {
        List<Pessoa> listaDePessoas = new ArrayList<>();
        return listaDePessoas;
    }

}
