package com.OnlineFashionStore.customer.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.OnlineFashionStore.customer.jpa.Customer;
import com.OnlineFashionStore.customer.jpa.CustomerRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class ReportService {

	@Autowired
	CustomerRepository customerRep;
	
	 @Autowired
	 @Qualifier("jdbcTemplate")
	 private JdbcTemplate jdbcTemplate;
	
	public void exportCustomerFullDetailReport(String reportFormat) throws FileNotFoundException, JRException {
		
        String path = "C:\\Users\\User\\Desktop\\ARIAT Reports\\Customer Reports";
        
        List<Customer> customers = customerRep.findAll();
        
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:reports/customer_list_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customers);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "A001 Rukshan");
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\Customer_full detail.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Customer_full detail.pdf");
        }             
    }
	
	public void exportCustomerProvincesReport(String reportFormat) throws FileNotFoundException, JRException, SQLException {
		
		
        String path = "C:\\Users\\User\\Desktop\\ARIAT Reports\\Customer Reports";
       
			Connection conn = jdbcTemplate.getDataSource().getConnection();
			
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:reports/customer_detail_chart.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        
        //List customersByProvinces = customerRep.customersByProvinces();
        //if(customersByProvinces.isEmpty()==true) {System.out.println("customersByProvinces is empty!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
        //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customersByProvinces);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "A001 Rukshan");
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\Customers_by Provinces.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Customers_by Provinces.pdf");
        }             
    }
}
