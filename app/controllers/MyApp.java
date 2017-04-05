package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class MyApp extends Controller{

    public Result index(){
        return ok("It works1!\n\n\n FINE!!");
    }
}
