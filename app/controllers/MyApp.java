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

    public Result welcomeList(String name, int from, int to){
        StringBuilder sb = new StringBuilder();
        for (int i = from; i <= to; i++) {
             sb.append(i+ "\n");
        }
        return ok("Welcome to Play, " + name + "\n" + sb.toString());
    }

    public Result reqWithParamsFalse(String name, boolean verbose){
            return ok("verbose:: "+ verbose + " Oh, something went wrong").withHeader("time", LocalDateTime.now()
                    .toString());
    }

    public Result reqWithParamsTrue(String name, boolean verbose){
            return ok("verbose::" + verbose);
    }

    public Result reqWithParams2(String name){
        return notFound("<h1>Page not found, " + name + "</h1>").as("text/html");
    }
}

