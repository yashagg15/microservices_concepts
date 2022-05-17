package com.project.springrestfulmicroservice.Controller;

import com.project.springrestfulmicroservice.model.User_V1;
import com.project.springrestfulmicroservice.model.User_V2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

//    Here we are versioning two different types of user having different in name fields with params versioning

    @RequestMapping(value="/getUser",method = RequestMethod.GET,params = "version=1")
    public User_V1 getUserWithVersion1(){
        return new User_V1(1,"yash agarwal",23,"My name is Yash");
    }

    @RequestMapping(value="/getUser",method = RequestMethod.GET,params = "version=2")
    public User_V2 getUserWithVersion2(){
        return new User_V2(1,"yash","agarwal",23,"My name is Yash");

    }
    //   Here we are versioning two different types of user having different in name fields with header versioning

    @RequestMapping(value="/getUser",method = RequestMethod.GET,headers = "X-API-VERSION=3")
    public User_V1 getUserWithVersion3(){
        return new User_V1(1,"yash agarwal",23,"My name is Yash");
    }

    @RequestMapping(value="/getUser",method = RequestMethod.GET,headers = "X-API-VERSION=4")
    public User_V2 getUserWithVersion4(){
        return new User_V2(1,"yash","agarwal",23,"My name is Yash");

    }
    //   Here we are versioning two different types of user having different in name fields with MIME MEDIA TYPE versioning in the accept header while sending

    @RequestMapping(value="/getUser",method = RequestMethod.GET,produces = "application/vnd.myname.v5+json")
    public User_V1 getUserWithVersion5(){
        return new User_V1(1,"yash agarwal",23,"My name is Yash");
    }

    @RequestMapping(value="/getUser",method = RequestMethod.GET,produces = "application/vnd.myname.v6+json")
    public User_V2 getUserWithVersion6(){
        return new User_V2(1,"yash","agarwal",23,"My name is Yash");

    }

}
