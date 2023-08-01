package org.pubcoding.ninjacli.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import picocli.CommandLine;


@Entity(name = "Incantesimi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Enchantment {

    @Id @Column(name = "enchantment_id")
    private Integer id;
    private String name;
    private String school;
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
