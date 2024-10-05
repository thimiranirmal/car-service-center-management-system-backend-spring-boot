package com.bit.cscms.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Make {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int make_id;
    private String make_name;
    private String make_description;
    @Lob
    @Column(length = 1000000000)
    private byte[] make_img;
}
