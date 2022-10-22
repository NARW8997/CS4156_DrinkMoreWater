package com.cs4256.drinkmorewater.repositories;

import com.cs4256.drinkmorewater.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
    CrudRepository already has the following functions:
        (in the form): function_name(parameter:parameter_type):return_type
        save(entity:S):S
        saveAll(entities:Iterable<S>):Iterable<S>
        findById(id:T):Optional<T>
        existsById(id:ID):boolean
        findAll():Iterable<T>
        findAllById(ids:Iterable<ID>)Iterable<T>
        count():long
        deleteById(id:ID):void
        delete(entity:T):void
        deleteAllById(ids:Iterable<? extends ID>):void
        deleteAll(entities:Iterable<? extends T>):void
        deleteAll():void
    All functions below extend the CrudRepository
 */

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
