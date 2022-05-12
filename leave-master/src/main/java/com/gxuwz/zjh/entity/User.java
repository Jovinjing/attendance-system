package com.gxuwz.zjh.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * 管理员表
 */
@Data
@Alias("User") //别名
public class User extends Thing{

    @ApiModelProperty(value = "账号")
    private String userId;

    @ApiModelProperty(value = "姓名")
    private String fullName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话")
    private String telephone;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @Override
    public String getId() {
        return this.userId;
    }

    @Override
    public void setId(String id) {
        this.userId = id;
    }

    @Override
    public String toString() {
        return "user";
    }

}
