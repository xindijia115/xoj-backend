package com.dj.xoj.common;

import java.io.Serializable;
import lombok.Data;

/**
 * 删除请求
 *
 * xoj BY DJ
 * 2024/8/3
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}