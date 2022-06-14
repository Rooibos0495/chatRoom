package com.example.my_books.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user_details")
public class SysUserDetails extends BaseModel implements Serializable {

    @TableField("user_id")
    private Integer userId;

    @TableField("user_name")
    private String userName;

    @TableField("avatar")
    private String avatar;

    @TableField("describe_user")
    private String describeUser;

    @TableField("remarks")
    private String remarks;

    @TableField("phone")
    private String phone;

    @TableField("city")
    private String city;
}
