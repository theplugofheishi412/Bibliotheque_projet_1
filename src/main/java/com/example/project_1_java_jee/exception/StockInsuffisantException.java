package com.example.project_1_java_jee.exception;

import jakarta.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class StockInsuffisantException extends Exception{

    /*
    * Si une  erreur arrive, annule la transaction.
     */
    public StockInsuffisantException(String message){

        super(message);

    }
}
