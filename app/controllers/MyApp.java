package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.time.LocalDateTime;

public class MyApp extends Controller{

    public Result index(){
        return ok("It works1!\n\n\n FINE!!");
    }


    public Result reqWithParams3(String name){
        return ok("Welcome to Play, " + name);
    }

    public Result reqWithParams(String name){
        return badRequest("Oh, something went wrong").withHeader("time", LocalDateTime.now().toString());
    }

    public Result reqWithParams2(String name){
        return notFound("<h1>Page not found, " + name + "</h1>").as("text/html");
    }
}

