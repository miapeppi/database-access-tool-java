package com.noroff.Ass2DataAccess.data.interfaces;

import com.noroff.Ass2DataAccess.models.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository {
    List<Artist> getRandom(int amount);
}
