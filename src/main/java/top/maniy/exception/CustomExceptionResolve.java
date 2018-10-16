package top.maniy.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器的自定义的实现类
 * @author liuzonghua
 * @Package top.maniy.exception
 * @Description:
 * @date 2018/10/16 21:45
 */
public class CustomExceptionResolve implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView mav=new ModelAndView();
        //判断异常类型
        if(e instanceof  MessageException){
            //预测异常
            MessageException me= (MessageException) e;
            mav.addObject("error",me.getMsg());
        }else {
            mav.addObject("error","未知异常");
        }

        mav.setViewName("error");
        return mav;
    }
}
