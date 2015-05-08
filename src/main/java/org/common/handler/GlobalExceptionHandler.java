package org.common.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 例外ハンドラ―
 * 
 * @author 0A9334
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, Object obj, Exception ex) {

		// エラー画面遷移
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("message", ex.getMessage());

		String detail = detailMessage(ex);
		modelView.addObject("messageDetail", detail);

		modelView.setViewName("errors/systemError");

		// ログも出力
		ex.printStackTrace();

		return modelView;
	}

	private String detailMessage(Exception ex) {
		StringWriter strWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(strWriter);
		String detail = "";

		try {
			ex.printStackTrace(writer);
			detail = strWriter.toString();

			if (strWriter != null) {
				strWriter.flush();
				strWriter.close();
			}

			if (writer != null) {
				writer.flush();
				writer.close();
			}

		} catch (IOException ignore) {
		}

		return detail;
	}
}
