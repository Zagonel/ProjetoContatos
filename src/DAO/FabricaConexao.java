package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FabricaConexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/pessoas";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "";
    private static final String DRIVER = "org.postgresql.Driver";

    public static Connection IniciarConexao() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados: " + e);
        }
    }

    public static void FecharConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }

    public static void FecharConexao(Connection con, PreparedStatement stmt) {
        FecharConexao(con);
        try {
            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }

    public static void FecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
        FecharConexao(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }
    
}
