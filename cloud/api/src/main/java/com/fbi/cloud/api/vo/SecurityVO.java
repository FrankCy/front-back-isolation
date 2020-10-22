package com.fbi.cloud.api.vo;

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
 * @version SecurityVO.java, v 0.1 2020年10月21日 15:08 cy Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityVO implements Serializable {

    private static final long serialVersionUID = -9210097121742796702L;

    private Integer id;
}
