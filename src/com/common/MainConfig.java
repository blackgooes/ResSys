/**
 * 
 */
package com.common;

import com.controller.UserController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.model.User;



/**
 * @author blackagooes
 *
 */
public class MainConfig extends JFinalConfig {

	/* (non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configConstant(com.jfinal.config.Constants)
	 */
	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		me.setViewType(ViewType.JSP);
		PropKit.use("config.properties");
		

	}

	/* (non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configRoute(com.jfinal.config.Routes)
	 */
	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/user", UserController.class);
	}

	/* (non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configEngine(com.jfinal.template.Engine)
	 */
	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configPlugin(com.jfinal.config.Plugins)
	 */
	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		C3p0Plugin c3p0Plugin = 
				new C3p0Plugin(PropKit.get("jdbcUrl"),PropKit.get("user"),PropKit.get("password"));
        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        arp.setShowSql(true);
        arp.addMapping("tbuser", User.class);
        me.add(c3p0Plugin);
        me.add(arp);
	}

	/* (non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configInterceptor(com.jfinal.config.Interceptors)
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configHandler(com.jfinal.config.Handlers)
	 */
	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
	}

}
