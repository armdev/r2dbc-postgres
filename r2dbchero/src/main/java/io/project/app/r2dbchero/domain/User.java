package io.project.app.r2dbchero.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author armena
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("sn_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
     @Id
    private Long id;
   
    private String firstname;
  
    private String middlename;
   
    private String lastname;
    
    private String email;
  
    private String password;
   
    private String roleCode;
    
    private String mobileno;
   
    private String address;
    
    private String city;
    
    private String state;
    
    private String country;
    
    private String zipcode;
   
    private String ssn;
   
    private String position;
    
    private Date registerDate;
   
    private Date lastLoginDate;
   
    private Integer status;

   
}
