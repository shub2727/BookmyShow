package com.BookMyShow_User.Exception;

public class ResourceNotFoundException extends RuntimeException{


    ResourceNotFoundException(){
        super();
    }

    String resourceName;
    String fieldName;
    String fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super((String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue)) );
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
