package ru.traning.controllers;


import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.traning.Dao.HumanDao;
import ru.traning.modules.Human;
import ru.traning.modules.HumanCrowd;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HumanKeeper {

    protected HumanCrowd humanCrowd= new HumanCrowd();
    @PostMapping(value="/human/create/")
    public ResponseEntity<String > createHuman(@RequestBody Human human){
       return new ResponseEntity<>(this.humanCrowd.addHuman(human),HttpStatus.BAD_REQUEST );
    }
    @GetMapping(value = "/human/list/")
    public List<Human> humanList(){
        return this.humanCrowd.findAll();
    }
    @GetMapping(value = "/human/list/{id}")
    public Object getHumanByID(@PathVariable int id ){
       return this.humanCrowd.findById(id);
    }
    @PatchMapping(value = "human/patch/{id}")
    public ResponseEntity<String> updateHuman(@PathVariable int id, @RequestBody Human human){
        return new ResponseEntity<>(this.humanCrowd.changeHumanInfo(id,human),HttpStatus.FORBIDDEN);
    }


}
