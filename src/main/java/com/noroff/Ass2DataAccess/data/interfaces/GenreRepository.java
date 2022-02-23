package com.noroff.Ass2DataAccess.data.interfaces;

import com.noroff.Ass2DataAccess.models.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository {
    List<Genre> getRandom(int amount);

}
