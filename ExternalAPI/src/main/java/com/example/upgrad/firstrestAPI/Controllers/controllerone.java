package com.example.upgrad.firstrestAPI.Controllers;
import com.example.upgrad.firstrestAPI.Resources.userObject;
import com.example.upgrad.firstrestAPI.Source.sourceclass;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = {"controllerone"})
public class controllerone {

//------------------------Dont change the code enclosed----------------------------------------------------------------------------------------------------------------------------------------------------
    Map<Integer,userObject> internalmap = new HashMap<>();                  //
    controllerone() {                                                      //
        sourceclass s = new sourceclass();                                //
       internalmap = s.populate();                                       //
    }                                                                   //
//-------------------------Write your code below this line---------------------------------------------------------------------------------------------------------------------------------------------------------


    @GetMapping(value = "/getuser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getuserbyid(@PathVariable("id") int id){                      //todo: Hands on GETUSER
        return new ResponseEntity(internalmap.get(id), HttpStatus.OK);
    }

    @PostMapping(value = "/createuser",produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createuser(@RequestBody userObject userObject){        //todo: Hands on POSTUSER
        internalmap.put(internalmap.size()+1,userObject);
        return new ResponseEntity(userObject,HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity getallusers(){
        List<userObject> list = new ArrayList<>();
        for (userObject u: internalmap.values()
             ) {                                                                 //todo: Hands on GETALLUSER
            list.add(u);
        }
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateuserbyid(@RequestBody userObject userObject,@PathVariable("id") int id){
        internalmap.put(id,userObject);                                                      //todo: Hands on PUTUSER
        return new ResponseEntity(userObject,HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteuserbyid(@PathVariable("id") int id){
        userObject userObject1 = internalmap.get(id);                                       // //todo: Hands on DELETEUSER
        internalmap.remove(id);
        return new ResponseEntity(userObject1,HttpStatus.OK);

    }

}





