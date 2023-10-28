package com.vicky.ems_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Department")
public class DepartMents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartMent_Id")
    private Long id;

    @Column(name = "DepartMent_Name")
    private String departmentName;

    @Column(name = "Department_Email", nullable = false,unique = true)
    private String departmentEmail;

}
