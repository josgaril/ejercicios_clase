package mvc.filtros;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/admin/*" })
public class LoginFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		HttpSession session = httpRequest.getSession();
		
		if(session.getAttribute("usuario") == null) {
			session.setAttribute("alertatexto", "Necesitas iniciar sesión para entrar en admin");
			session.setAttribute("alertanivel", "danger");
			
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
			return;
		}
		// pass the request along the filter chain
		// Ejecuta como si no hubiera filtro
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
