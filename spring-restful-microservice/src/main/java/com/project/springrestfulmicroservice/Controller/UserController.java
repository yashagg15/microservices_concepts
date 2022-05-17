package com.project.springrestfulmicroservice.Controller;

import com.project.springrestfulmicroservice.Exception.UserNotFound;
import com.project.springrestfulmicroservice.Repository.UserRepository;
import com.project.springrestfulmicroservice.model.ResponseEntityDTOs;
import com.project.springrestfulmicroservice.model.User_V1;
import com.project.springrestfulmicroservice.model.User_V2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class UserController {

    @Autowired
    public UserRepository userRepo;

    private static List<User_V1> lis=new ArrayList<>();
    static {
        User_V1 user1=new User_V1();
        user1.setId(1);
        user1.setName("yash");
        user1.setAge(23);

        User_V1 user2=new User_V1();
        user2.setId(2);
        user2.setName("tushar");
        user2.setAge(23);
        lis.add(user1);
        lis.add(user2);
    }

    @RequestMapping(path = "/getAllUsers",method = RequestMethod.GET)
    public List<User_V2> getAllUsers(){
        Iterable<User_V2> itr= userRepo.findAll();
        List<User_V2> lis=new ArrayList<>();
        itr.forEach(lis::add);
        return lis;
    }

    @RequestMapping(path = "/retrieveUserById/{id}",method = RequestMethod.GET)
    public User_V2 getUserById(@PathVariable Long id){
        Optional<User_V2> opt=userRepo.findById(id);
        if(opt.isPresent())
            return opt.get();
        throw new UserNotFound("User with this id "+id+" Not Found");
    }
//With HateOas
    @RequestMapping(path = "/retrieveUser/{id}",method = RequestMethod.GET)
        EntityModel<User_V1> retrieveUser(@PathVariable("id") Long id){


       for(User_V1 user:lis){
           if(user.getId()==id) {
//               Using Hateoas to retrieve user response with other link related to it like getAllUser link
           EntityModel<User_V1> em=EntityModel.of(user);

               WebMvcLinkBuilder linkToAllUsers=linkTo(methodOn(this.getClass()).getAllUsers());
               em.add(linkToAllUsers.withRel("all-ref"));
               return em;

           }
       }


       throw new UserNotFound("User not found with id "+ id);

    }


    @RequestMapping(path = "/addUser",method = RequestMethod.POST)
    ResponseEntity<ResponseEntityDTOs> helloWorld(@RequestBody User_V2 user){

        ResponseEntityDTOs response=new ResponseEntityDTOs();
        userRepo.save(user);
        response.setMessage("User successfully added");
        return new ResponseEntity<ResponseEntityDTOs>(response,HttpStatus.CREATED);
    }
}
