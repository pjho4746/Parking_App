package com.humax.parking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private String nickname;
    private String profile;
    private String password;

    public MemberEntity(String userEmail, String nickname, String profile, String password) {
        this.userEmail = userEmail;
        this.nickname = nickname;
        this.profile = profile;
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
