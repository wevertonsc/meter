package com.viotas.server.model;

/*
- - - - - - - - - - - - - - - - - - - - - -
 Viotas Assessment
- - - - - - - - - - - - - - - - - - - - - -
 Candidate: Weverton de Souza Castanho
 Email: wevertonsc@gmail.com
 Data: 21.APRIL.2021
- - - - - - - - - - - - - - - - - - - - - -
*/

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Meter {
    private String meterId;
    private int measure;
    private String time;
}
