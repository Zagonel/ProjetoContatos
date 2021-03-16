/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DAO.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author igor_
 */
public class OperacoesBD {

    public static void recuperaDados() {
        Connection con = FabricaConexao.IniciarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT *FROM contatos ORDER BY nome ASC");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario userCadastrado = new Usuario();
                userCadastrado.setNome(rs.getString("nome"));
                userCadastrado.setEmail(rs.getString("email"));
                userCadastrado.setFone1(rs.getString("fone1"));
                userCadastrado.setFone2(rs.getString("fone2"));
                userCadastrado.setEndereco(rs.getString("endereco"));

                System.out.println(userCadastrado + "\n");
            }
        } catch (SQLException ex) {
            System.out.println("Erro na busca dos dados");
        } finally {
            FabricaConexao.FecharConexao(con, stmt, rs);
        }

    }

    public static void cadastroDados(Usuario user) {
        Connection con = FabricaConexao.IniciarConexao();
        PreparedStatement stmt = null;

        try {
            if (user.getNome().trim().equals("") || user.getEmail().equals("Escolha") || user.getEndereco().trim().equals("") || user.getFone1().trim().equals("") || user.getFone2().trim().equals("")) {
                System.out.println("Preencha todos os dados!!!");

            } else {

                stmt = con.prepareStatement("INSERT INTO contatos (nome,endereco,fone1,fone2,email) VALUES (?,?,?,?,?)");
                stmt.setString(1, user.getNome());
                stmt.setString(2, user.getEndereco());

                stmt.setString(3, user.getFone1());
                stmt.setString(4, user.getFone2());
                stmt.setString(5, user.getEmail());

                stmt.executeUpdate();

                System.out.println("Usuario cadastrado com sucesso \n\n");

            }
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar usuario" + ex.getMessage());
        } finally {
            FabricaConexao.FecharConexao(con, stmt);
        }
    }

}
