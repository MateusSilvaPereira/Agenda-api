package com.msp.agenda.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    public interface CreateUser{}
    public interface UpdateUser{}
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id; 


    @Column(name = "username", length = 100, nullable = false)
    @NotNull(groups = CreateUser.class)
    @NotEmpty
    @Size(groups = CreateUser.class, min = 2, max = 100)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @NotNull(groups = {CreateUser.class, UpdateUser.class})
    @NotEmpty(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 8, max = 60)
    @Column(name = "password", length= 60, nullable = false)
    private String password;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<Task>();

}
