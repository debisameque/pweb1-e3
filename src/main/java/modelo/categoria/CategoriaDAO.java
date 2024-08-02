package modelo.categoria;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public ArrayList<Categoria> obterTodas() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT id, nome, descricao FROM categoria ORDER BY id");
            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(resultSet.getInt("id"));
                categoria.setNome(resultSet.getString("nome"));
                categoria.setDescricao(resultSet.getString("descricao"));
                categorias.add(categoria);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro ao se comunicar com o Banco de Dados");
        }
        return categorias;
    }

    public Categoria obterCategoria(int id) {
        Categoria categoria = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id, nome, descricao FROM categoria WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                categoria = new Categoria();
                categoria.setId(resultSet.getInt("id"));
                categoria.setNome(resultSet.getString("nome"));
                categoria.setDescricao(resultSet.getString("descricao"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro ao se comunicar com o Banco de Dados");
        }
        return categoria;
    }

    public boolean inserirCategoria(String nome, String descricao) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO categoria (nome, descricao) VALUES (?, ?)");
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, descricao);
            int linhasInseridas = preparedStatement.executeUpdate();
            sucesso = linhasInseridas == 1;
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro ao se comunicar com o Banco de Dados");
            System.err.println(ex);
        }
        return sucesso;
    }

    public boolean atualizarCategoria( int id, String nome, String descricao) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categoria SET nome = ?, descricao = ? WHERE id = ?");
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, descricao);
            preparedStatement.setInt(3,id);
            int linhasAtualizadas = preparedStatement.executeUpdate();
            sucesso = linhasAtualizadas == 1;
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro ao se comunicar com o Banco de Dados");
            System.err.println(ex);
        }
        return sucesso;
    }


    public boolean removerCategoria(int id) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categoria WHERE id = ?");
            preparedStatement.setInt(1,id);
            int linhasRemovidas = preparedStatement.executeUpdate();
            sucesso = linhasRemovidas == 1;
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro ao se comunicar com o Banco de Dados");}
        return sucesso;
    }
}
