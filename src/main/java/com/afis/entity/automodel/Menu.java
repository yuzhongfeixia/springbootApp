package com.afis.entity.automodel;

public class Menu {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SN_MENU.ID
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SN_MENU.NAME
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SN_MENU.PARENT_ID
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SN_MENU.FUNCTION
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    private String function;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SN_MENU.CLIENT_TYPE
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    private String clientType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SN_MENU.REMARK
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SN_MENU.ID
     *
     * @return the value of T_SN_MENU.ID
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SN_MENU.ID
     *
     * @param id the value for T_SN_MENU.ID
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SN_MENU.NAME
     *
     * @return the value of T_SN_MENU.NAME
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SN_MENU.NAME
     *
     * @param name the value for T_SN_MENU.NAME
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SN_MENU.PARENT_ID
     *
     * @return the value of T_SN_MENU.PARENT_ID
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SN_MENU.PARENT_ID
     *
     * @param parentId the value for T_SN_MENU.PARENT_ID
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SN_MENU.FUNCTION
     *
     * @return the value of T_SN_MENU.FUNCTION
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public String getFunction() {
        return function;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SN_MENU.FUNCTION
     *
     * @param function the value for T_SN_MENU.FUNCTION
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public void setFunction(String function) {
        this.function = function;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SN_MENU.CLIENT_TYPE
     *
     * @return the value of T_SN_MENU.CLIENT_TYPE
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SN_MENU.CLIENT_TYPE
     *
     * @param clientType the value for T_SN_MENU.CLIENT_TYPE
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SN_MENU.REMARK
     *
     * @return the value of T_SN_MENU.REMARK
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SN_MENU.REMARK
     *
     * @param remark the value for T_SN_MENU.REMARK
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SN_MENU
     *
     * @mbg.generated Fri Jul 14 14:58:26 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", parentId=").append(parentId);
        sb.append(", function=").append(function);
        sb.append(", clientType=").append(clientType);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}