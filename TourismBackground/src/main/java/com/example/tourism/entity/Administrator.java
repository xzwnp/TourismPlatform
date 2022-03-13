package com.example.tourism.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * com.example.tourism.entity
 *
 * @author xzwnp
 * 2022/3/1
 * 21:59
 * Steps：
 */
@Getter
@Setter
@TableName("t_admin")
@ApiModel(value = "管理员对象", description = "")
public class Administrator {
    @TableId
    String account;
    @TableField
    String password;

    public Administrator(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Administrator() {
    }
}
