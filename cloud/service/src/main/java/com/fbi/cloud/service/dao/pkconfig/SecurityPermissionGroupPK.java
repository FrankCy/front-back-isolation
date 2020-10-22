package com.fbi.cloud.service.dao.pkconfig;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 *
 * @author cy
 * @version HistoryPK.java, v 0.1 2020年10月21日 15:16 cy Exp $
 */
@Getter
@Setter
public class SecurityPermissionGroupPK implements Serializable  {

    private static final long serialVersionUID = -6493270596494150797L;

    /**
     * ID
     */
    private Long id;

    /**
     * 权限ID
     */
    private Long securityPermissionId;

    /**
     * 安全组ID
     */
    private Long securityGroupId;

}
