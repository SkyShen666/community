package com.nowcoder.community.dao;

import com.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * 写完LoginTicketMapper 最好做一个测试，毕竟表名、属性名啥的都没有提示，全是手打的。
 *（在开发时这一步最好加上测试，这一步是最容易犯错的地方）
 */
@Mapper
@Deprecated
public interface LoginTicketMapper {

    /**
     * useGeneratedKeys设置为 true 时，表示如果插入的表id以自增列为主键，
     * 则允许 JDBC 支持自动生成主键，并可将自动生成的主键id返回。
     * useGeneratedKeys参数只针对 insert 语句生效，默认为 false
     * @param loginTicket
     * @return
     */
    @Insert({
            "insert into login_ticket(user_id, ticket, status, expired) ",
            "values(#{userId}, #{ticket}, #{status}, #{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id, user_id, ticket, status, expired ",
            "from login_ticket where ticket = #{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    //这里的and 1 = 1 仅测试练习
    @Update({
            "<script>",
            "update login_ticket set status = #{status} where ticket = #{ticket} ",
            "<if test = \"ticket != null \"> ",
            "and 1 = 1 ",
            "</if>",
            "</script>"
    })
    int updateStatus(String ticket, int status);

}
