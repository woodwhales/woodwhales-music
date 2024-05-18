package org.woodwhales.music.model;

import lombok.Data;

/**
 * @author woodwhales on 2024-05-18 22:07
 */
@Data
public class UserMeVo {

    private String username;

    private boolean twoFactorEnabled;

}
