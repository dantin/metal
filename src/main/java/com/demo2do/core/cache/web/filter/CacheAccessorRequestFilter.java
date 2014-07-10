package com.demo2do.core.cache.web.filter;

import com.demo2do.core.cache.CacheAccessor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * Filter to enable cache accessor in all JSP page
 */
public class CacheAccessorRequestFilter implements Filter {

    private static final String URL_SUFFIX = ".jsp";

    private CacheAccessor cacheAccessor;

    /**
     * initialize cache accessor from Spring container
     *
     * @param filterConfig
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        this.cacheAccessor = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getBean(CacheAccessor.class);
    }

    /**
     * filter all JSP page
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if (httpServletRequest.getRequestURI().endsWith(URL_SUFFIX))
            httpServletRequest = new CacheAccessorRequestWrapper(httpServletRequest, cacheAccessor);

        chain.doFilter(httpServletRequest, response);
    }

    /**
     * destory of filter
     */
    public void destroy() {

    }

    /**
     * Wrapper of Cache Accessor
     */
    private static class CacheAccessorRequestWrapper extends HttpServletRequestWrapper {

        private static final Log logger = LogFactory.getLog(CacheAccessorRequestWrapper.class);

        private CacheAccessor cacheAccessor;

        /**
         * constructor
         *
         * @param request
         */
        public CacheAccessorRequestWrapper(HttpServletRequest request, CacheAccessor cacheAccessor) {
            super(request);
            this.cacheAccessor = cacheAccessor;
        }

        /*
         * (non-Javadoc)
         *
         * @see
         * javax.servlet.ServletRequestWrapper#getAttribute(java.lang.String)
         */
        public Object getAttribute(String name) {

            // if attribute name is in cache accessor, then return the attribute value
            if (cacheAccessor.contains(name)) {

                if (logger.isDebugEnabled()) {
                    logger.debug("CacheAccessor contains key .. " + name + ", will return from Cache.");
                }

                return cacheAccessor.evaluate(name);
            }

            return super.getAttribute(name);
        }

    }
}
