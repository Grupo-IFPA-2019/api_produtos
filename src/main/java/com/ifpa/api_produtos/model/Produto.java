package com.ifpa.api_produtos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//sobrescreve o equal and hashCode com lombok
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
// podemos dar um nome para a tabela que seja diferente do nome da classe
@Table(name = "Produto")
public class Produto {
     //inclui na sobrescrição do metodo equals e hashcode
     @EqualsAndHashCode.Include
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
 
     @NotBlank
     @Size(max = 60)
     private String nomeProduto;
 
     @NotBlank
     @Size(max = 255)
     private String precoProduto;
}
