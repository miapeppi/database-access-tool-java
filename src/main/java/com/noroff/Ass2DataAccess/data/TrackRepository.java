package com.noroff.Ass2DataAccess.data;

import com.noroff.Ass2DataAccess.models.Album;
import com.noroff.Ass2DataAccess.models.Artist;
import com.noroff.Ass2DataAccess.models.Genre;
import com.noroff.Ass2DataAccess.models.Track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrackRepository implements com.noroff.Ass2DataAccess.data.interfaces.TrackRepository{
    public List<Track> getRandom(int amount) {
        List<Track>list = new ArrayList<>();

        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT TrackId, Name from Track BY random() LIMIT ?");

            preparedStatement.setString(1, toString().valueOf(amount));

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Track track = new Track();
                track.setTrackId(resultSet.getInt("TrackId"));
                track.setName(resultSet.getString("Name"));

                list.add(track);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return list;
    }

    public List<Track> search(String term) {
        List<Track>list = new ArrayList<>();

        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT Track.TrackId AS TrackId, Track.Name AS TrackName, " +
                            "Album.Title AS Title, " +
                            "Genre.Name AS GenreName " +
                            "FROM Track INNER JOIN Album ON Track.AlbumId = Album.AlbumId " +
                            "INNER JOIN Genre ON Track.GenreId = Genre.GenreId " +
                            "WHERE TrackName LIKE ? " +
                            "GROUP BY Track.TrackId, Track.Name, Track.Composer " +
                            "ORDER BY TrackId DESC");

            preparedStatement.setString(1, term);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Track track = new Track();
                track.setTrackId(resultSet.getInt("TrackId"));
                track.setName(resultSet.getString("TrackName"));

                Album album = new Album();
                album.setTitle(resultSet.getString("Title"));

                Genre genre = new Genre();
                genre.setName(resultSet.getString("GenreName"));

                track.setAlbum(album);
                track.setGenre(genre);

                list.add(track);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return list;
    }
}
