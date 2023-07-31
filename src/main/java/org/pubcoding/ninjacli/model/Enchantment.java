package org.pubcoding.ninjacli.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Incantesimi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Enchantment {

    @Id private Integer id;
    @Column private String name;
    @Column private School school;
    @Column private Integer level;
    @Column private String components;
    @Column private String castingTime;
    @Column private String range;
    @Column private String target;
    @Column private String duration;
    @Column private String savingThrow;
    @Column private String spellResistance;
    @Column private String description;

}
