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
 * @version ProjectVO.java, v 0.1 2020年10月20日 15:21 cy Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectVO implements Serializable {
    private static final long serialVersionUID = 2852147133930444144L;

    private Integer id;

}
