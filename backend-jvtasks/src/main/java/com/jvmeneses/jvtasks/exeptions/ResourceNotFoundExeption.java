package com.jvmeneses.jvtasks.exeptions;

public class ResourceNotFoundExeption extends RuntimeException {

    public ResourceNotFoundExeption(String msg){
        super(msg);
    }
}
