package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDetails {
    private Integer actorId;
    private String actorName;
    private  String actorAddrs;
    private  Long phone;
    private  Double  remuneration;
}
