package info.lavenderdawn.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import info.lavenderdawn.entities.ProductScan;
import info.lavenderdawn.helpers.ZXingHelper;
import info.lavenderdawn.services.ProductScanService;

@Controller
@RequestMapping("/productScans")
public class ProductScanController {

	@Autowired
	ProductScanService productScanService;
	
	@GetMapping
	public String displayProductScans(Model model) {
		
		Iterable<ProductScan>productScans = productScanService.findAll();
		model.addAttribute("productScans", productScans);
		
		return "productScans";
	}
	
	@GetMapping("barcode/{id}")
	public void barcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getBarCodeImage(id, 200, 200));
		outputStream.flush();
		outputStream.close();
	}
}
