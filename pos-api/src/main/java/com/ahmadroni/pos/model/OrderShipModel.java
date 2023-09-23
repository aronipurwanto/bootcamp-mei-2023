package com.ahmadroni.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderShipModel {
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;
}
