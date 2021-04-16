package com.nt.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class PoliticalParty {
   private Integer partyId;
   @NonNull
   private String flagColors;
   @NonNull
   private  String partyName;
   @NonNull
   private  String partySymbol;
   
   
   
   
   
}
