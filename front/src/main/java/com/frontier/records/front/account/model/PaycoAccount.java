package com.frontier.records.front.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@SuppressWarnings("CheckStyle")
@Getter
@Entity
@Table
public class PaycoAccount {

    @Id
    @Column(name = "payco_id_no", nullable = false, unique = true)
    private String paycoIdNo;

    @Column(name = "id")
    private String id;

    @Column(name = "mobile_id")
    private String mobileId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sex_code", nullable = false)
    private String sexCode;

    @Column(name = "birthday_mmdd")
    private String birthdayMMDD;

    @Column(name = "age_group")
    private String ageGroup;

    @Column(name = "account_seq", nullable = false, unique = true)
    private Long accountSeq;
}
