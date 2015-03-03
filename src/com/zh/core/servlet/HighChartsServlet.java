package com.zh.core.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.fop.svg.PDFTranscoder;

/**
 * 
 * Servlet implementation class for the batik Transcoder
 * 
 * 
 * 
 * @Thanks wufeng
 * 
 * @author zxw 2011-5-29上午03:54:39
 */

public class HighChartsServlet extends HttpServlet {

	private static final long serialVersionUID = 3920224595120519682L;

	public HighChartsServlet() {

		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,

	IOException {

		request.setCharacterEncoding("utf-8");// 注意编码

		String type = request.getParameter("type");

		String svg = request.getParameter("svg");
		
		String fileName = request.getParameter("filename");

		ServletOutputStream out = response.getOutputStream();
		OutputStreamWriter writer = null;

		try {
			if (null != type && null != svg) {
				svg = svg.replaceAll(":rect", "rect");
				String ext = "";
				Transcoder t = null;
				if (type.equals("image/png")) {
					ext = "png";
					t = new PNGTranscoder();
				} else if (type.equals("image/jpeg")) {
					ext = "jpg";
					t = new JPEGTranscoder();
				} else if (type.equals("application/pdf")) {
					ext = "pdf";
					t = new PDFTranscoder();
				} else if (type.equals("image/svg+xml")) {
					ext = "svg";
				}
				response.addHeader("Content-Disposition",
						"attachment; filename="+ new String(fileName.getBytes("GBK"), "ISO8859-1") +"." + ext);
				response.addHeader("Content-Type", type);
				if (null != t) {
					TranscoderInput input = new TranscoderInput(
							new StringReader(svg));
					TranscoderOutput output = new TranscoderOutput(out);
					try {
						t.transcode(input, output);
					} catch (TranscoderException e) {
						out.print("Problem transcoding stream. See the web logs for more details.");
						e.printStackTrace();
					}
				} else if (ext == "svg") {
					writer = new OutputStreamWriter(out, "UTF-8");
					writer.append(svg);
				} else {
					out.print("Invalid type: " + type);
				}

			} else {
				response.addHeader("Content-Type", "text/html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
			if (null != writer) {
				writer.flush();
				writer.close();
			}
		}
	}
}
