package com.tsi.richard.stanleybloom.program;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.util.Optional;

@EnableTransactionManagement
@Entity
@Qualifier("actor")
@Repository
@Table(name = "actor")

public class Actor implements ActorRepository{
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int actor_id;

    //Attributes
    public String first_name;
    public String last_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //Constructor
    public Actor(String first_name, String last_name){

        this.first_name=first_name;
        this.last_name=last_name;
    }
    public Actor(){}

    //Methods
    //getters and setters

    public int getActor_id(){
        return actor_id;
    }

    public void setActor_id(int actor_id){
        this.actor_id = actor_id;
    }

    public String getFirst_name(){
        return first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }



    @Override
    public <S extends Actor> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Actor> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Actor> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Actor> findAll() {
        return null;
    }

    @Override
    public Iterable<Actor> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Actor entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Actor> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
