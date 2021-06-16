package com.crystal.tmis.dto;

import lombok.Data;

@Data
public class BatchDto {
    private String name;
    private String startDate;
    private String endDate;
    private String venue;
    private String limitOfSeats;
}
