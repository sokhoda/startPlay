package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class MyApp extends Controller{

    public Result index(){
        return ok("It works1!\n\n\n FINE!!");
    }


    public Result reqWithParams3(String name){
        return ok("Welcome to Play, " + name);
    }

    public Result reqWithParams(String name){
        return seeOther("/");
    }

    public Result reqWithParams2(String name){
        return notFound("<h1>Page not found, " + name + "</h1>").as("text/html");
    }
}
