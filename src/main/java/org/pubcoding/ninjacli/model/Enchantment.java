package org.pubcoding.ninjacli.model;

import lombok.*;

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
    private String name;
    private School school;
    private Integer level;
    private String components;
    private String castingTime;
    private String range;
    private String target;
    private String duration;
    private String savingThrow;
    private String spellResistance;
    private String description;

}
