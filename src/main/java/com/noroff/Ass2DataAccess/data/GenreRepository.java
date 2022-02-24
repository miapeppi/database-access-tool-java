package com.noroff.Ass2DataAccess.data;

import com.noroff.Ass2DataAccess.models.Genre;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenreRepository implements com.noroff.Ass2DataAccess.data.interfaces.GenreRepository{
    public List<Genre> getRandom(int amount) {
        List<Genre>list = new ArrayList<>();

        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT GenreId, Name FROM Genre ORDER BY random() LIMIT ?");

            preparedStatement.setString(1, toString().valueOf(amount));

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Genre genre = new Genre();
                genre.setGenreId(resultSet.getInt("GenreId"));
                genre.setName(resultSet.getString("Name"));

                list.add(genre);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return list;
    }
}
