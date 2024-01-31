package me.ndPrince.routeOptimization;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    protected Employee() {}

    public Employee(String name){
        this.name = name;
    }
}
