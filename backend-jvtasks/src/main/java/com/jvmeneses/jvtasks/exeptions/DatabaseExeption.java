package com.jvmeneses.jvtasks.exeptions;

public class DatabaseExeption extends RuntimeException{

    public DatabaseExeption(String msg){
        super(msg);
    }
}
