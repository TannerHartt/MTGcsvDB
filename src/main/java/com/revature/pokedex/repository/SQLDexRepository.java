package com.revature.pokedex.repository;

import com.revature.pokedex.domain.Mtg;

import java.sql.*;
import java.util.List;

public class SQLDexRepository implements DexRepository {

    @Override
    public Mtg getCard(String name) {
        Mtg result = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            String query = "select * from cards where name = '" + name + "'";
            Statement statement = conn.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while ( resultSet.next()) {
                result = Mtg.of()
                        .name(resultSet.getString("name"))
                        .manaCost(resultSet.getInt("manacost"))
                        .type(resultSet.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Mtg> getCards() {
        return null;
    }
}
