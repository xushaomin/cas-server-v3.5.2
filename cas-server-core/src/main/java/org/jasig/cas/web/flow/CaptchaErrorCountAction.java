package org.jasig.cas.web.flow;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

@SuppressWarnings("deprecation")
public final class CaptchaErrorCountAction extends AbstractAction {
	
	protected static final Log log = LogFactory.getLog(CaptchaErrorCountAction.class);

	private SimpleJdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	private String sql;

	protected Event doExecute(final RequestContext context) {
		try {
			getJdbcTemplate().update(this.sql, new Object[]{new Date(), "登录失败"});
		} catch (Exception e) {
			log.error(e);
		}
		return success();
	}

	public final void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}

	protected final SimpleJdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	protected final DataSource getDataSource() {
		return this.dataSource;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
}

