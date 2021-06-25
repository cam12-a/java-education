package ru.traning.Dao;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ru.traning.modules.Human;
import ru.traning.modules.HumanCrowd;

import java.util.List;

public interface HumanDao {
   public String addHuman(Human humanCrowd);
    public List<Human> findAll();
    public Object findById(int id);
    public String changeHumanInfo(int id,Human human);
    public boolean humanExist(int id,Human human);
    public boolean humanExist(Human human);

}
