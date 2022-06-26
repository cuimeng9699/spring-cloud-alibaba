package com.share.foreign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName GroupDTO
 * @Description TODO
 * @Author Mr.Cui
 * @Date 6/21/22 7:39 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDTO {
    private long id;
    private BigDecimal money;
}
