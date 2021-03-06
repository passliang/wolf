package com.google.style.dao.mapper.tools;


import com.google.style.model.tools.Dict;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 字典表
 * 
 * @author liangz
 * @email xx@.com
 * @date 2018-03-12 17:05:03
 */
@Mapper
@Repository
public interface DictMapper {

	@Select("select `id`, `name`, `value`, `type`, `description`, `sort`, `parent_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag` from sys_dict where id = #{id}")
    Dict get(Long id);
	
	@Select("<script>" +
	"select * from sys_dict " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  		  "<if test=\"value != null and value != ''\">"+ "and value = #{value} " + "</if>" + 
		  		  "<if test=\"type != null and type != ''\">"+ "and type = #{type} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"sort != null and sort != ''\">"+ "and sort = #{sort} " + "</if>" + 
		  		  "<if test=\"parentId != null and parentId != ''\">"+ "and parent_id = #{parentId} " + "</if>" + 
		  		  "<if test=\"createBy != null and createBy != ''\">"+ "and create_by = #{createBy} " + "</if>" + 
		  		  "<if test=\"createDate != null and createDate != ''\">"+ "and create_date = #{createDate} " + "</if>" + 
		  		  "<if test=\"updateBy != null and updateBy != ''\">"+ "and update_by = #{updateBy} " + "</if>" + 
		  		  "<if test=\"updateDate != null and updateDate != ''\">"+ "and update_date = #{updateDate} " + "</if>" + 
		  		  "<if test=\"remarks != null and remarks != ''\">"+ "and remarks = #{remarks} " + "</if>" + 
		  		  "<if test=\"delFlag != null and delFlag != ''\">"+ "and del_flag = #{delFlag} " + "</if>" + 
		  			"</where>"+ 
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by id desc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<Dict> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from sys_dict " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  		  "<if test=\"value != null and value != ''\">"+ "and value = #{value} " + "</if>" + 
		  		  "<if test=\"type != null and type != ''\">"+ "and type = #{type} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"sort != null and sort != ''\">"+ "and sort = #{sort} " + "</if>" + 
		  		  "<if test=\"parentId != null and parentId != ''\">"+ "and parent_id = #{parentId} " + "</if>" + 
		  		  "<if test=\"createBy != null and createBy != ''\">"+ "and create_by = #{createBy} " + "</if>" + 
		  		  "<if test=\"createDate != null and createDate != ''\">"+ "and create_date = #{createDate} " + "</if>" + 
		  		  "<if test=\"updateBy != null and updateBy != ''\">"+ "and update_by = #{updateBy} " + "</if>" + 
		  		  "<if test=\"updateDate != null and updateDate != ''\">"+ "and update_date = #{updateDate} " + "</if>" + 
		  		  "<if test=\"remarks != null and remarks != ''\">"+ "and remarks = #{remarks} " + "</if>" + 
		  		  "<if test=\"delFlag != null and delFlag != ''\">"+ "and del_flag = #{delFlag} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("insert into sys_dict (`name`, `value`, `type`, `description`, `sort`, `parent_id`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`)"
	+ "values (#{name}, #{value}, #{type}, #{description}, #{sort}, #{parentId}, #{createBy}, #{createDate}, #{updateBy}, #{updateDate}, #{remarks}, #{delFlag})")
	int save(Dict dict);
	
	@Update("<script>"+
			"update sys_dict " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"name != null\">`name` = #{name}, </if>" + 
                    "<if test=\"value != null\">`value` = #{value}, </if>" + 
                    "<if test=\"type != null\">`type` = #{type}, </if>" + 
                    "<if test=\"description != null\">`description` = #{description}, </if>" + 
                    "<if test=\"sort != null\">`sort` = #{sort}, </if>" + 
                    "<if test=\"parentId != null\">`parent_id` = #{parentId}, </if>" + 
                    "<if test=\"createBy != null\">`create_by` = #{createBy}, </if>" + 
                    "<if test=\"createDate != null\">`create_date` = #{createDate}, </if>" + 
                    "<if test=\"updateBy != null\">`update_by` = #{updateBy}, </if>" + 
                    "<if test=\"updateDate != null\">`update_date` = #{updateDate}, </if>" + 
                    "<if test=\"remarks != null\">`remarks` = #{remarks}, </if>" + 
                    "<if test=\"delFlag != null\">`del_flag` = #{delFlag}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(Dict dict);
	
	@Delete("delete from sys_dict where id =#{id}")
	int remove(Long id);
	
	@Delete("<script>"+
			"delete from sys_dict where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);

    /**
     * 获取 type 描述信息
     * @return
     */
	@Select("\t\tselect distinct `type` , description from sys_dict\n")
	List<Dict>listType();
}
