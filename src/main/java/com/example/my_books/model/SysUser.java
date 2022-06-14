package com.example.my_books.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;


import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * 管理用户表(SysUser)��ʵ����
 *
 * @author makejava
 * @since 2022-04-15 10:46:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser extends BaseModel implements Serializable {

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 状态（1.禁用 2.正常）
     */
    @TableField("start")
    private Integer start;

    /**
     * 是否管理员(0.否 1.是)
     */
    @TableField("is_admin")
    private Integer isAdmin;
}
