package com.example.spring.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity // jpa를 사용할 때 선언해야함
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 알아서 생성하는것을 IDENTITY라고 한다.
    private Long id;
    private String name;

}
