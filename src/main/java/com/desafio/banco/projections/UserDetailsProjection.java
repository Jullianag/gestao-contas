package com.desafio.banco.projections;

public interface UserDetailsProjection {

    String getUsername();
    String getPassword();
    String getRoleId();
    String getAuthority();
}
