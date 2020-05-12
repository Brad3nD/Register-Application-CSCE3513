package edu.uark.registerapp.controllers;

import java.sql.*;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.products.ProductsQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.enums.EmployeeClassification;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionRouteController extends BaseRouteController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showTransaction(@RequestParam final Map<String, String> queryParameters,
	final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{
			//ModelAndView modelAndView = new ModelAndView(ViewNames.TRANSACTION.getViewName());

			final Optional<ActiveUserEntity> activeUserEntity = this.getCurrentUser(request);
			if(!activeUserEntity.isPresent())
			{
					return buildInvalidSessionResponse();
			}

			ModelAndView modelAndView =
			this.setErrorMessageFromQueryString(
				new ModelAndView(ViewNames.TRANSACTION.getViewName()),
				queryParameters);

		modelAndView.addObject(
			ViewModelNames.IS_ELEVATED_USER.getValue(),
			this.isElevatedUser(activeUserEntity.get()));

		try {
			modelAndView.addObject(
				ViewModelNames.PRODUCTS.getValue(),
				this.productsQuery.execute());
		} catch (final Exception e) {
			modelAndView.addObject(
				ViewModelNames.ERROR_MESSAGE.getValue(),
				e.getMessage());
			modelAndView.addObject(
				ViewModelNames.PRODUCTS.getValue(),
				(new Product[0]));
		}
	
		String lookupInput = "Before Get";
		lookupInput = doGet(request, response);
		System.out.println("Lookup input: " + lookupInput);

		StringBuilder builder = new StringBuilder();
		builder.append("<br>lookup Input: " + lookupInput + "<br>");

		return modelAndView;
	}

	protected String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//doGet(request, response);
		String lookupInput = request.getParameter("lookupInput"); 
		return lookupInput;
    }


	// Properties
	@Autowired
	private ProductsQuery productsQuery;	
}
