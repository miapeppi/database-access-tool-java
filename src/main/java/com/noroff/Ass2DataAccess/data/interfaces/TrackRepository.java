package com.noroff.Ass2DataAccess.data.interfaces;

import com.noroff.Ass2DataAccess.models.Track;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository {
    List<Track> getRandom(int amount);
    List<Track> search(String search);
}
