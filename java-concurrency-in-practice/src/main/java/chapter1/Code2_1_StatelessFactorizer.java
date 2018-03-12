package chapter1;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * @author youchao.wen
 * @date 2018/3/10.
 */
public class Code2_1_StatelessFactorizer implements Servlet {


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        BigInteger i  = extractFromRequest(servletRequest);
        BigInteger[] factors = factor(i);

        encodeIntoResponse(servletResponse, factors);
    }

    public BigInteger extractFromRequest(ServletRequest req){
        return new BigInteger("10");
    }

    public BigInteger[] factor(BigInteger i){
        return new BigInteger[]{};
    }

    public void encodeIntoResponse(ServletResponse resp, BigInteger[] factors){

    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
