package com.zxcv.busi.configs.druid;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySources;

/**
 * 数据库连接属性.<br/>
 * 
 * Copyright: Copyright (c) 2017  ZTE-ITS
 * 
 * @ClassName: AmountUtils.java
 * @Description: 
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2018年1月7日
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2018年1月7日      wangfs           v1.0.0               创建
 */
@ConfigurationProperties(prefix = "druid")
public class DruidProperties {

	/**连接数据库的url.*/
	private String url;
	/**连接数据库的用户名.*/
	private String username;
	/**连接数据库的密码.*/
	private String password;
	/**这一项可配可不配，如果不配置druid会根据url自动识别dbType，然后选择相应的driverClassName.*/
	private String driverClass;
	/**属性类型是字符串，通过别名的方式配置扩展插件， 常用的插件有：监控统计用的filter:stat 日志用的filter:log4j 防御sql注入的filter:wall.*/
	private String filters;
	/**用来检测连接是否有效的sql，要求是一个查询语句。 
      *如果validationQuery为null，testOnBorrow、testOnReturn、 
      *testWhileIdle都不会其作用.*/
	private String validationQuery;
	/**最大连接池数量.*/
	private int maxActive;
	/**最小连接池储量.*/
	private int minIdle;
	/**初始化时建立物理连接的个数.*/
	private int initialSize;
	/**Destory线程中如果检测到当前连接的最后活跃时间和当前时间的差值大于该值，则关闭当前连接.*/
	private int minEvictableIdleTimeMillis;
	/**Destroy线程会检测连接的间隔时间(毫秒).*/
	private int timeBetweenEvictionRunsMillis;
	/**获取连接时最大等待时间，单位毫秒.*/
	private int maxWait;
	/**申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能.*/
	private boolean testOnBorrow;
	/**归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能.*/
	private boolean testOnReturn;
	/**建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效.*/
	private boolean testOnWhileIdle;
	/**打开PSCache，.*/
	private boolean poolPreparedStatements;
	/**PSCache指定每个连接上PSCache的大小.*/
	private int maxPoolPreparedStatementPerConnectionSize;
	
	
	
	public boolean isPoolPreparedStatements() {
		return poolPreparedStatements;
	}

	public void setPoolPreparedStatements(boolean poolPreparedStatements) {
		this.poolPreparedStatements = poolPreparedStatements;
	}

	public int getMaxPoolPreparedStatementPerConnectionSize() {
		return maxPoolPreparedStatementPerConnectionSize;
	}

	public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
		this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public boolean isTestOnWhileIdle() {
		return testOnWhileIdle;
	}

	public void setTestOnWhileIdle(boolean testOnWhileIdle) {
		this.testOnWhileIdle = testOnWhileIdle;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	@Override
	public String toString() {
		return "DruidProperties [url=" + url + ", username=" + username + ", password=" + password + ", driverClass="
				+ driverClass + ", filters=" + filters + ", validationQuery=" + validationQuery + ", maxActive="
				+ maxActive + ", minIdle=" + minIdle + ", initialSize=" + initialSize + ", minEvictableIdleTimeMillis="
				+ minEvictableIdleTimeMillis + ", timeBetweenEvictionRunsMillis=" + timeBetweenEvictionRunsMillis
				+ ", maxWait=" + maxWait + ", testOnBorrow=" + testOnBorrow + ", testOnReturn=" + testOnReturn
				+ ", testOnWhileIdle=" + testOnWhileIdle + ", poolPreparedStatements=" + poolPreparedStatements
				+ ", maxPoolPreparedStatementPerConnectionSize=" + maxPoolPreparedStatementPerConnectionSize + "]";
	}
	
	
}
