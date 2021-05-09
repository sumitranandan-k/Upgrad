package com.example.upgrad.firstrestAPI.Controllers;
import com.example.upgrad.firstrestAPI.Resources.userObject;
import com.example.upgrad.firstrestAPI.Source.sourceclass;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="controllerone")
public class controllerone {

//------------------------Dont change the code enclosed----------------------------------------------------------------------------------------------------------------------------------------------------
    Map<Integer,userObject> internalmap = new HashMap<>();                  //
    controllerone() {                                                      //
        sourceclass s = new sourceclass();                                //
        internalmap = s.populate();                                       //
    }                                                                   //
//-------------------------Write your code below this line---------------------------------------------------------------------------------------------------------------------------------------------------------
    @GetMapping(value = "/getuser/{userid}")
    public ResponseEntity getuserbyid(@PathVariable("userid") int id){

        if (internalmap.containsKey(id)){
            return new ResponseEntity(internalmap.get(id), HttpStatus.OK);
        } else{
            return  new ResponseEntity("User not found",HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create = POST     *
     */
    @PostMapping(value = "/createuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createuser(@RequestBody userObject userObject){
        internalmap.put(internalmap.size()+1,userObject);
        return new ResponseEntity(userObject, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getallusers(){
        List<userObject> users = new ArrayList<>();

        for (userObject user : internalmap.values()) users.add(user);

        return  new ResponseEntity(users, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{userid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateuserbyid(@PathVariable("userid") int id, @RequestBody userObject userObject){
        internalmap.put(id, userObject);

        return new ResponseEntity(internalmap.get(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteuserbyid(@PathVariable("id") int id){

        userObject userObject = internalmap.get(id);
        internalmap.remove(id);

        return new ResponseEntity(userObject, HttpStatus.OK);
    }
}





