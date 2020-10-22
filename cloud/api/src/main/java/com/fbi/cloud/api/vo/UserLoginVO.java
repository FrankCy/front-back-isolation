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
 * @version UserLoginVO.java, v 0.1 2020年10月21日 15:08 cy Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVO implements Serializable {

    private static final long serialVersionUID = 558880313383830594L;

    private Integer id;
}
