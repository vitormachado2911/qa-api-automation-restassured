package filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class PrettyLogFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification req,FilterableResponseSpecification res,FilterContext ctx) {

        long start = System.currentTimeMillis();
        Response response = ctx.next(req, res);
        long elapsed = System.currentTimeMillis() - start;
        String method = req.getMethod();
        String uri = req.getURI();
        int status = response.getStatusCode();
        String symbol = (status >= 200 && status < 400) ? "✅" : "❌";
        System.out.printf("%s %s %s -> %d (%d ms)%n", symbol, method, uri, status, elapsed);
        return response;
    }
}
