package filter;


	
	@WebFilter("/admin/*")
	public class AdminFilter implements Filter {
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
	        HttpSession session = ((HttpServletRequest) request).getSession(false);

	        if (session == null || session.getAttribute("role") != Role.ADMIN) {
	            // Accès refusé : redirige vers la page de login
	            ((HttpServletResponse) response).sendRedirect("../login.jsp");
	        } else {
	            chain.doFilter(request, response); // Accès autorisé
	        }
	    }
	}


