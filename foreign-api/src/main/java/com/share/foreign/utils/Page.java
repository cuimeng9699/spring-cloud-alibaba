package com.share.foreign.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Mr.Cui
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Page implements Serializable {
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 总页数
     */
    @Builder.Default
    private Long totalCount = 0L;
    

}
