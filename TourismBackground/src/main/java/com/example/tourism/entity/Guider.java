package com.example.tourism.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("t_guider")
@ApiModel(value = "Guider对象", description = "")
public class Guider implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("导游名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("工作年数")
    @TableField("work_years")
    private Integer workYears;

    @ApiModelProperty("导游简介")
    @TableField("intro")
    private String intro;

    @ApiModelProperty("头衔 1铜牌导游 2银牌导游 3金牌导游")
    @TableField("title")
    private int title;

    @ApiModelProperty("导游头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty("创建时间")
    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    @ApiModelProperty("更新时间")
    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;

}
