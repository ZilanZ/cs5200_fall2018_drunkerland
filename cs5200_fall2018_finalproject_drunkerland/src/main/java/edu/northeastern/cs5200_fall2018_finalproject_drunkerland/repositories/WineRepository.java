package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.sql.Date;

public interface WineRepository  extends CrudRepository<Wine, Integer>{
    @Query("select w from Wine w where w.name=:name")
    Wine findWineByName(@Param("name") String name);

    @Query("select w from Wine w where w.vintage=:vintage")
    List<Wine> findWineByVintage(@Param("vintage") String vintage);

    @Query("select w from Wine w where w.color=:color")
    List<Wine> findWineByColor(@Param("color") String color);

    @Query("select w from Wine w where w.appellation=:appellation")
    List<Wine> findWineByAppellation(@Param("appellation") String appellation);

    @Query("select w from Wine w where w.country=:country")
    List<Wine> findWineByCountry(@Param("country") String country);


    @Query("select w from Wine w where w.region=:region")
    List<Wine> findWineByRegion(@Param("region") String region);

    @Query("select w from Wine w where w.score>=:least and w.score<=:greatest")
    List<Wine> findWineBetweenScores(@Param("least") float least, @Param("greatest") float greatest);

    @Query("select w from Wine w where w.date between :startDate and :endDate")
    List<Wine> findWineByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
