package com.fbi.cloud.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 *
 * @author cy
 * @version SecurityGroupDTO.java, v 0.1 2020年10月22日 10:54 cy Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityGroupDTO implements Serializable {

    private static final long serialVersionUID = -2638170203032535290L;

    /**
     * 组编号
     */
    private String groupCode;

    /**
     * 描述
     */
    private String description;

}
