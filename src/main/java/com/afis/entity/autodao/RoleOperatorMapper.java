package com.afis.entity.autodao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.afis.entity.automodel.RoleOperator;
import com.afis.entity.automodel.RoleOperatorExample;
import com.afis.entity.automodel.RoleOperatorKey;
@Mapper
public interface RoleOperatorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    long countByExample(RoleOperatorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    int deleteByExample(RoleOperatorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    int deleteByPrimaryKey(RoleOperatorKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    int insert(RoleOperator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    int insertSelective(RoleOperator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    List<RoleOperator> selectByExampleWithRowbounds(RoleOperatorExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    List<RoleOperator> selectByExample(RoleOperatorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    RoleOperator selectByPrimaryKey(RoleOperatorKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    int updateByExampleSelective(@Param("record") RoleOperator record, @Param("example") RoleOperatorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    int updateByExample(@Param("record") RoleOperator record, @Param("example") RoleOperatorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    int updateByPrimaryKeySelective(RoleOperator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_ROLE_OPERATOR
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    int updateByPrimaryKey(RoleOperator record);
}