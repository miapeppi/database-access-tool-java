package com.noroff.Ass2DataAccess.data;

import com.noroff.Ass2DataAccess.models.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository implements com.noroff.Ass2DataAccess.data.interfaces.ArtistRepository {
    public List<Artist> getRandom(int amount) {
        List<Artist>list = new ArrayList<>();

        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT ArtistId, Name FROM Artist ORDER BY random() LIMIT ?");

            preparedStatement.setString(1, toString().valueOf(amount));

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Artist artist = new Artist();
                artist.setArtistId(resultSet.getInt("ArtistId"));
                artist.setName(resultSet.getString("Name"));

                list.add(artist);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return list;
    }

}
