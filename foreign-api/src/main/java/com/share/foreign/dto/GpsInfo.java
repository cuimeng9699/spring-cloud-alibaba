package com.share.foreign.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GpsInfo {
    private double lat;
    private double lon;
}
