package com.google.style.model.system;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @date 20180302 17:09
 * @author liangz
 * 角色
 */

@Data
@ToString
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 角色名称
     */
	private String roleName;
    /**
     * 角色标识
     */
	private String roleSign;
    /**
     *创建者
     */
	private String createBy;
    /**
     * 创建时间
     */
	private Timestamp createTime;
    /**
     * 更新时间
     */
	private Timestamp updateTime;
	private List<Long> menuIds;
    /**
     * 备注
     */
	private String remark;





}
