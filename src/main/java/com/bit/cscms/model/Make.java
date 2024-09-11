package com.bit.cscms.model;

import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Enabled
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Make {
    @Id
    private int make_id;
    private String make_name;
    private String make_description;
}
