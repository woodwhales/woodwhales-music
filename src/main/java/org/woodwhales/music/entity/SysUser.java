package org.woodwhales.music.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.beust.jcommander.internal.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author woodwhales on 2024-05-12 17:01
 */
@TableName(value= "sys_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 是否删除，0-已启用，1-已停用，2-已删除
     */
    @TableLogic(delval = "2")
    @TableField(value = "status")
    private Byte status;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_created")
    private java.util.Date gmtCreated;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private java.util.Date gmtModified;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 2fa密钥
     */
    @TableField(value = "two_factor_secret")
    private String twoFactorSecret;

    /**
     * 是否开启2fa：0-不开启，1-开启
     */
    @TableField(value = "two_factor_enabled")
    private boolean twoFactorEnabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Lists.newArrayList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
