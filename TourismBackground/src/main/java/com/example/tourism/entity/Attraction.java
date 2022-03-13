package com.example.tourism.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-03-01
 */
@Getter
@Setter
@TableName("t_attraction")
@ApiModel(value = "Attraction对象", description = "")
public class Attraction implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("景点名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("景点位置id")
    @TableField("location_id")
    private Integer locationId;

    @ApiModelProperty("景点封面图片")
    @TableField("picture")
    private String picture;

    @ApiModelProperty("景点地址")
    @TableField("address")
    private String address;
    @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;

    /**
     * LocalDateTime并不能通过设置spring.jackson.date-format来指定格式
     */
    @ApiModelProperty("创建时间")
    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    @ApiModelProperty("更新时间")
    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;


}
