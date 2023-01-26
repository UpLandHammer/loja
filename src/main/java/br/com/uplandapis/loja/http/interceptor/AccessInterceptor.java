package br.com.uplandapis.loja.http.interceptor;

import br.com.uplandapis.loja.http.dtos.AccessDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;

public class AccessInterceptor implements HandlerInterceptor {

    private StopWatch watch;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        watch = new StopWatch();

        watch.start();

        AccessDTO accessDTO = AccessDTO.builder()
                .uri(request.getRequestURI())
                .username(request.getRemoteUser())
                .host(request.getRemoteHost())
                .local(request.getLocalName())
                .build();

        request.setAttribute("accessDTO", accessDTO);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        AccessDTO accessDTO = (AccessDTO) request.getAttribute("accessDTO");
        watch.stop();
        accessDTO.setElapsedTime(String.valueOf(watch.getTotalTimeSeconds()));
        System.out.println(accessDTO);
    }
}
