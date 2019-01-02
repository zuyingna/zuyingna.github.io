package com.zyn.shopping.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyn.shopping.dao.IProductDAO;
import com.zyn.shopping.dao.impl.ProductDAOImpl;
import com.zyn.shopping.domain.Product;
import com.zyn.shopping.domain.ProductDir;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private IProductDAO dao;
	private static final long serialVersionUID = 1L;

	// 用?cmd=操作名来控制跳转
	public void init() throws ServletException {
		dao = new ProductDAOImpl();
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd = req.getParameter("cmd");
		if ("edit".equals(cmd)) {
			this.edit(req, resp);
		} else if ("saveOrUpdate".equals(cmd)) {
			this.saveOrUpdate(req, resp);
		} else if ("delete".equals(cmd)) {
			this.delete(req, resp);
		} else {
			this.list(req, resp);
		}

	}

	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> list = dao.list();
		req.setAttribute("product", list);
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);

	}

	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product p = new Product();
		this.request2Obj(req, p);
		String id = req.getParameter("id");
		if (hasLength(id)) {
			p.setId(Long.valueOf(id));
			dao.update(p);
		} else {
			dao.save(p);
		}
		resp.sendRedirect("/product");
	}

	private void request2Obj(HttpServletRequest req, Product p) {
		String productName = req.getParameter("productName");
		String dir_id = req.getParameter("dir_id");
		String brand = req.getParameter("brand");
		String salePrice = req.getParameter("salePrice");
		String supplier = req.getParameter("supplier");
		String cutoff = req.getParameter("cutoff");
		String costPrice = req.getParameter("costPrice");
		p.setProductName(productName);
		p.setBrand(brand);
		p.setSalePrice(new BigDecimal(salePrice));
		p.setSupplier(supplier);
		p.setCutoff(Double.valueOf(cutoff));
		p.setCostPrice(new BigDecimal(costPrice));
		if (hasLength(dir_id)) {
			ProductDir dir=new ProductDir();
			dir.setId(Long.valueOf(dir_id));
			p.setDir(dir);
		}
		
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		if (hasLength(id)) {
			dao.delete(Long.valueOf(id));
		}
		resp.sendRedirect("/product");
	}

	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (hasLength(id)) {
			Product product=dao.get(Long.valueOf(id));
			req.setAttribute("product", product);
		}
		
		
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);

	}
	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}


}
