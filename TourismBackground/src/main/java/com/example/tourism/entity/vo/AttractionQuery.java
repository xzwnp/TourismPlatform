package com.example.tourism.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * com.example.tourism.entity.vo
 *
 * @author xzwnp
 * 2022/3/2
 * 15:24
 * 封装了景点的相关条件查询参数
 */
@Setter
@Getter
public class AttractionQuery {
    private String name;
    private int locationId;
    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    //注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    //日期格式应当为yyyy-MM-dd或yyyy-MM-dd HH:mm:ss
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;

}
