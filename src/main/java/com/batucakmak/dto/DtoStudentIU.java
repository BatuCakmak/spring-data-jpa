package com.batucakmak.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class DtoStudentIU {

    @NotEmpty(message = "Firstname alanı boş bırakılamaz!")
    @NotNull(message = "Firstname alanı null olamaz !")
    @Min(value = 3)
    @Max(value = 10)
    private String firstName;

    @Size(min = 3,max = 30)
    private String lastName;

    private Date birthOfDate;

    @Email(message = "Email formatında bir adres giriniz")
    private String email;

    @Size(min=11 , max = 11,message = "Tckn alanı 11 karakter olmalıdır")
    @NotEmpty(message = "Tckn alanı boş geçirelemez")
    private  String tckn;
}
